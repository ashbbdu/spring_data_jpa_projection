package com.ash.hms.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
@JsonPropertyOrder({
        "id",
        "name",
        "specialization",
        "email",
        "departments"
})
public class DoctorDto {
   private Long id;
   private String name;
   private String specialization;
   private String email;
   private List<DepartmentDto> departments;
}
