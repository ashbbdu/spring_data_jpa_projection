package com.ash.hms.controllers;

import com.ash.hms.entities.InsuranceEntity;
import com.ash.hms.entities.PatientEntity;
import com.ash.hms.services.InsuranceService;
import com.ash.hms.services.PatientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {
    private final InsuranceService insuranceService;
    private final PatientService patientService;
     InsuranceController (InsuranceService insuranceService , PatientService patientService) {
        this.insuranceService = insuranceService;
        this.patientService = patientService;
    }

    @GetMapping("/health")
    public String health () {
         return "App is running fine !";
    }

    @PostMapping(path = "/create")
    public InsuranceEntity addInsurance (@RequestBody InsuranceEntity data) {
        return insuranceService.createInsurance(data);
    }


    @PutMapping("/update-patient/{insuranceId}/{patientId}")
    public PatientEntity assignInsuranceToPatient (@PathVariable Long insuranceId , @PathVariable Long patientId) {
        return insuranceService.assignInsuranceToPatient(insuranceId , patientId);
    }

}
