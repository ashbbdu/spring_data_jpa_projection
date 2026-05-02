package com.ash.hms;

import com.ash.hms.entities.PatientEntity;
import com.ash.hms.repositories.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatient () {
        List<PatientEntity> patients = patientRepository.findAll();

        for(PatientEntity patient : patients) {
            System.out.println(patient);
        }
    }
}
