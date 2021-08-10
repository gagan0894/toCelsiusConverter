package com.example.demo.service;

import com.example.demo.model.ConverterRequest;
import com.example.demo.model.ConverterResponse;
import com.example.demo.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.function.ToDoubleBiFunction;

@Service
public class ConverterService {

    Logger logger = LoggerFactory.getLogger(ConverterService.class);

   private static ConverterResponse converterResponse= new ConverterResponse();


    public ConverterResponse converter(ConverterRequest converterRequest) {
        logger.info("input: " +converterRequest.getInput());
        logger.info("fromUnit: " +converterRequest.getFromUnit());
        logger.info("toUnit: " +converterRequest.getToUnit());
        double result=convert(converterRequest,(Double input,String fromUnit)->

        {
            if(fromUnit.equals(Constants.FARENHEIT))
                return (input-Constants.THIRTYTWO)/Constants.FCONSTANT;
            else
                return (input-Constants.KCONSTANT);
        });
        converterResponse.setResult(result);
        converterResponse.setUnit(Constants.CELSIUS);
        return converterResponse;
    }

    public double convert(ConverterRequest converterRequest,ToDoubleBiFunction<Double,String> toDoubleBiFunction)
    {  logger.info("in convert()");
        logger.info("input: " +converterRequest.getInput());
        logger.info("fromUnit: " +converterRequest.getFromUnit());
        logger.info("toUnit: " +converterRequest.getToUnit());
        return toDoubleBiFunction.applyAsDouble(converterRequest.getInput(),converterRequest.getFromUnit());
    }


    }


