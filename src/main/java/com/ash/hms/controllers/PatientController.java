package com.ash.hms.controllers;

import com.ash.hms.dto.CBloodGroupStats;
import com.ash.hms.dto.UpdateNameDto;
import com.ash.hms.repositories.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/patients")
public class PatientController {
    public final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @GetMapping("/blood-group")
    public  List<CBloodGroupStats> getBloodGroupStats () {
        return patientRepository.getBloodGroupStats(); //done
    }

    @PutMapping("/update-name/{id}")
    public int updateName (@RequestBody UpdateNameDto name , @PathVariable Long id) {
        return patientRepository.updateName(name.getName(), id);
    }

}
