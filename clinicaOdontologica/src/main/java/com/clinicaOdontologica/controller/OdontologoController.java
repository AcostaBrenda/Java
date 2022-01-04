package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.DTO.OdontologoDTO;
import com.clinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Long id){
        return ResponseEntity.ok(odontologoService.buscar(id));
    }

    @PostMapping("/")
    public ResponseEntity guardar(@RequestBody OdontologoDTO odontologoDto){
        return ResponseEntity.ok(odontologoService.guardar(odontologoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        return ResponseEntity.ok(odontologoService.eliminar(id));
    }

    @GetMapping("/")
    public ResponseEntity buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity actualizar(@RequestBody OdontologoDTO odontologoDto, @PathVariable Long id){
        return ResponseEntity.ok(odontologoService.actualizar(odontologoDto, id));
    }

}
