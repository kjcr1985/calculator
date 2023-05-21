package com.java.calculator.configurator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;

@Configuration
public class TracerConfigurator{
	
	@Bean
    public TracerImpl tracerImpl() {
		return new TracerImpl();
	}

}
