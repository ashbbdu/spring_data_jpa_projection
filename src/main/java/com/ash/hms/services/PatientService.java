package com.ash.hms.services;

import com.ash.hms.dto.PatientDto;
import com.ash.hms.dto.PatientListDto;
import com.ash.hms.entities.InsuranceEntity;
import com.ash.hms.entities.PatientEntity;
import com.ash.hms.repositories.InsuranceRepository;
import com.ash.hms.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;
    private final ModelMapper modelMapper;


//    public void deletePatient (Long patientId) {
////        deletes patient , appointment
//        patientRepository.findById(patientId).orElseThrow();
//        patientRepository.deleteById(patientId);
//    }

//    @Transactional
//    public PatientEntity removeInsuranceOfPatient (Long patientId) {
//        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
//    //
//        System.out.println("Before: " + patient.getInsurance());
//        patient.setInsurance(null); // for this to work , we have to make ORPHAN removal to true
//        System.out.println("After: " + patient.getInsurance());
////            patientRepository.save(patient);
//    ////        patientRepository.saveAndFlush(patient);
//        return patient;
//
//    }


//    public List<PatientEntity> getAllPatients () {
//        return patientRepository.findAll();
//    }

    public PatientDto addPatient (PatientDto patientDto) {
        PatientEntity patient = modelMapper.map(patientDto , PatientEntity.class);
        patientRepository.save(patient);
        return modelMapper.map(patient , PatientDto.class);
    }

    public void assignInsuranceToPatient (Long patientId , Long insuranceId) {
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
        InsuranceEntity insurance = insuranceRepository.findById(insuranceId).orElseThrow();
        patient.setInsurance(insurance);

        patientRepository.save(patient);
    }

    public List<PatientListDto> getAllPatients () {
        List<PatientEntity> patients = patientRepository.findAll();
        return patients.stream().map((res) -> modelMapper.map(res , PatientListDto.class)).toList();
    }

    public List<PatientListDto> findAllWithInsurance() {
        List<PatientEntity> patients = patientRepository.findAllWithInsurance();
        return patients.stream().map(res -> modelMapper.map(res , PatientListDto.class)).toList();
    }
}
