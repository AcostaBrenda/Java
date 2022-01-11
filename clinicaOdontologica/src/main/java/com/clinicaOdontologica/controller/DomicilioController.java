package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.DTO.DomicilioDTO;
import com.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.clinicaOdontologica.service.DomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    private DomicilioService domicilioService;

    @GetMapping("/{id}")
    public ResponseEntity<DomicilioDTO>buscar(@PathVariable Long id)throws ResourceNotFoundException{
        try{
            return ResponseEntity.ok(domicilioService.buscar(id));
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<DomicilioDTO>guardar(@RequestBody DomicilioDTO domicilioDto){
        return ResponseEntity.ok(domicilioService.guardar(domicilioDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>eliminar(@PathVariable Long id){
        return ResponseEntity.ok(domicilioService.eliminar(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<DomicilioDTO>> buscarTodos(){
        return ResponseEntity.ok(domicilioService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DomicilioDTO>actualizar(@RequestBody DomicilioDTO domicilioDto, @PathVariable Long id)throws ResourceNotFoundException {
        try{
            return ResponseEntity.ok(domicilioService.actualizar(domicilioDto, id));
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> recursoNOencontrado(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
