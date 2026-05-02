package com.ash.hms.repositories;

import com.ash.hms.dto.CBloodGroupStats;
import com.ash.hms.dto.CPatientInfo;
import com.ash.hms.dto.IPatientDto;
import com.ash.hms.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository extends JpaRepository<PatientEntity , Long> {
//    @Query("select p.id , p.name , p.email from PatientEntity p")
    @Query("select p.id as id, p.name as name, p.email as email from PatientEntity p")
    List<IPatientDto> getPatientInfo();

    @Query("select new com.ash.hms.dto.CPatientInfo(p.id , p.name)" +  " from PatientEntity p")
    List<CPatientInfo> getPatientInfoConcrete();


    @Query("select new com.ash.hms.dto.CBloodGroupStats(p.bloodGroup , count(p))" +  " from PatientEntity p group by p.bloodGroup")

    List<CBloodGroupStats> getBloodGroupStats();

//    todo :  make controller to display blood groups and count
}
