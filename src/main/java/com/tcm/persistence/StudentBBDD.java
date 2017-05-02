package com.tcm.persistence;

import java.util.ArrayList;
import java.util.List;

import com.tcm.domain.Student;
import com.tcm.utilities.InvalidStudentException;
import com.tcm.utilities.StudentNotFoundException;

public class StudentBBDD {

	private static List<Student> students=new ArrayList<>();
	
	public static void saveStudent(Student student) throws InvalidStudentException{
		if(student==null) throw new InvalidStudentException();
		if(existsStudent(student.getName())) throw new InvalidStudentException();
		students.add(student);
	}
	
	public static List<Student> getAllStudents(){
		return students;
	}
	
	private static boolean existsStudent(String name){
		try {
			getStudentByName(name);
			return true;
		} catch (StudentNotFoundException e) {
			return false;
		}
	}
	

	public static Student getStudentByName(String name) throws StudentNotFoundException{
		for(Student s : students){
			if(s.getName().equalsIgnoreCase(name)){
				return s;
			}
		}
		throw new StudentNotFoundException();
	}
	
	public static Student getStudentById(String id) throws StudentNotFoundException{
		for(Student s : students){
			if(s.getId().equals(id)){
				return s;
			}
		}
		throw new StudentNotFoundException();
	}

	public static void removeStudent(String id) throws StudentNotFoundException {
		Student s=getStudentById(id);
		students.remove(s);
	}
}
