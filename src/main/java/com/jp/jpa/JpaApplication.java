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
			Student joy1 = new Student("Joy", "Pedze", "joy1@jp.com", 78);
			Student tania = new Student("Tania", "Pedze", "tania@jp.com", 21);

			studentRepository.saveAll(List.of(joy,tania,joy1));

			studentRepository.findStudentByEmail("tania@jp.com").ifPresentOrElse(System.out::println,()-> System.out.println("student not found"));
			studentRepository.whereFirstNameAndAgeEquals("Joy",77).forEach(System.out::println);
			studentRepository.findStudentsByFirstNameEqualsAndAgeGreaterThanEqual("Joy", 10).forEach(System.out::println);
			studentRepository.findStudentsByFirstNameEqualsAndAgeGreaterThanEqualNative("Joy",78).forEach(System.out::println);
			studentRepository.deleteStudentById(3L);
			studentRepository.findAll().forEach(System.out::println);
		};
	}

}
