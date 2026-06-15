package com.ash.hms.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserDetailsDto {
    private Long id;
    private String email;
    private String name;
}
