package com.java.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.calculator.service.OperateService;

@RequestMapping("calculator")
@RestController
public class CalculatorController {

	@Autowired
	private OperateService operateService;
	
	
	@GetMapping(path = "/sum/{number1}/{number2}", produces = "application/json")
	public ResponseEntity<Double> getSum(@PathVariable Double number1, @PathVariable Double number2) {
		if((number1  == null) || (number2  == null)){
			throw new NullPointerException("Number 1 and number 2 cannot be null");
		}
		Double result = operateService.getSum(number1, number2);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(path = "/subtract/{number1}/{number2}", produces = "application/json")
	public ResponseEntity<Double> getSubtract(@PathVariable Double number1, @PathVariable Double number2) {
		if( (number1  == null) || (number2  == null)){
			throw new NullPointerException("Number 1 and number 2 cannot be null");
		}
		Double result  = operateService.getSubtract(number1, number2);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
