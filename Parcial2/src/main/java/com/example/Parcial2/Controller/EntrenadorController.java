package com.example.Parcial2.Controller;

import com.example.Parcial2.Model.Entrenador;
import com.example.Parcial2.Service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenador")
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @PostMapping("/guardar")
    public Entrenador guardar (@RequestBody Entrenador entrenador){
        return entrenadorService.guardar(entrenador);
    }
    @PostMapping("/guardar-multiples")
    public List<Entrenador> guardarMultiples(@RequestBody List<Entrenador> entrenadores) {
        return entrenadorService.guardarTodos(entrenadores);
    }
    @GetMapping("/listar")
    public List<Entrenador> Listar(){
        return entrenadorService.Listar();
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        entrenadorService.eliminar(id);
    }
    @PutMapping("/actualizar/{id}")
    public Entrenador actualizar(@PathVariable int id, @RequestBody Entrenador entrenadorActualizado){
        return entrenadorService.actualizar(id, entrenadorActualizado);
    }
}
