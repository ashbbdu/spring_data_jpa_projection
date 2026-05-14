package com.ash.hms.services;

import com.ash.hms.entities.InsuranceEntity;
import com.ash.hms.entities.PatientEntity;
import com.ash.hms.repositories.InsuranceRepository;
import com.ash.hms.repositories.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    public InsuranceService(InsuranceRepository insuranceRepository , PatientRepository patientRepository) {
        this.insuranceRepository = insuranceRepository;
        this.patientRepository = patientRepository;
    }

    public InsuranceEntity createInsurance (InsuranceEntity data) {
        return insuranceRepository.save(data);
    }

//    public void assignInsuranceToPatient(InsuranceEntity insuranceEntity , Long patientId) {
//        PatientEntity patientEntity = patientRepository.findById(patientId).orElse(null);
//        if(patientEntity != null) {
//            patientEntity.setInsuranceEntity(insuranceEntity);
//        }
//
//
//    }

    public PatientEntity assignInsuranceToPatient(Long insuranceId , Long patientId) {
        InsuranceEntity insuranceEntity = insuranceRepository.findById(insuranceId).orElse(null);
        PatientEntity patientEntity = patientRepository.findById(patientId).orElse(null);

        assert patientEntity != null;
        patientEntity.setInsuranceEntity(insuranceEntity);
        patientRepository.save(patientEntity);
        return patientEntity;

    }

//    public PatientEntity updatePatient (InsuranceEntity insuranceEntity , Long patientId) {
//        PatientEntity patient = patientRepository.findById(patientId).orElse(null);
//        assert patient != null;
//        patient.setInsuranceEntity(insuranceEntity);
//        return patient;
//    }

}
