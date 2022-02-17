package com.example.demo.ProjectException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)  // To give response when page not found. 
public class ResourceNotFound extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFound(String message) {
		
		super (message);
	}

}
