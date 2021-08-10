package com.example.demo.controller;

import com.example.demo.model.ConverterRequest;
import com.example.demo.model.ConverterResponse;
import com.example.demo.service.ConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConverterRestController {

    @Autowired
    ConverterService converterService;
    Logger logger = LoggerFactory.getLogger(ConverterController.class);

    @PostMapping("/convert")
    public ConverterResponse convert(@RequestBody ConverterRequest converterRequest)
    {
        logger.info("input: " +converterRequest.getInput());
        logger.info("fromUnit: " +converterRequest.getFromUnit());
        logger.info("toUnit: " +converterRequest.getToUnit());
        return converterService.converter(converterRequest);
    }
}
