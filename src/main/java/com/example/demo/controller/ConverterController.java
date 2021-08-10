package com.example.demo.controller;

import com.example.demo.model.ConverterRequest;
import com.example.demo.model.ConverterResponse;
import com.example.demo.service.ConverterService;
import com.example.demo.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConverterController {

    @Autowired
    ConverterService converterService;

    Logger logger = LoggerFactory.getLogger(ConverterController.class);


    @GetMapping("/")
    public String loadConverter()
    {
        return "home";
    }
}
