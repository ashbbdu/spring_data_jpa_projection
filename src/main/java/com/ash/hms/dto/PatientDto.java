package com.ash.hms.dto;

import com.ash.hms.entities.type.BloodGroupType;
import com.ash.hms.entities.type.GenderType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class PatientDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private LocalDateTime birthDate;


    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String createdBy;
    private String updatedBy;

}
