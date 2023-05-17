package com.java.calculator.controller;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.java.calculator.service.OperateService;

@WebMvcTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	private CalculatorController calculatorController;
	
	@MockBean
	private OperateService operateService;
	
	@BeforeEach
	public void setUp() throws Exception{
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();
	}
	
	@Test
	public void testCalculatorSumOk() throws Exception{
		String URL = "/sum/{number1}/{number2}";
		
		Mockito.when(operateService.getSum(Double.valueOf(2), Double.valueOf(2))).thenReturn(Double.valueOf(4));
		
		ResponseEntity<Double> sumResult = calculatorController.getSum(Double.valueOf(2), Double.valueOf(2));
		
		this.mockMvc
			.perform(MockMvcRequestBuilders.get(URL, Double.valueOf(2), Double.valueOf(2)))
			.andExpect(result -> assertEquals(Double.valueOf(4), sumResult.getBody()));
		
	}
	
	@Test
	public void testCalculatorSubstractOk() throws Exception{
		String URL = "/subtract/{number1}/{number2}";
		
		Mockito.when(operateService.getSubtract(Double.valueOf(4), Double.valueOf(2))).thenReturn(Double.valueOf(2));
		
		ResponseEntity<Double> sumResult = calculatorController.getSubtract(Double.valueOf(4), Double.valueOf(2));
		
		this.mockMvc
			.perform(MockMvcRequestBuilders.get(URL, Double.valueOf(4), Double.valueOf(2)))
			.andExpect(result -> assertEquals(Double.valueOf(2), sumResult.getBody()));
		
	}
	
	
	@Test
	public void testCalculatorSumKO() throws Exception{
		Mockito.when(operateService.getSum(Double.valueOf(2), Double.valueOf(2))).thenReturn(null);
		
		assertThatNullPointerException();
		
	}
	
	@Test
	public void testCalculatorSubstractKO() throws Exception{
		Mockito.when(operateService.getSubtract(Double.valueOf(4), Double.valueOf(2))).thenReturn(null);
		
		assertThatNullPointerException();
	}
}
