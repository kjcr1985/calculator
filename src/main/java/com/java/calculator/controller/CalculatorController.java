package com.java.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.calculator.service.OperateService;

import io.corp.calculator.TracerImpl;

@RequestMapping("calculator")
@RestController
public class CalculatorController {

	@Autowired
	private OperateService operateService;
	
	private TracerImpl tracer = new TracerImpl();
	
	@GetMapping(path = "sum/{number1}/{number2}", produces = "application/json")
	public ResponseEntity<Double> getSum(@PathVariable Double number1, @PathVariable Double number2) {
		Double result = operateService.getSum(number1, number2);
		tracer.trace(result);
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
	
	@GetMapping(path = "subtract/{number1}/{number2}", produces = "application/json")
	public ResponseEntity<Double> getSubtract(@PathVariable Double number1, @PathVariable Double number2) {
		Double result = operateService.getSubtract(number1, number2);
		tracer.trace(result);
		return new ResponseEntity<>(result, HttpStatus.OK);
		
	}
}
