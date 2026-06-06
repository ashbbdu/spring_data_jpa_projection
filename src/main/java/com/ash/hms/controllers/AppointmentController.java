package com.ash.hms.controllers;

import com.ash.hms.dto.appointments.AppointmentDto;
import com.ash.hms.dto.appointments.AppointmentResponseDto;
import com.ash.hms.services.AppointmentService;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointment")
@Data
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping(path = "/create/{patientId}/{doctorId}")
    public AppointmentDto createAppointment (@RequestBody AppointmentDto appointmentDto , @PathVariable Long patientId , @PathVariable Long doctorId) {
        return appointmentService.createAppointment(appointmentDto , patientId , doctorId);
    }


    @GetMapping(path = "/list")
    public List<AppointmentResponseDto> getAllAppointments () {
        return appointmentService.getAllAppointments();
    }

}
