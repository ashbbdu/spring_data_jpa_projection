package com.ash.hms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "doctors")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , length = 50)
    private String name;

    @Column(nullable = false , length = 50)
    private String email;

    @Column(nullable = false , length = 50)
    private String specialization;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "doctorEntity")
    private List<AppointmentEntity> appointments = new ArrayList<>();

//    departments

    @ManyToMany
    @JoinTable(name = "doctors_departments" , joinColumns = @JoinColumn(name = "doctor_id")
            , inverseJoinColumns = @JoinColumn(name = "department_id"))
    private List<DepartmentEntity> departments = new ArrayList<>();

}
