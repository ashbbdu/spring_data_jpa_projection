package com.ash.hms.dto;

import java.time.LocalDateTime;
import java.util.List;

public class SetDepartment {
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private List<DepartmentDto> departments;
}
