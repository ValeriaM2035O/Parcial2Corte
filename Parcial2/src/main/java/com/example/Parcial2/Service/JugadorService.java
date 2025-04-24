package com.example.Parcial2.Service;

import com.example.Parcial2.Model.Jugador;
import com.example.Parcial2.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public Jugador guardar(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public List<Jugador> Listar() {
        return jugadorRepository.findAll();
    }

    public void eliminar(int id) {
        jugadorRepository.deleteById(id);
    }

    public Jugador actualizar(int id, Jugador jugadorActualizado) {
        if (jugadorRepository.existsById(id)) {
            jugadorActualizado.setIdJugador(id);
            return jugadorRepository.save(jugadorActualizado);
        }
        return null;
    }

    public List<Jugador> obtenerPorEquipo(int idEquipo) {
        return jugadorRepository.findJugadoresByEquipo(idEquipo);
    }

    public List<Jugador> jugadoresConMasDeXGoles(Integer goles) {
        return jugadorRepository.findJugadoresConMasDeXGoles(goles);
    }

    public List<Jugador> guardarTodos(List<Jugador> jugadores) {
        return jugadorRepository.saveAll(jugadores);
    }
}
