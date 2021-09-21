package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.dto.PacienteDto;
import com.clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Long id){
    return ResponseEntity.ok(pacienteService.buscar(id));
    }

    @PostMapping("/")
    public ResponseEntity guardar(@RequestBody PacienteDto pacienteDto){
        return ResponseEntity.ok(pacienteService.guardar(pacienteDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.eliminar(id));
    }

    @GetMapping("/")
    public ResponseEntity buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizar(@RequestBody PacienteDto pacienteDto, @PathVariable Long id){
        return ResponseEntity.ok(pacienteService.actualizar(pacienteDto, id));
    }

}
