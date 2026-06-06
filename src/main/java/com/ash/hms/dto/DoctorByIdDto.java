package com.ash.hms.dto;

import com.ash.hms.dto.appointments.AppointmentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DoctorByIdDto {
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private List<DepartmentDto> departments;
    private List<AppointmentDto> appointments;
}
