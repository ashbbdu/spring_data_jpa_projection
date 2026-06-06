package com.ash.hms.services;

import com.ash.hms.dto.DepartmentDto;
import com.ash.hms.dto.SetDepartment;
import com.ash.hms.entities.DepartmentEntity;
import com.ash.hms.entities.DoctorEntity;
import com.ash.hms.repositories.DepartmentRepository;
import com.ash.hms.repositories.DoctorRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public DepartmentDto addDepartment (DepartmentDto  departmentDto) {
        DepartmentEntity department = modelMapper.map(departmentDto , DepartmentEntity.class);
        departmentRepository.save(department);
        return modelMapper.map(department , DepartmentDto.class);
    }
//
//    public SetDepartment setDepartmentToDoctor (Long doctorId , Long departmentId) {
//        DepartmentEntity department = departmentRepository.findById(departmentId).orElseThrow();
//        DoctorEntity doctor = doctorRepository.findById(doctorId).orElseThrow();
//
//        doctor.getDepartments().add(department);
//
//
//    }
}
