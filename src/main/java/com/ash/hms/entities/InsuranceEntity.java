package com.ash.hms.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "insurances")
public class InsuranceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true , length = 50)
    private String policy_number;

    @Column(nullable = false , length = 100)
    private String provider;

    @Column(nullable = false)
    private LocalDateTime valid_until;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @OneToOne(mappedBy = "insuranceEntity") // insuranceEntity this came from PatientEntity joincol name
    @JoinColumn(name = "patient_id")
    private PatientEntity patientEntity; // we dont want two source of truth , so make this inverse side , and this column wont be present in Insuances table
}
