package com.java.calculator.controller;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.java.calculator.service.OperateServiceImpl;

@WebMvcTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
public class CalculatorControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OperateServiceImpl operateService;
	
	@Autowired
	@InjectMocks
	private CalculatorController calculatorController;
	
	@BeforeEach
	public void setUp() throws Exception{
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();
	}
	
	@Test
	public void testCalculatorSumOk() throws Exception{
		String URL = "/sum/{number1}/{number2}";
		
		when(operateService.getSum(Double.valueOf(2), Double.valueOf(2))).thenReturn(Double.valueOf(4));
		
		ResponseEntity<Double> sumResult = calculatorController.getSum(Double.valueOf(2), Double.valueOf(2));
		
		this.mockMvc
			.perform(MockMvcRequestBuilders.get(URL, Double.valueOf(2), Double.valueOf(2)))
			.andExpect(result -> assertEquals(Double.valueOf(4), sumResult.getBody()));
		
	}
	
	@Test
	public void testCalculatorSubstractOk() throws Exception{
		String URL = "/subtract/{number1}/{number2}";
		
		when(operateService.getSubtract(Double.valueOf(4), Double.valueOf(2))).thenReturn(Double.valueOf(2));
		
		ResponseEntity<Double> subtractResult = calculatorController.getSubtract(Double.valueOf(4), Double.valueOf(2));
		
		this.mockMvc
			.perform(MockMvcRequestBuilders.get(URL, Double.valueOf(4), Double.valueOf(2)))
			.andExpect(result -> assertEquals(Double.valueOf(2), subtractResult.getBody()));
	}
	
	
	@Test
	public void testCalculatorSumKO_1() throws Exception{
		Mockito.when(operateService.getSum(Double.valueOf(2), Double.valueOf(2))).thenReturn(null);
		
		assertThatNullPointerException();
		
	}
	
	@Test
	public void testCalculatorSubstractKO_1() throws Exception{
		Mockito.when(operateService.getSubtract(Double.valueOf(4), Double.valueOf(2))).thenReturn(null);
		
		assertThatNullPointerException();
	}
	
	@Test
	public void testCalculatorSumKO_2() throws Exception{
		Mockito.when(operateService.getSum(Double.valueOf(2), null)).thenThrow(NullPointerException.class);
		
		Assertions.assertThrows(NullPointerException.class ,
				() -> {
					calculatorController.getSum(Double.valueOf(4), null);
				});
		
	}
	
	@Test
	public void testCalculatorSubstractKO_2() throws NullPointerException, Exception{
		
		Mockito.when(operateService.getSubtract(Double.valueOf(2), null)).thenThrow(new NullPointerException());
		
		Assertions.assertThrows(NullPointerException.class ,
				() -> {
					calculatorController.getSubtract(Double.valueOf(2), null);
				});
	}
	
	
	@Test
	public void testCalculatorSumKO_3() throws Exception{
		Mockito.when(operateService.getSum(null, Double.valueOf(2))).thenThrow(NullPointerException.class);
		
		Assertions.assertThrows(NullPointerException.class ,
				() -> {
					calculatorController.getSum(null, Double.valueOf(4));
				});
	}
	
	@Test
	public void testCalculatorSubstractKO_3() throws Exception{
		Mockito.when(operateService.getSubtract(null, Double.valueOf(2))).thenThrow(NullPointerException.class);
		
		Assertions.assertThrows(NullPointerException.class ,
				() -> {
					calculatorController.getSubtract(null, Double.valueOf(4));
				});
		
	}
	
}
