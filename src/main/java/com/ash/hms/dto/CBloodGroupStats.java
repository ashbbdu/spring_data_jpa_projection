package com.ash.hms.dto;

import com.ash.hms.entities.type.BloodGroupType;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CBloodGroupStats {
    private BloodGroupType bloodGroup;
//    private int count; will not work because count(p) in JPQL always returns Long, not int or Integer.
    private Long count;
}
