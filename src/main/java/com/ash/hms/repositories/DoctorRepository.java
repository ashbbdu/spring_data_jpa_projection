package com.ash.hms.repositories;

import com.ash.hms.entities.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<DoctorEntity , Long> {
    @Query("SELECT d from DoctorEntity d LEFT JOIN FETCH d.departments")
    public List<DoctorEntity> getDoctorsAllDoctorsWithDepartment();
}
