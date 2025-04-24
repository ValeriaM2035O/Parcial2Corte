package com.example.Parcial2.Repository;

import com.example.Parcial2.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

    void deleteById(int id);

    boolean existsById(int id);

    @Query(value = """
            SELECT 
              p.id_partido,
              p.fecha_partido,       -- ← aquí el nombre real
              p.estadio,
              el.nombre   AS equipo_local,
              ev.nombre   AS equipo_visita,
              p.goles_local,
              p.goles_visita
            FROM partido p
              JOIN equipo el ON p.equipo_local = el.id_equipo
              JOIN equipo ev ON p.equipo_visita = ev.id_equipo
            """,
            nativeQuery = true
    )
    List<Object[]> getResultadosConNombresDeEquipos();
}