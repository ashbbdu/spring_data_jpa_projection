package com.ash.hms.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class DepartmentDto {
    private Long id;
    private String name;
}
