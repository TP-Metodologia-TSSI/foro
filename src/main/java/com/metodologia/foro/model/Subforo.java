package com.metodologia.foro.model;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "subforo")
public class Subforo {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "titulo", unique = true, nullable = false, length = 30)
    private String name;

    @Column(name = "fecha", nullable = false)
    private Date fechaCreacion;
    
    @ManyToMany
    @JoinTable(name = "subforo_moderador", joinColumns = {
            @JoinColumn(name = "id_subforo", referencedColumnName = "ID") }, inverseJoinColumns = {
            @JoinColumn(name = "id_usuario", referencedColumnName = "ID") })
    private List<Usuario> moderadores;

    public Subforo(long id, String name, Date fechaCreacion) {
        this.id = id;
        this.name = name;
        this.fechaCreacion = fechaCreacion;
    }

    public Subforo(String name) {
        this.name = name;
        this.fechaCreacion = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean getModerador(long id) {
    	for (Usuario u : moderadores) {
    		if (u.getId() == id) {
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public void addModerador(Usuario usuario) {
    	moderadores.add(usuario);
    }
    
    public void deleteModerador(long id) {
    	for (Usuario u : moderadores) {
    		if (u.getId() == id) {
    			System.out.println("HOLA");
    			
    			moderadores.remove(u);
    		}
    	}
    }

    public String getFechaCreacion() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(this.fechaCreacion);
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
