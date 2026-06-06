package com.ash.hms.services;

import com.ash.hms.dto.AppointmentDto;
import com.ash.hms.entities.AppointmentEntity;
import com.ash.hms.entities.DoctorEntity;
import com.ash.hms.entities.PatientEntity;
import com.ash.hms.repositories.AppointmentRepository;
import com.ash.hms.repositories.DoctorRepository;
import com.ash.hms.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public AppointmentDto createAppointment (AppointmentDto appointmentDto , Long patientId , Long doctorId) {
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
        DoctorEntity doctor = doctorRepository.findById(doctorId).orElseThrow();
        AppointmentEntity appointmentEntity = modelMapper.map(appointmentDto , AppointmentEntity.class);
        appointmentEntity.setPatient(patient);
        appointmentEntity.setDoctor(doctor);

        appointmentRepository.save(appointmentEntity);
        return modelMapper.map(appointmentEntity , AppointmentDto.class);

    }
}
