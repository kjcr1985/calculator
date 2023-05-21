package com.java.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.calculator.configurator.TracerConfigurator;

@Service
public class OperateServiceImpl implements OperateService{
	
	@Autowired
	private TracerConfigurator tracerConfigurator;

	@Override
	public Double getSum(Double number1, Double number2) {
		Double result = number1 + number2;
		tracerConfigurator.tracerImpl().trace(result);		
		return result;
	}

	@Override
	public Double getSubtract(Double number1, Double number2) {
		Double result =  number1 - number2;
		tracerConfigurator.tracerImpl().trace(result);	
		return result;
	}

}
