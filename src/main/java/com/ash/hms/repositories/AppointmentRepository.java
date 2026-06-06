package com.ash.hms.repositories;

import com.ash.hms.dto.appointments.AppointmentResponseDto;
import com.ash.hms.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity , Long> {
    @Query("""
    SELECT new com.ash.hms.dto.appointments.AppointmentResponseDto(
        a.id,
        a.appointmentDateTime,
        a.reason,
        a.status,
         p.name,
        d.name,
        a.created_at,
        a.updated_at
    )
    FROM AppointmentEntity a
    JOIN a.patient p
    JOIN a.doctor d
""")
    public List<AppointmentResponseDto> findAllAppointmentWithPatientAndDoctor();
}
