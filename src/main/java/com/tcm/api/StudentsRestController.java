package com.tcm.api;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tcm.application.StudentsController;
import com.tcm.application.DTO.StudentDTO;
import com.tcm.utilities.InvalidStudentException;
import com.tcm.utilities.StudentNotFoundException;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentsRestController {

	protected String toJson(Object o){
		Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(o);
	}	
	
	protected HttpHeaders initHeader(){	
		HttpHeaders httpHeaders= new HttpHeaders();
	    httpHeaders.setContentType(MediaType.APPLICATION_JSON);	    
	    return httpHeaders;
	}

	@RequestMapping(method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> registerStudent(@RequestBody String jStudent) throws InvalidStudentException  {
		Gson gson = new Gson();
		StudentDTO studentToRegist = gson.fromJson(jStudent, StudentDTO.class);
		new StudentsController().registerStudent(studentToRegist);
		return new ResponseEntity<String>(initHeader(), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> getStudent(@PathVariable String id) throws StudentNotFoundException {
		StudentDTO studentDTO = new StudentsController().getStudentDTO(id);
		return new ResponseEntity<String>(toJson(studentDTO), initHeader(), HttpStatus.OK);
	}
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> removeStudent(@PathVariable String id) throws StudentNotFoundException {
		new StudentsController().removeStudent(id);
		return new ResponseEntity<String>(initHeader(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> getAllStudent() {
		List<StudentDTO> studentDTO = new StudentsController().getAllStudentsDTO();
		return new ResponseEntity<String>(toJson(studentDTO), initHeader(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
	public ResponseEntity<String> updateStudent(@PathVariable String id, @RequestBody String jStudent) throws InvalidStudentException, StudentNotFoundException {
		Gson gson = new Gson();
		StudentDTO studentToUpdate = gson.fromJson(jStudent, StudentDTO.class);

		new StudentsController().updateStudent(id,studentToUpdate);
		return new ResponseEntity<String>(initHeader(), HttpStatus.OK);
	}

}
