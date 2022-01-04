package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.DTO.OdontologoDTO;
import com.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.clinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO>buscar(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(odontologoService.buscar(id));
    }

    @PostMapping("/")
    public ResponseEntity<OdontologoDTO>guardar(@RequestBody OdontologoDTO odontologoDto){
        return ResponseEntity.ok(odontologoService.guardar(odontologoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean>eliminar(@PathVariable Long id){
        return ResponseEntity.ok(odontologoService.eliminar(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<OdontologoDTO>>buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<OdontologoDTO>actualizar(@RequestBody OdontologoDTO odontologoDto, @PathVariable Long id) throws ResourceNotFoundException{
        return ResponseEntity.ok(odontologoService.actualizar(odontologoDto, id));
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String>recursoNOencontrado(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
