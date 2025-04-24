package com.example.Parcial2.Service;

import com.example.Parcial2.Model.Entrenador;
import com.example.Parcial2.Repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    public Entrenador guardar(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public List<Entrenador> Listar() {
        return entrenadorRepository.findAll();
    }

    public void eliminar(int id) {
        entrenadorRepository.deleteById(id);
    }

    public Entrenador actualizar(int id, Entrenador entrenadorActualizado) {
        if (entrenadorRepository.existsById(id)) {
            entrenadorActualizado.setIdEntrenador(id);
            return entrenadorRepository.save(entrenadorActualizado);
        }
        return null;
    }

    public List<Entrenador> guardarTodos(List<Entrenador> entrenadores) {
        return entrenadorRepository.saveAll(entrenadores);
    }
}
