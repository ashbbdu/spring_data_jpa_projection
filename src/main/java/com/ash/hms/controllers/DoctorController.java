package com.ash.hms.controllers;

import com.ash.hms.entities.DoctorEntity;
import com.ash.hms.services.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/add")
    public DoctorEntity add (@RequestBody DoctorEntity doctorEntity) {
        return doctorService.addDoctor(doctorEntity);
    }

    @GetMapping("/list")
    public List<DoctorEntity> list () {
        return doctorService.list();
    }

}
