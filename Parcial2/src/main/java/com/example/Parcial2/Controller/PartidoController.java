package com.example.Parcial2.Controller;

import com.example.Parcial2.Model.Partido;
import com.example.Parcial2.Service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/partido")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @PostMapping("/guardar")
    public Partido guardar (@RequestBody Partido partido){
        return partidoService.guardar(partido);
    }
    @PostMapping("/guardar-multiples")
    public List<Partido> guardarMultiples(@RequestBody List<Partido> partidos) {
        return partidoService.guardarTodos(partidos);
    }
    @GetMapping("/listar")
    public List<Partido> Listar(){
        return partidoService.Listar();
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id) {
        partidoService.eliminar(id);
    }

    @PutMapping("/actualizar/{id}")
    public Partido actualizar(@PathVariable int id, @RequestBody Partido partidoActualizado) {
        return partidoService.actualizar(id, partidoActualizado);
    }
    @GetMapping("/resultados")
    public List<Map<String, Object>> resultadosPartidos() {
        return partidoService.getResultadosConNombresEquipos();
    }
}
