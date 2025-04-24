package com.example.Parcial2.Controller;

import com.example.Parcial2.Model.Equipo;
import com.example.Parcial2.Service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipo")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @PostMapping("/guardar")
    public Equipo guardar (@RequestBody Equipo equipo){
        return equipoService.guardar(equipo);
    }
    @PostMapping("/guardar-multiples")
    public List<Equipo> guardarMultiples(@RequestBody List<Equipo> equipos) {
        return equipoService.guardarTodos(equipos);
    }
    @GetMapping("/listar")
    public List<Equipo> Listar(){
        return equipoService.Listar();
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id) {
        equipoService.eliminar(id);
    }

    @PutMapping("/actualizar/{id}")
    public Equipo actualizar(@PathVariable int id, @RequestBody Equipo equipoActualizado) {
        return equipoService.actualizar(id, equipoActualizado);
    }
}

