package com.ash.hms.controllers;

import com.ash.hms.entities.DepartmentEntity;
import com.ash.hms.services.DepartmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
