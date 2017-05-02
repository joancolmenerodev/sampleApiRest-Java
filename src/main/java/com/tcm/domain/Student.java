package com.tcm.domain;

import com.tcm.application.DTO.StudentDTO;

public class Student {
	private String id;
	private String name;
	private int age;
	private double averageGrade;
	
	private static int ID_COUNTER=0;
	
	
	public Student(String name,int age, double averageGrade){
		initId();
		this.name=name;
		this.age=age;
		this.averageGrade=averageGrade;
		
	}
	
	public Student(StudentDTO studentToRegist) {
		initId();
		updateStudent(studentToRegist);
	}
	
	
	private void initId(){
		this.id=String.valueOf(ID_COUNTER);	
		Student.ID_COUNTER++;
	}

	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public double getAverageGrade() {
		return averageGrade;
	}

	public void updateStudent(StudentDTO student) {
		this.name=student.getName();
		this.age=student.getAge();
		this.averageGrade=student.getAverageGrade();
	}

	public String getId() {
		return id;
	}
}
