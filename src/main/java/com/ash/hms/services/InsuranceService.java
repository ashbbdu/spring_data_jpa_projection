package com.ash.hms.services;

import com.ash.hms.config.MapperConfig;
import com.ash.hms.dto.InsuranceDto;
import com.ash.hms.dto.PatientDto;
import com.ash.hms.entities.InsuranceEntity;
import com.ash.hms.entities.PatientEntity;
import com.ash.hms.repositories.InsuranceRepository;
import com.ash.hms.repositories.PatientRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class InsuranceService {
    private final InsuranceRepository insuranceRepository; // we dont need a constructor since we are using @RequiredArgsConstructor

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

//    @Transactional
//    public InsuranceEntity assignInsuranceToPatient (InsuranceEntity insurance , Long patientId) {
//        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
//        patient.setInsurance(insurance);
//        patientRepository.save(patient);
//
//        insurance.setPatient(patient); // optional just to maintain bi-directional consistency
//        return insurance;
//    }
//
//    @Transactional
//    public void deletePatient (Long patientId) {
////        patientRepository.findById(patientId).orElseThrow();
////        patientRepository.deleteById(patientId);
//    }
//
//    @Transactional
//    public InsuranceEntity updateInsuranceOfPatient (InsuranceEntity insurance , Long patientId) {
//        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
//        patient.setInsurance(insurance);
////        patientRepository.save(patient);
//
//        insurance.setPatient(patient); // optional just to maintain bi-directional consistency
//        return insurance;
//    }


//    public InsuranceDto addInsurance (InsuranceDto insuranceDto) {
//        InsuranceEntity insurance = modelMapper.map(insuranceDto , InsuranceEntity.class);
//        insuranceRepository.save(insurance);
//        return modelMapper.map(insurance , InsuranceDto.class);
//
//    }



}
