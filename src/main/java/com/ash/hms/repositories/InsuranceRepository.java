package com.ash.hms.repositories;

import com.ash.hms.entities.InsuranceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<InsuranceEntity , Long> {
}
