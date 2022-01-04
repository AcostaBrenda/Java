package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.DTO.PacienteDTO;
import com.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO>buscar(@PathVariable Long id) throws ResourceNotFoundException{
    return ResponseEntity.ok(pacienteService.buscar(id));
    }

    @PostMapping("/")
    public ResponseEntity<PacienteDTO>guardar(@RequestBody PacienteDTO pacienteDto){
        return ResponseEntity.ok(pacienteService.guardar(pacienteDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>eliminar(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.eliminar(id));
    }

    @GetMapping("/")
    public ResponseEntity <List<PacienteDTO>>buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteDTO>actualizar(@RequestBody PacienteDTO pacienteDto, @PathVariable Long id)throws ResourceNotFoundException{
        return ResponseEntity.ok(pacienteService.actualizar(pacienteDto, id));
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String>recursoNOencontrado(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
