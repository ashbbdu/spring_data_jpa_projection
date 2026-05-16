package com.ash.hms.services;

import com.ash.hms.entities.DoctorEntity;
import com.ash.hms.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public DoctorEntity addDoctor (DoctorEntity doctorEntity) {
        return doctorRepository.save(doctorEntity);
    }

    public List<DoctorEntity> list () {
        return doctorRepository.findAll();
    }


}
