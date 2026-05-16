package com.ash.hms.services;

import com.ash.hms.dto.DepartmentNameDto;
import com.ash.hms.dto.DepartmentResponseDto;
import com.ash.hms.entities.DepartmentEntity;
import com.ash.hms.entities.DoctorEntity;
import com.ash.hms.repositories.DepartmentRepository;
import com.ash.hms.repositories.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, DoctorRepository doctorRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
    }

    public DepartmentEntity add (DepartmentEntity departmentEntity) {
        DoctorEntity doctorEntity = doctorRepository.findById(departmentEntity.getHead_doctor().getId()).orElse(null);

       DepartmentEntity department = departmentRepository.save(departmentEntity);
       department.setHead_doctor(doctorEntity);
       return department;
    }

    public List<DepartmentResponseDto> list () {
        List<DepartmentEntity> departments =  departmentRepository.findAll();
        return departments.stream()
                .map(department -> modelMapper.map(department, DepartmentResponseDto.class))
                .toList();

    }

//    add doctor to department
//    public DepartmentResponseDto update (Long doctorId , Long departmentId) {
//        DoctorEntity doctor = doctorRepository.findById(doctorId).orElseThrow(() ->
//                new RuntimeException("Doctor not found"));
//
//        DepartmentEntity department = departmentRepository.findById(departmentId).orElseThrow(() ->
//                new RuntimeException("Department Not Found !"));
//
//
//        doctor.getDepartments().add(department);
//
//        department.getDoctors().add(doctor);
//
//        doctorRepository.save(doctor);
//
//        return department;
//    }

    public DepartmentResponseDto update (Long doctorId, Long departmentId) {

        DoctorEntity doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        DepartmentEntity department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        if (!doctor.getDepartments().contains(department)) {
            doctor.getDepartments().add(department);
        }

        if (!department.getDoctors().contains(doctor)) {
            department.getDoctors().add(doctor);
        }

        doctorRepository.save(doctor);

        return modelMapper.map(department, DepartmentResponseDto.class);
    }


}
