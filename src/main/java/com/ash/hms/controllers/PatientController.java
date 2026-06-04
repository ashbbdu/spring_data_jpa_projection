package com.ash.hms.controllers;

import com.ash.hms.entities.PatientEntity;
import com.ash.hms.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/list")
    List<PatientEntity> getAllPatients () {
        return patientService.getAllPatients();
    }
}
