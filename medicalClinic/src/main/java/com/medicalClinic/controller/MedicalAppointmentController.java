package com.medicalClinic.controller;

import com.medicalClinic.DTO.MedicalAppointmentDTO;
import com.medicalClinic.service.MedicalAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/medicalAppointments")
public class MedicalAppointmentController {

    @Autowired
    private MedicalAppointmentService medicalAppointmentService;


}
