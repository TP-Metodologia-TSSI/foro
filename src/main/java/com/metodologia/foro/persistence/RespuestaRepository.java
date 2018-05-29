package com.metodologia.foro.persistence;

import com.metodologia.foro.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long>{

    @Query( value = "SELECT * FROM respuesta WHERE id_tema = :id_tema",
            nativeQuery = true,
            name = "findByTema")
    List<Respuesta> findByTema(@Param("id_tema")long id_tema);
}
