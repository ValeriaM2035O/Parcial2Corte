package com.example.Parcial2.Service;

import com.example.Parcial2.Model.EstadisticasJugador;
import com.example.Parcial2.Repository.EstadisticasJugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstadisticasJugadorService {

    @Autowired
    private EstadisticasJugadorRepository estadisticasJugadorRepository;

    public EstadisticasJugador guardar(EstadisticasJugador estadisticasJugador) {
        return estadisticasJugadorRepository.save(estadisticasJugador);
    }

    public List<EstadisticasJugador> Listar() {
        return estadisticasJugadorRepository.findAll();
    }

    public void eliminar(int id) {
        estadisticasJugadorRepository.deleteById(id);
    }

    public EstadisticasJugador actualizar(int id, EstadisticasJugador estadisticasActualizadas) {
        if (estadisticasJugadorRepository.existsById(id)) {
            estadisticasActualizadas.setIdEstadistica(id);
            return estadisticasJugadorRepository.save(estadisticasActualizadas);
        }
        return null;
    }

    public int totalGolesPorEquipo(int idEquipo) {
        return estadisticasJugadorRepository.getTotalGolesPorEquipo(idEquipo);
    }

    public List<EstadisticasJugador> guardarTodos(List<EstadisticasJugador> estadisticasJugadores) {
        return estadisticasJugadorRepository.saveAll(estadisticasJugadores);
    }
}
