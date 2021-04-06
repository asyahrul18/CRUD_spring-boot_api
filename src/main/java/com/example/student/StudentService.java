package com.example.student;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> studentOptional = studentRepository.findByEmail(student.getEmail());
		if (studentOptional.isPresent()) {
			throw new IllegalStateException("Email taken");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException("student with id " + studentId + " does not exists");
		}
		studentRepository.deleteById(studentId);
	}

//	Menampilkan data dalam bentuk json
//	public List<Student> getStudents() {
//		return List.of(
//				new Student(
//						1L,
//						"Ahmad",
//						"ahmad@gmail.com",
//						LocalDate.of(2000, Month.JANUARY, 5),
//						21
//				)
//		);
//				
//	}
	
}
