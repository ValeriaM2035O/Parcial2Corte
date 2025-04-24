package com.example.Parcial2.Controller;

import com.example.Parcial2.Model.Equipo;
import com.example.Parcial2.Model.EstadisticasJugador;
import com.example.Parcial2.Service.EstadisticasJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Estadisticas")
public class EstadisticasJugadorController {
    @Autowired
    private EstadisticasJugadorService estadisticasJugadorService;

    @PostMapping("/guardar")
    public EstadisticasJugador guardar (@RequestBody EstadisticasJugador estadisticasJugador){
        return estadisticasJugadorService.guardar(estadisticasJugador);
    }
    @PostMapping("/guardar-multiples")
    public List<EstadisticasJugador> guardarMultiples(@RequestBody List<EstadisticasJugador> estadisticasJugadores) {
        return estadisticasJugadorService.guardarTodos(estadisticasJugadores);
    }
    @GetMapping("/listar")
    public List<EstadisticasJugador> Listar(){
        return estadisticasJugadorService.Listar();
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id) {
        estadisticasJugadorService.eliminar(id);
    }
    @PutMapping("/actualizar/{id}")
    public EstadisticasJugador actualizar(@PathVariable int id, @RequestBody EstadisticasJugador estadisticasActualizadas) {
        return estadisticasJugadorService.actualizar(id, estadisticasActualizadas);
    }
    @GetMapping("/total-goles/{idEquipo}")
    public int totalGolesPorEquipo(@PathVariable int idEquipo) {
        return estadisticasJugadorService.totalGolesPorEquipo(idEquipo);
    }
}
