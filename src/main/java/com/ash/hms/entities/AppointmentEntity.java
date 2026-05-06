package com.ash.hms.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "appointments")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 50)
    private String name;

    @Column
    private LocalDateTime appointmentTime;

    @Column(nullable = false , length = 500)
    private String reason;

    @ManyToOne // read like many Appointment will have one patient
    @JoinColumn(name = "patient_id")
    private PatientEntity patientEntity;
}
