package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.dto.TurnoDto;
import com.clinicaOdontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Long id){
        return ResponseEntity.ok(turnoService.buscar(id));
    }

    @PostMapping("/")
    public ResponseEntity guardar(@RequestBody TurnoDto turnoDto){
        return ResponseEntity.ok(turnoService.guardar(turnoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        return ResponseEntity.ok(turnoService.eliminar(id));
    }

    @GetMapping("/")
    public ResponseEntity buscarTodos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizar(@RequestBody TurnoDto turnoDto, @PathVariable Long id){
        return ResponseEntity.ok(turnoService.actualizar(turnoDto, id));
    }

}
