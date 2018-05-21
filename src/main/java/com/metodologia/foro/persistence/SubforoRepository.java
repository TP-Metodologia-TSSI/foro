package com.metodologia.foro.persistence;

import com.metodologia.foro.model.Subforo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubforoRepository extends JpaRepository<Subforo, Long>{

    @Query( value = "SELECT * FROM subforo WHERE titulo = :titulo",
            nativeQuery = true,
            name = "findByTitulo")
    Optional<Subforo> findByTitulo(@Param("titulo") String titulo);
}
