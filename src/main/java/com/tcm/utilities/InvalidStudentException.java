package com.tcm.utilities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE, reason="Invalid Parameters") 
public class InvalidStudentException extends Exception{

}
