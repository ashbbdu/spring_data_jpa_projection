package com.ash.hms.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Long id;

    private String name;

    private String email;

    private String specialization;

    private List<DepartmentNameDto> departments;
}
