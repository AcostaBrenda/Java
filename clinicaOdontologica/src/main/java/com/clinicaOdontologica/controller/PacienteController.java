package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.model.Paciente;
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
    public ResponseEntity guardar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.eliminar(id));
    }

    @GetMapping("/")
    public ResponseEntity buscarTodos(){
        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PutMapping("/")
    public ResponseEntity actualizar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.actualizar(paciente));
    }

}
