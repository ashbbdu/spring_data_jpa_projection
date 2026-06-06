package com.ash.hms.repositories;

import com.ash.hms.dto.appointments.AppointmentResponseDto;
import com.ash.hms.entities.AppointmentEntity;
import com.ash.hms.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity , Long> {

}
