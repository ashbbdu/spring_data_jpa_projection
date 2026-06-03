package com.ash.hms.services;

import com.ash.hms.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;


    public void deletePatient () {

    }
}
