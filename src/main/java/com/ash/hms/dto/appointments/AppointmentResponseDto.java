package com.ash.hms.dto.appointments;

import com.ash.hms.dto.DoctorDto;
import com.ash.hms.dto.PatientDto;
import com.ash.hms.entities.DoctorEntity;
import com.ash.hms.entities.PatientEntity;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@JsonPropertyOrder({
        "id",
        "appointmentDateTime",
        "reason",
        "status",
        "patient",
        "doctor",
        "createdAt",
        "updatedAt"

})
public class AppointmentResponseDto {
    private Long id;
    private LocalDateTime appointmentDateTime;
    private String reason;
    private boolean status;



    private String patient_name;
    private String doctor_name;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

//    private PatientEntity patient; // instead of putting Entity put DTO
//    private DoctorEntity doctor; // instead of putting Entity put DTO

//    private PatientDto patient;
//    private DoctorDto doctor; I will use patientName and doctorName , to avoid N+1 problem



}
