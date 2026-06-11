package com.ash.hms.entities;

import com.ash.hms.entities.type.BloodGroupType;
import com.ash.hms.entities.type.GenderType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
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
//@Audited

public class PatientEntity extends AuditableEntity {

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




    @NotAudited
//    @OneToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE , CascadeType.DETACH})
    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true , fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id")
    private  InsuranceEntity insurance;

    @NotAudited
    @OneToMany(mappedBy = "patient" , cascade = CascadeType.ALL , fetch = FetchType.LAZY )
    private List<AppointmentEntity> appointments;

    @PrePersist
    void beforeSave () {

    }

    @PreUpdate
    void beforeUpdate () {

    }

    @PostPersist
    void afterSave () {

    }


}
