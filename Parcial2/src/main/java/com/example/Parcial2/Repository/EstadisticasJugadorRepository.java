package com.example.Parcial2.Repository;

import com.example.Parcial2.Model.EstadisticasJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EstadisticasJugadorRepository extends JpaRepository<EstadisticasJugador, Integer> {

    void deleteById(int id);

    boolean existsById(int id);

    @Query(value = """
    SELECT SUM(e.goles)
    FROM estadistica_jugador e
    JOIN jugador j ON e.id_jugador = j.id_jugador
    WHERE j.id_equipo = :idEquipo
    """, nativeQuery = true)
    int getTotalGolesPorEquipo(@Param("idEquipo") int idEquipo);
}
