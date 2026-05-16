package com.ash.hms.controllers;

import com.ash.hms.dto.DepartmentNameDto;
import com.ash.hms.dto.DepartmentResponseDto;
import com.ash.hms.entities.DepartmentEntity;
import com.ash.hms.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    public DepartmentEntity add (@RequestBody DepartmentEntity departmentEntity) {
        return departmentService.add(departmentEntity);
    }

    @GetMapping("/list")
    public List<DepartmentResponseDto> list () {
        return departmentService.list();
    }

//    Add doctors in department

//    @PutMapping("/update/{doctorId}/{departmentId}")
//    public DepartmentResponseDto update (@PathVariable Long doctorId , @PathVariable Long departmentId) {
//        departmentService.update(doctorId , departmentId);
//       return new DepartmentResponseDto();
//    }
@PutMapping("/update/{doctorId}/{departmentId}")
public DepartmentResponseDto update(
        @PathVariable Long doctorId,
        @PathVariable Long departmentId
) {
    return departmentService.update(doctorId, departmentId);
}
}
