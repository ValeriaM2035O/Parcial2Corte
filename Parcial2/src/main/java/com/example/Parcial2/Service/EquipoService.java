package com.example.Parcial2.Service;

import com.example.Parcial2.Model.Equipo;
import com.example.Parcial2.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;
    public Equipo guardar(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public List<Equipo> Listar() {
        return equipoRepository.findAll();
    }

    public void eliminar(int id) {
        equipoRepository.deleteById(id);
    }

    public Equipo actualizar(int id, Equipo equipoActualizado) {
        if (equipoRepository.existsById(id)) {
            equipoActualizado.setIdEquipo(id);
            return equipoRepository.save(equipoActualizado);
        }
        return null;
    }

    public List<Equipo> guardarTodos(List<Equipo> equipos) {
        return equipoRepository.saveAll(equipos);
    }
}
