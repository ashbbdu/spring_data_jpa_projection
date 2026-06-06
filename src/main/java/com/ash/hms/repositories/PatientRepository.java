package com.ash.hms.repositories;

import com.ash.hms.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity , Long> {
    @Query("""
    SELECT p
    FROM PatientEntity p
    LEFT JOIN FETCH p.insurance
""")
   public List<PatientEntity> findAllWithInsurance();
}
