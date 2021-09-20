package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.model.Domicilio;
import com.clinicaOdontologica.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Long id){
        return ResponseEntity.ok(domicilioService.buscar(id));
    }

    @PostMapping("/")
    public ResponseEntity guardar(@RequestBody Domicilio domicilio){
        return ResponseEntity.ok(domicilioService.guardar(domicilio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        return ResponseEntity.ok(domicilioService.eliminar(id));
    }

    @GetMapping("/")
    public ResponseEntity buscarTodos(){
        return ResponseEntity.ok(domicilioService.buscarTodos());
    }

    @PutMapping("/")
    public ResponseEntity actualizar(@RequestBody Domicilio domicilio){
        return ResponseEntity.ok(domicilioService.actualizar(domicilio));
    }

}
