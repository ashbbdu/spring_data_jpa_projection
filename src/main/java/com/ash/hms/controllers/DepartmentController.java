package com.ash.hms.controllers;

import com.ash.hms.dto.DepartmentDto;
import com.ash.hms.services.DepartmentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
@Data
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping(path = "/add")
    public DepartmentDto addDepartment (@RequestBody DepartmentDto departmentDto) {
        return departmentService.addDepartment(departmentDto);
    }

}
