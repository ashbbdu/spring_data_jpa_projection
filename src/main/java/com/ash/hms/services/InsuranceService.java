package com.ash.hms.services;

import com.ash.hms.entities.InsuranceEntity;
import com.ash.hms.entities.PatientEntity;
import com.ash.hms.repositories.InsuranceRepository;
import com.ash.hms.repositories.PatientRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class InsuranceService {
    private final InsuranceRepository insuranceRepository; // we dont need a constructor since we are using @RequiredArgsConstructor

    private final PatientRepository patientRepository;

    @Transactional
    public InsuranceEntity assignInsuranceToPatient (InsuranceEntity insurance , Long patientId) {
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance);
//        patientRepository.save(patient);

        insurance.setPatient(patient); // optional just to maintain bi-directional consistency
        return insurance;
    }

    @Transactional
    public void deletePatient (Long patientId) {
//        patientRepository.findById(patientId).orElseThrow();
//        patientRepository.deleteById(patientId);
    }

}
