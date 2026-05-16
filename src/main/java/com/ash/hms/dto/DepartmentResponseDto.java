package com.ash.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseDto {
    private Long id;

    private String name;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    private DoctorDto head_doctor;

    private List<DoctorDto> doctors;
}
