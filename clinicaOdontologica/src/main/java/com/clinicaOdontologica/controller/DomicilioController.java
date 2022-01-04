package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.DTO.DomicilioDTO;
import com.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.clinicaOdontologica.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity guardar(@RequestBody DomicilioDTO domicilioDto){
        return ResponseEntity.ok(domicilioService.guardar(domicilioDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        return ResponseEntity.ok(domicilioService.eliminar(id));
    }

    @GetMapping("/")
    public ResponseEntity buscarTodos(){
        return ResponseEntity.ok(domicilioService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizar(@RequestBody DomicilioDTO domicilioDto, @PathVariable Long id){
        return ResponseEntity.ok(domicilioService.actualizar(domicilioDto, id));
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> recursoNOencontrado(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
