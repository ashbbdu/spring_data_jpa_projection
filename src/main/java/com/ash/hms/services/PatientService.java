package com.ash.hms.services;

import com.ash.hms.entities.PatientEntity;
import com.ash.hms.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    PatientService (PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientEntity> getAllPatients () {
        return patientRepository.findAll();
    }

}
