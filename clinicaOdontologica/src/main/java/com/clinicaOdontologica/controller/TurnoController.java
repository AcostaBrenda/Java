package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.DTO.TurnoDTO;
import com.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.clinicaOdontologica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscar(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(turnoService.buscar(id));
    }

    @PostMapping("/")
    public ResponseEntity<TurnoDTO>guardar(@RequestBody TurnoDTO turnoDto){
        return ResponseEntity.ok(turnoService.guardar(turnoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminar(@PathVariable Long id){
        return ResponseEntity.ok(turnoService.eliminar(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<TurnoDTO>>buscarTodos(){
        return ResponseEntity.ok(turnoService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurnoDTO> actualizar(@RequestBody TurnoDTO turnoDto, @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(turnoService.actualizar(turnoDto, id));
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String>recursoNOencontrado(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
