package com.ash.hms.entities;

import com.ash.hms.entities.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "patients")
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDateTime birthDate;
    private String email;
    private String gender;

    @Enumerated(value = EnumType.STRING)
    private BloodGroupType bloodGroup;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

//    Requirement => One patient will have one insurance.

    @OneToOne()
    @JoinColumn(name = "insurance_id")
    private InsuranceEntity insuranceEntity;


    @OneToMany(mappedBy = "patientEntity") // mappedBy = "patientEntity" here we have to use the name of the private variable and not the column name
    // Inverse of Appointment Many appointments will have 1 patient
    private List<AppointmentEntity> appointments = new ArrayList<>();
}
