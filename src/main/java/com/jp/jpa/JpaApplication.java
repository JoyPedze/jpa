package com.jp.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args -> {
			Student joy = new Student("Joy", "Pedze", "joy@jp.com", 77);
			Student tania = new Student("Tania", "Pedze", "tania@jp.com", 21);

			studentRepository.saveAll(List.of(joy,tania));

			studentRepository.findStudentByEmail("tania@jp.com").ifPresentOrElse(System.out::println,()-> System.out.println("student not found"));
		};
	}

}
