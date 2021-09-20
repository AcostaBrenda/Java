package com.clinicaOdontologica.controller;

import com.clinicaOdontologica.model.Odontologo;
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
    public ResponseEntity guardar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardar(odontologo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){
        return ResponseEntity.ok(odontologoService.eliminar(id));
    }

    @GetMapping("/")
    public ResponseEntity buscarTodos(){
        return ResponseEntity.ok(odontologoService.buscarTodos());
    }

    @PutMapping("/")
    public ResponseEntity actualizar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.actualizar(odontologo));
    }

}
