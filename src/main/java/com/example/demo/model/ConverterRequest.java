package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class ConverterRequest {

    private double input;
    private String fromUnit;
    private String toUnit;
}
