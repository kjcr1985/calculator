package com.java.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class OperateServiceImpl implements OperateService{

	@Override
	public Double getSum(Double number1, Double number2) {
		return number1 + number2;
	}

	@Override
	public Double getSubtract(Double number1, Double number2) {
		return number1 - number2;
	}

}
