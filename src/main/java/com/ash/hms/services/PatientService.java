package com.ash.hms.services;

import com.ash.hms.entities.PatientEntity;
import com.ash.hms.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;


//    public void deletePatient (Long patientId) {
////        deletes patient , appointment
//        patientRepository.findById(patientId).orElseThrow();
//        patientRepository.deleteById(patientId);
//    }

    @Transactional
    public PatientEntity removeInsuranceOfPatient (Long patientId) {
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
    //
        System.out.println("Before: " + patient.getInsurance());
        patient.setInsurance(null); // for this to work , we have to make ORPHAN removal to true
        System.out.println("After: " + patient.getInsurance());
//            patientRepository.save(patient);
    ////        patientRepository.saveAndFlush(patient);
        return patient;

    }


    public List<PatientEntity> getAllPatients () {
        return patientRepository.findAll();
    }
}
