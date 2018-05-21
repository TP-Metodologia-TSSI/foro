package com.metodologia.foro.persistence;

import com.metodologia.foro.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    @Query( value = "SELECT * FROM usuario WHERE nombre = :nombre",
            nativeQuery = true,
            name = "findByName")
    public Usuario findByName(@Param("nombre") String nombre);
}
