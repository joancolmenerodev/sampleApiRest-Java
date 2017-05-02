package com.tcm.application.DTO;

import com.google.gson.annotations.Expose;
import com.tcm.domain.Student;

public class StudentDTO {
	
	//Si poses @Expose significa que estarà al JSON
	@Expose
	private String id;
	@Expose
	private String name;
	@Expose
	private int age;
	@Expose
	private double averageGrade;
	
	public StudentDTO(Student student){
		this.id=student.getId();
		this.name=student.getName();
		this.age=student.getAge();
		this.averageGrade=student.getAverageGrade();
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
	
	public String getId(){
		return id;
	}

}
