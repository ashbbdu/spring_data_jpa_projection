package com.ash.hms.repositories;

import com.ash.hms.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity , Long> {

}
