package com.metodologia.foro.entities;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "temas")
public class Tema {
    private int id;
	private String titulo;
	private String descripcion;
	private Date fecha;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    @Column(name = "titulo", nullable = false, length = 30)
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Column(name = "descripcion", nullable = false, length = 30)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "fecha", nullable = false)
    public Date getFechaSubscripcion() {
        return fecha;
    }

    @ManyToOne
    @JoinColumn(name = "id_subforo")
    private Subforo subforo;
    
    public Subforo getSubforo() {
    	return subforo;
    }

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    public Usuario getUsuario() {
    	return usuario;
    }
}
