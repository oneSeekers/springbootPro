package com.demo.facade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.repository.common.db.DynamicDataSourceRegister;

@SpringBootApplication
@RestController
@RequestMapping("/application")
@ComponentScan(basePackages = "com.demo.*")
@Import(DynamicDataSourceRegister.class)
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	@GetMapping("/health/{ask}")
	public String healthTest(@PathVariable(value="ask")String ask) {
		return ask;
	}
}
