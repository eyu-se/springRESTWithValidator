package com.spring.boot.springRESTWithValidator.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.springRESTWithValidator.model.ErrorResponse;
import com.spring.boot.springRESTWithValidator.model.User;

@RestController
public class UserController {

	
	
	@PostMapping("/user")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user, Errors errors) {
		
		if(errors.hasErrors()) {
			ErrorResponse err = new ErrorResponse();
			err.setMessage(errors.getAllErrors()
				.stream()
				.map(x -> x.getDefaultMessage())
				.collect(Collectors.joining(",")));
			
			return new ResponseEntity<Object>(err, HttpStatus.BAD_REQUEST);
			
			
		}
		
		
		return ResponseEntity.ok(user); // shortest way to write return new ResponseEntity<Object>(user, HttpStatus.OK);
		
		
		
	}
	
}
