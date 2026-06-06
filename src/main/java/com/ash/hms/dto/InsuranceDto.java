package com.ash.hms.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class InsuranceDto {
    private Long id;
    private String policyNumber;
    private String provider;
    private LocalDateTime valid_until;

}
