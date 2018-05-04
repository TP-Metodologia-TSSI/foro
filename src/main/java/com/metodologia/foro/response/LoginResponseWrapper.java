package com.metodologia.foro.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponseWrapper {

    @JsonProperty
    private String sessionId;

    public LoginResponseWrapper(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

}
