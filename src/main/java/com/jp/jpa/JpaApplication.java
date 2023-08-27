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

			System.out.println("Adding Joy and Tania");
			studentRepository.saveAll(List.of(joy,tania));

			System.out.print("Number of students: ");
			studentRepository.count();

			studentRepository.findById(1L).ifPresentOrElse(System.out::println,()-> System.out.println("student with ID 11 not found"));
			studentRepository.findById(3l).ifPresentOrElse(System.out::println,()-> System.out.println("student with ID 12 not found"));

			System.out.println("select all students");
			List<Student> students = studentRepository.findAll();
			students.forEach(System.out::println);

			System.out.println("delete tania");
			studentRepository.deleteById(2L);

			System.out.print("Number of students: ");
			System.out.println(studentRepository.count());

		};
	}

}
