package com.ash.hms.repositories;

import com.ash.hms.entities.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity , Long> {
}
