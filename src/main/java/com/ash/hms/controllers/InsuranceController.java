package com.ash.hms.controllers;

import com.ash.hms.config.MapperConfig;
import com.ash.hms.dto.InsuranceDto;
import com.ash.hms.services.InsuranceService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance")
@Data
@RequiredArgsConstructor
public class InsuranceController {
    private final InsuranceService insuranceService;
    private final ModelMapper modelMapper;

    @PostMapping(path = "/add")
    public InsuranceDto addInsurance (@RequestBody InsuranceDto insuranceDto) {
        return insuranceService.addInsurance(insuranceDto);
    }




}
