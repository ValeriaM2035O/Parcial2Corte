package com.example.Parcial2.Repository;

import com.example.Parcial2.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    void deleteById(int id);

    boolean existsById(int id);

    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :idEquipo", nativeQuery = true)
    List<Jugador> findJugadoresByEquipo(@Param("idEquipo") int idEquipo);

    @Query(value = """
    SELECT DISTINCT j.*
    FROM jugador j
    JOIN estadistica_jugador e ON j.id_jugador = e.id_jugador
    WHERE e.goles > :goles
    """, nativeQuery = true)
    List<Jugador> findJugadoresConMasDeXGoles(@Param("goles") Integer goles);
}
