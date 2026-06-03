package com.ash.hms.services;

import com.ash.hms.repositories.AppointmentRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
}
