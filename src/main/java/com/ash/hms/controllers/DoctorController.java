package com.ash.hms.controllers;

import com.ash.hms.dto.DoctorDto;
import com.ash.hms.repositories.DoctorRepository;
import com.ash.hms.services.DoctorService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@Data
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;
//
    @PostMapping(path = "/add")
    public DoctorDto addDoctor (@RequestBody DoctorDto doctorDto) {
        return  doctorService.addDoctor(doctorDto);
    }

    @PutMapping(path = "/assign-department-to-doctor/{departmentId}/{doctorId}")
    public DoctorDto assignDepartmentToDoctor (@PathVariable Long departmentId , @PathVariable Long doctorId) {
       return doctorService.assignDepartmentToDoctor(departmentId , doctorId);
    }

    @GetMapping("/list")
    public List<DoctorDto> getAllDoctors () {
        return doctorService.getAllDoctors();
    }
}
