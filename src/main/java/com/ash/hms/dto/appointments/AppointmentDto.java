package com.ash.hms.dto.appointments;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class AppointmentDto {
    private Long id;
    private LocalDateTime appointmentDateTime;
    private String reason;
    private boolean status;
}
