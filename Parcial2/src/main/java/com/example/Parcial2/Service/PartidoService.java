package com.example.Parcial2.Service;

import com.example.Parcial2.Model.Partido;
import com.example.Parcial2.Repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PartidoService {

    @Autowired
    private PartidoRepository partidoRepository;

    public Partido guardar(Partido partido) {
        return partidoRepository.save(partido);
    }

    public List<Partido> Listar() {
        return partidoRepository.findAll();
    }

    public void eliminar(int id) {
        partidoRepository.deleteById(id);
    }

    public Partido actualizar(int id, Partido partidoActualizado) {
        if (partidoRepository.existsById(id)) {
            partidoActualizado.setIdPartido(id);
            return partidoRepository.save(partidoActualizado);
        }
        return null;
    }

    public List<Map<String, Object>> getResultadosConNombresEquipos() {
        List<Object[]> resultados = partidoRepository.getResultadosConNombresDeEquipos();
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : resultados) {
            Map<String, Object> resultado = new LinkedHashMap<>();
            resultado.put("idPartido", fila[0]);
            resultado.put("fecha", fila[1]);
            resultado.put("estadio", fila[2]);
            resultado.put("equipoLocal", fila[3]);
            resultado.put("equipoVisita", fila[4]);
            resultado.put("golesLocal", fila[5]);
            resultado.put("golesVisita", fila[6]);
            lista.add(resultado);
        }

        return lista;
    }

    public List<Partido> guardarTodos(List<Partido> partidos) {
        return partidoRepository.saveAll(partidos);
    }
}
