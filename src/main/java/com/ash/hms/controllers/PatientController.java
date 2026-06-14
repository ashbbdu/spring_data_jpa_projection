package com.ash.hms.controllers;

import com.ash.hms.dto.AssignInsuranceDto;
import com.ash.hms.dto.PatientDto;
import com.ash.hms.dto.PatientListDto;
import com.ash.hms.entities.PatientEntity;
import com.ash.hms.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/list")
    List<PatientListDto> getAllPatients () {
        return patientService.getAllPatients();
    }

    @GetMapping("/list/v2")
    public List<PatientListDto> findAllWithInsurance() {
        return patientService.findAllWithInsurance();
    }

    @PostMapping("/add")
    public PatientDto add (@RequestBody PatientDto patientDto) {
       return patientService.addPatient(patientDto);
    }

//    @PutMapping("/assign_insurance")
//    public void assignInsuranceToPatient (@RequestBody AssignInsuranceDto assignInsuranceDto) {
//        patientService.assignInsuranceToPatient(assignInsuranceDto.getPatientId() , assignInsuranceDto.getInsuranceId());
//    }

    @PutMapping("/update-patient/{patientId}/{name}")
    public PatientDto updatePatient (@PathVariable Long patientId , @PathVariable String name) {
        return patientService.updatePatient(patientId , name);
    }
}
