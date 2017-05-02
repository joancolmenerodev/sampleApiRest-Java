package com.tcm.application;

import java.util.ArrayList;
import java.util.List;

import com.tcm.application.DTO.StudentDTO;
import com.tcm.domain.Student;
import com.tcm.persistence.StudentBBDD;
import com.tcm.utilities.InvalidStudentException;
import com.tcm.utilities.StudentNotFoundException;

public class StudentsController {

	public void registerStudent(StudentDTO studentToRegist) throws InvalidStudentException {
		Student student = new Student(studentToRegist);
		StudentBBDD.saveStudent(student);
	}

	public StudentDTO getStudentDTO(String id) throws StudentNotFoundException {
		Student s=StudentBBDD.getStudentById(id);
		return new StudentDTO(s);
	}

	public List<StudentDTO> getAllStudentsDTO() {
		List<Student> students=StudentBBDD.getAllStudents();
		
		List<StudentDTO> result=new ArrayList<>();
		
		for(Student s:students){
			result.add(new StudentDTO(s));
		}
		
		return result;
	}

	public void removeStudent(String id) throws StudentNotFoundException {
		StudentBBDD.removeStudent(id);
	}

	public void updateStudent(String id, StudentDTO studentToUpdate) throws InvalidStudentException, StudentNotFoundException {
		if(studentToUpdate==null) throw new InvalidStudentException();
		Student s=StudentBBDD.getStudentById(id);
		s.updateStudent(studentToUpdate);
	}

}
