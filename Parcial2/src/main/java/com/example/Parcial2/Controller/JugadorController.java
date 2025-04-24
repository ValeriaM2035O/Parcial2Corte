package com.example.Parcial2.Controller;

import com.example.Parcial2.Model.Equipo;
import com.example.Parcial2.Model.Jugador;
import com.example.Parcial2.Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugador")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @PostMapping("/guardar")
    public Jugador guardar (@RequestBody Jugador jugador){
        return jugadorService.guardar(jugador);
    }
    @PostMapping("/guardar-multiples")
    public List<Jugador> guardarMultiples(@RequestBody List<Jugador> jugadores) {
        return jugadorService.guardarTodos(jugadores);
    }
    @GetMapping("/listar")
    public List<Jugador> Listar(){
        return jugadorService.Listar();
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id) {
        jugadorService.eliminar(id);
    }
    @PutMapping("/actualizar/{id}")
    public Jugador actualizar(@PathVariable int id, @RequestBody Jugador jugadorActualizado) {
        return jugadorService.actualizar(id, jugadorActualizado);
    }
    @GetMapping("/por-equipo/{idEquipo}")
    public List<Jugador> jugadoresPorEquipo(@PathVariable int idEquipo) {
        return jugadorService.obtenerPorEquipo(idEquipo);
    }
    @GetMapping("/con-mas-goles")
    public List<Jugador> jugadoresConMasGoles(@RequestParam Integer goles) {
        return jugadorService.jugadoresConMasDeXGoles(goles);
    }
}


