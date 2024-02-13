package com.learn.cruddemo;

import com.learn.cruddemo.dao.StudentDAO;
import com.learn.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createSrudent(studentDAO);
//			createMultipleStudent(studentDAO);
//			readStudent(studentDAO);
			findAll(studentDAO);
//			findByLastNameWithQuery(studentDAO);
//			updateFirstName(studentDAO);
//			delete(studentDAO);
//			deleteAllStudent(studentDAO);
		};

	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println(studentDAO.deleteAll());
		System.out.println("All deleted");
	}

	private void delete(StudentDAO studentDAO) {
		int studentId = 2;
		studentDAO.deleteStudent(studentId);
	}

	private void updateFirstName(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		student.setFirstName("Prince");
		studentDAO.updateFirstName(student);
		System.out.println(studentDAO.findAll());
	}

	private void findByLastNameWithQuery(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("patel");
		for(var st : students){
			System.out.println(st);
		}
	}

	private void findAll(StudentDAO studentDAO) {
		System.out.println("Displaying all the students");
		List<Student> st = studentDAO.findAll();
		System.out.println(st);
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("creating new student");
		Student tempstudent = new Student("vaibhav","rudani","vaibhavrudani89@gmail.com");
		System.out.println("saving the student");
		studentDAO.save(tempstudent);
		System.out.println("Student generated id"+tempstudent.getId());

		Student student = studentDAO.findById(tempstudent.getId());
		System.out.println(student.toString());
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		System.out.println("creating new student");
		Student tempstudent1 = new Student("vaibhav","rudani","vaibhavrudani89@gmail.com");
		Student tempstudent2 = new Student("vaibhav","rudani","vaibhavrudani89@gmail.com");
		Student tempstudent3 = new Student("vaibhav","rudani","vaibhavrudani89@gmail.com");
		System.out.println("saving the student");
		studentDAO.save(tempstudent1);
		studentDAO.save(tempstudent2);
		studentDAO.save(tempstudent3);
		System.out.println("Student generated id"+tempstudent3.getId());
	}

	private void createSrudent(StudentDAO studentDAO) {
		System.out.println("creating new student");
		Student tempstudent = new Student("vaibhav","rudani","vaibhavrudani89@gmail.com");
		System.out.println("saving the student");
		studentDAO.save(tempstudent);
		System.out.println("Student generated id"+tempstudent.getId());

	}
}
