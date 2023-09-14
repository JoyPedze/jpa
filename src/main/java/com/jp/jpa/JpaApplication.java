package com.jp.jpa;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository,StudentIdCardRepository studentIdCardRepository){
		return args -> {
			Faker faker = new Faker();
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email = String.format("%s.%s@jp.com", firstName,lastName);
			Integer age = faker.number().numberBetween(10,80);
			Student student = new Student(firstName,lastName,email,age);

			student.addBook(new Book("Clean Code", LocalDateTime.now().minusDays(4)));
			student.addBook(new Book("Spring Boot", LocalDateTime.now().minusDays(4)));
			student.addBook(new Book("Spring Data JPA", LocalDateTime.now().minusDays(4)));

			StudentIdCard studentIdCard = new StudentIdCard("123456", student);

			student.setStudentIdCard(studentIdCard);

			student.addEnrolment(new Enrolment(new EnrolmentId(1L,1L),student,new Course("Computer Science","IT"),LocalDateTime.now()));
			student.addEnrolment(new Enrolment(new EnrolmentId(1L,2L),student,new Course("Amigoscode Spring Data JPA","IT"),LocalDateTime.now()));

//			student.enrolToCourse(new Course("Computer Science","IT"));
//			student.enrolToCourse(new Course("Amigoscode Spring Data JPA","IT"));

			studentRepository.save(student);

//			studentIdCardRepository.findById(1L).ifPresent(System.out::println);
			studentRepository.findById(1L).ifPresent(System.out::println);
			studentRepository.findById(1L).ifPresent(s->{
				System.out.println("fetch book lazy...");
				List<Book> books = student.getBooks();
				books.forEach(book -> {
					System.out.println(s.getFirstName()+" borrowed "+book.getBookName());
				});
			});

//			studentRepository.deleteById(1L);






//			Student joy = new Student("Joy", "Pedze", "joy@jp.com", 77);
//			Student joy1 = new Student("Joy", "Pedze", "joy1@jp.com", 78);
//			Student tania = new Student("Tania", "Pedze", "tania@jp.com", 21);
//			studentRepository.saveAll(List.of(joy,tania,joy1));
//			studentRepository.findStudentByEmail("tania@jp.com").ifPresentOrElse(System.out::println,()-> System.out.println("student not found"));
//			studentRepository.whereFirstNameAndAgeEquals("Joy",77).forEach(System.out::println);
//			studentRepository.findStudentsByFirstNameEqualsAndAgeGreaterThanEqual("Joy", 10).forEach(System.out::println);
//			studentRepository.findStudentsByFirstNameEqualsAndAgeGreaterThanEqualNative("Joy",78).forEach(System.out::println);
//			studentRepository.deleteStudentById(3L);
//			studentRepository.findAll().forEach(System.out::println);

//			generateStudents(studentRepository);
//			sorting(studentRepository);
//			PageRequest pageRequest = PageRequest.of(0,5,Sort.by("firstName").ascending());
//			Page<Student> page = studentRepository.findAll(pageRequest);
//			System.out.println(page);

		};
	}

//	private static void sorting(StudentRepository studentRepository) {
//		Sort sort = Sort.by(Sort.Direction.ASC, "firstName");
//		Sort sort1 = Sort.by("firstName").ascending().and(Sort.by("age").descending());
//		studentRepository.findAll(sort1)
//				.forEach(student -> System.out.println(student.getFirstName()+" "+student.getAge()));
//	}

//	private static void generateStudents(StudentRepository studentRepository) {
//		Faker faker = new Faker();
//		for (int i = 0; i <= 20; i++) {
//			String firstName = faker.name().firstName();
//			String lastName = faker.name().lastName();
//			String email = String.format("%s.%s@jp.com", firstName,lastName);
//			Integer age = faker.number().numberBetween(10,80);
//			Student student = new Student(firstName,lastName,email,age);
//			studentRepository.save(student);
//		}
//	}
}
