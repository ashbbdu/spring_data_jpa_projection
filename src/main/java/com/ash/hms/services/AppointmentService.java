package com.ash.hms.services;

import com.ash.hms.dto.appointments.AppointmentDto;
import com.ash.hms.dto.appointments.AppointmentResponseDto;
import com.ash.hms.entities.AppointmentEntity;
import com.ash.hms.entities.DoctorEntity;
import com.ash.hms.entities.PatientEntity;
import com.ash.hms.repositories.AppointmentRepository;
import com.ash.hms.repositories.DoctorRepository;
import com.ash.hms.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<AppointmentResponseDto> getAllAppointments () {
        return appointmentRepository.findAllAppointmentWithPatientAndDoctor();
//        return appointments.stream()
//                .map(res -> modelMapper.map(res , AppointmentResponseDto.class))
//                .toList();

    }
}
