package com.ash.hms;

import com.ash.hms.entities.InsuranceEntity;
import com.ash.hms.services.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {
    @Autowired
    private InsuranceService insuranceService;


    @Test
    void testAssignInsuranceToPatient () {
        InsuranceEntity insurance = InsuranceEntity.builder().policyNumber("HDFC-0001").provider("HDFC ERGO")
                .valid_until(LocalDateTime.of(2027 , 1 , 1 , 15,30 , 0))
                .build();

        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance , 1L);
        System.out.println(updatedInsurance);

    }

    @Test
    void testDeletePatient () {
        insuranceService.deletePatient(1L);
    }
}
