package com.example.docker.springcassandradockerdemo;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
