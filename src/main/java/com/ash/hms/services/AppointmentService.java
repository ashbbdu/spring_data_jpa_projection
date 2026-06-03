package com.ash.hms.services;

import com.ash.hms.entities.AppointmentEntity;
import com.ash.hms.entities.DoctorEntity;
import com.ash.hms.entities.PatientEntity;
import com.ash.hms.repositories.AppointmentRepository;
import com.ash.hms.repositories.DoctorRepository;
import com.ash.hms.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public AppointmentEntity createAppointment (AppointmentEntity appointmentEntity , Long patientId , Long doctorId) {
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
        DoctorEntity doctor = doctorRepository.findById(doctorId).orElseThrow();
        appointmentEntity.setPatient(patient);
        appointmentEntity.setDoctor(doctor);

        appointmentRepository.save(appointmentEntity);

        return appointmentEntity;

    }
}
