package com.metodologia.foro.utils;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.metodologia.foro.entities.Usuario;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

@Service
public class SessionData {
    static final Logger LOGGER = LogManager.getLogger(SessionData.class);
    private HashMap<String, AuthenticationData> sessionData;

    @Value("${session.expiration}")
    private int expirationTime;


    public SessionData() {
        this.sessionData = new HashMap<String, AuthenticationData>();
    }

    public String addSession(Usuario usuario) {
        String sessionId = UUID.randomUUID().toString();
        AuthenticationData aData = new AuthenticationData();
        aData.setUsuario(usuario);
        aData.setLastAction(new Date());
        this.sessionData.put(sessionId, aData);
        return sessionId;
    }


    public void removeSession(String sessionId) {
        sessionData.remove(sessionId);
    }

    public AuthenticationData getSession(String sessionId) {
        AuthenticationData aData = this.sessionData.get(sessionId);
        if (aData != null) {
                return aData;
        } else {
            return null;
        }
    }

    @Scheduled(fixedRate = 5000)
    public void checkSessions() {
        System.out.println("Checking sessions");
        Set<String> sessionsId = this.sessionData.keySet();
        for (String sessionId : sessionsId) {
            AuthenticationData aData = this.sessionData.get(sessionId);
            if (aData.getLastAction().
                    before(Date.from(LocalDateTime.ofInstant(new Date().toInstant().minusSeconds(expirationTime), ZoneId.systemDefault()).toInstant(null)))) {
                System.out.println("Deleting sessionId = " + sessionId);
                this.sessionData.remove(sessionId);
            }
        }
    }
}
