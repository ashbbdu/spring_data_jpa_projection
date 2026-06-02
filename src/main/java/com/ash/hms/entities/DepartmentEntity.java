package com.ash.hms.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;


    @ManyToMany(mappedBy = "departments")
    private List<DoctorEntity> doctors;

}
