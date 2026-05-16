package com.ash.hms.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "departments")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

//    Each department will have 1 head doctor
    @OneToOne
    @JoinColumn(name = "head_doctor" , nullable = false)
//    @JoinColumn(nullable = false)
    private DoctorEntity head_doctor;

//    @OneToMany
//    @JoinColumn(name = "doctor_id")
//    private DoctorEntity doctors;
    @ManyToMany(mappedBy = "departments")
    private List<DoctorEntity> doctors = new ArrayList<>();

}
