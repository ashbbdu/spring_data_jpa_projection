package com.ash.hms.services;

import com.ash.hms.dto.DoctorByIdDto;
import com.ash.hms.dto.DoctorDto;
import com.ash.hms.dto.PatientDto;
import com.ash.hms.entities.DepartmentEntity;
import com.ash.hms.entities.DoctorEntity;
import com.ash.hms.repositories.DepartmentRepository;
import com.ash.hms.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DoctorDto addDoctor (DoctorDto doctorDto) {
        DoctorEntity doctor = modelMapper.map(doctorDto , DoctorEntity.class);
        doctorRepository.save(doctor);
        return modelMapper.map(doctor , DoctorDto.class);
    }

    public DoctorDto assignDepartmentToDoctor (Long departmentId , Long doctorId) {
        DoctorEntity doctor = doctorRepository.findById(doctorId).orElseThrow();
        DepartmentEntity department = departmentRepository.findById(departmentId).orElseThrow();

//        doctor.setDepartments(List.of(department));
        doctor.getDepartments().add(department);
//        department.setDoctors(List.of(doctor));

        department.getDoctors().add(doctor);

        departmentRepository.save(department);
        doctorRepository.save(doctor);

        return modelMapper.map(doctor , DoctorDto.class);


    }

    public List<DoctorDto> getAllDoctors () {
       List<DoctorEntity> doctors = doctorRepository.getDoctorsAllDoctorsWithDepartment();
       return doctors.stream().map(res -> modelMapper.map(res , DoctorDto.class)).toList();
    }

    public DoctorByIdDto getDoctorById (Long doctorId) {
        DoctorEntity doctor = doctorRepository.findById(doctorId).orElseThrow();
        return modelMapper.map(doctor , DoctorByIdDto.class);
    }

}
