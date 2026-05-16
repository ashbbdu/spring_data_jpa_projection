package com.ash.hms.services;

import com.ash.hms.entities.DepartmentEntity;
import com.ash.hms.entities.DoctorEntity;
import com.ash.hms.repositories.DepartmentRepository;
import com.ash.hms.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;

    public DepartmentService(DepartmentRepository departmentRepository, DoctorRepository doctorRepository) {
        this.departmentRepository = departmentRepository;
        this.doctorRepository = doctorRepository;
    }

    public DepartmentEntity add (DepartmentEntity departmentEntity) {
        DoctorEntity doctorEntity = doctorRepository.findById(departmentEntity.getHead_doctor().getId()).orElse(null);

       DepartmentEntity department = departmentRepository.save(departmentEntity);
       department.setHead_doctor(doctorEntity);
       return department;
    }


}
