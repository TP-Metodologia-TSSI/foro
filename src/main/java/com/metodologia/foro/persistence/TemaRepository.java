package com.metodologia.foro.persistence;

import com.metodologia.foro.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{
    @Query( value = "SELECT * FROM tema WHERE id_subforo = :id_subforo",
            nativeQuery = true,
            name = "findBySubforo")
    List<Tema> findBySubforo(@Param("id_subforo")long id_subforo);

    @Query( value = "SELECT * FROM tema WHERE titulo = :titulo",
            nativeQuery = true,
            name = "findByTitulo")
    Optional<Tema> findByTitulo(@Param("titulo")String titulo);
}
