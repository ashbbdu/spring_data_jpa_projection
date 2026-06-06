package com.ash.hms.controllers;

import com.ash.hms.dto.AppointmentDto;
import com.ash.hms.services.AppointmentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

}
