package com.ash.hms.controllers;

import com.ash.hms.dto.CBloodGroupStats;
import com.ash.hms.repositories.PatientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    public final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @GetMapping("/blood-group")
    public  List<CBloodGroupStats> getBloodGroupStats () {
        return patientRepository.getBloodGroupStats();
    }

}
