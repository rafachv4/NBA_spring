package com.example.NBA.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.NBA.models.Contact;
import com.example.NBA.models.UserLogIn;
import com.example.NBA.services.ContactService;
import com.example.NBA.services.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestControllerDemo {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<String> logIn(@RequestBody UserLogIn user) {
		
		log.info(user.getEmail() + user.getPassword());
		
		log.info("Logeando User");
		
		String response  = userService.approveLogIn(user);
		
		log.info(response);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
			
	}
	
	@PostMapping("/signUp")
	public ResponseEntity<String> signUp(@RequestBody UserLogIn user) {
		
		log.info(user.getEmail() + user.getPassword());
		
		log.info("Signeando User");
		
		String response  = userService.insertUser(user);
		
		log.info(response);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
			
	}
	
	@Autowired
	private ContactService contactService;
	
	@PostMapping("/contact")
	public ResponseEntity<String> contact(@RequestBody Contact contacto) {
		
		log.info("Creando Comtacto");
		
		String response = contactService.saveContact(contacto);
		
		log.info(response);
				
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	
}
