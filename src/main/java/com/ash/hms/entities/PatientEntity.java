package com.ash.hms.entities;

import com.ash.hms.entities.type.BloodGroupType;
import com.ash.hms.entities.type.GenderType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "patients" , uniqueConstraints = {
        @UniqueConstraint(name = "unq_email" , columnNames = "email"),
        @UniqueConstraint(name = "unq_phone" , columnNames = "phone"),
        @UniqueConstraint(name = "unq_email_phone" , columnNames = {"email" , "phone"}),
},
indexes = {
        @Index(name = "idx_email" , columnList = "email"),
        @Index(name = "idx_phone" , columnList = "phone"),
        @Index(name = "idx_email_phone" , columnList = "email , phone"),
}
)

public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;


    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GenderType gender;

    @Column(nullable = false)
    private LocalDateTime birthDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BloodGroupType bloodGroup;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
}
