package com.ash.hms.controllers;

import com.ash.hms.entities.PatientEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/audit")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

//    Envers is not used mostly
//    @GetMapping(path = "/patinet/{patientId}")
//    List<PatientEntity> getPatientRevisions (@PathVariable Long patientId) {
//        AuditReader auditReader = AuditReaderFactory
//    }
}
