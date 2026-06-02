package com.ash.hms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTests {

//    @Autowired
//    private PatientRepository patientRepository;

//    @Test
//    public void testPatient () {
//        List<PatientEntity> patients = patientRepository.findAll();
//
//        for(PatientEntity patient : patients) {
//            System.out.println(patient);
//        }
//    }
//
//    @Test
//    public void testPatentWithSelectedFields () {
//        List<IPatientDto> patients = patientRepository.getPatientInfo();
//
//        for (IPatientDto patient : patients) {
////            patient.getEmail() // here we can only access but can not update
//            System.out.println(
//                    "ID: " + patient.getId() +
//                            ", Name: " + patient.getName() +
//                            ", Email: " + patient.getEmail()
//            );
//        }
////        for(IPatientDto patient : patients) {
////            System.out.println(patient.toString());
////        }
//
////        System.out.println(patients);
//    }
//
//
//    @Test
//    public void testPatentWithSelectedFieldsConcrete () {
//        List<CPatientInfo> patients = patientRepository.getPatientInfoConcrete();
////
////        for (CPatientInfo patient : patients) {
////            System.out.println(
////                    "ID: " + patient.getId() +
////                            ", Name: " + patient.getName()
////            );
////        }
//        for(CPatientInfo patient : patients) {
//            PatientEntity entity = patientRepository.findById(patient.getId()).orElseThrow();
//            patient.setName("ashish"); // we can update using concrete but not from the interface
//            entity.setName("ashish");
//            patientRepository.save(entity);
//            System.out.println(patient);
//        }
//
//
//
////        System.out.println(patients);
//    }
//
//    @Test
//    public void getBloodGroupStats () {
//        List<CBloodGroupStats> stats = patientRepository.getBloodGroupStats();
//
//        for(CBloodGroupStats s : stats) {
//            System.out.println(s);
//        }
//    }
}
