package com.example.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(
			StudentRepository repository) {
		return args -> {
			Student ahmad = new Student (
						"ahmad",
						"ahmad@gmail.com",
						LocalDate.of(2000, Month.JANUARY, 8)
			);
			Student syahrul = new Student (
					"syahrul",
					"syahrul@gmail.com",
					LocalDate.of(2000, Month.JUNE, 18)
			);
			
			repository.saveAll(
						List.of(ahmad, syahrul)
					);
		};
	}
	
}
