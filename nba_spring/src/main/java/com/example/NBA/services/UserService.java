package com.example.NBA.services;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.NBA.models.Contact;
import com.example.NBA.models.UserLogIn;
import com.example.NBA.models.UserLogInManager;

import org.springframework.beans.factory.annotation.Value;

@Service
public class UserService {
	
	@Value("${usersLogIn.api}")
	private String usersLink;
	
	private List userList;
	

	public String approveLogIn(UserLogIn user) {
		
		UserLogInManager managerUsersLog = getAllUsersLog();
		userList = managerUsersLog.getUsers();
		String ret ="";
		int add=0;
		if(user.getEmail().contains("@gmail.com") || user.getEmail().contains("@hotmail.com") || user.getEmail().contains("@yahoo.es") || user.getEmail().contains("@outlook.com")) {
			if(user.getPassword().length()>8) {	
				if(userList.size() == 0) {
					ret ="No hay usuarios registrados todavia, registrese";
				}else {
					for(Object o : userList) {
						if(o instanceof UserLogIn) {
							UserLogIn uli = (UserLogIn) o;
							if(uli.equals(user)) {
								add = 1;
							}
						}
					}
				}
				if(add==0) {
					ret = "Usuario no esta dentro de la base de datos";
				}else if(add==1) {
					ret = "Usuario logeado correctamente : "+user.getEmail();
				}
				
			}else{
				ret = "Password demasiado corta";
			}
		}else{
			ret = "Correo Incorrecto";
		}
		return ret;
	}
	
	private UserLogInManager getAllUsersLog() {

		final RestTemplate restTemplate = new RestTemplate();
		final HttpMethod metodo = HttpMethod.GET;
						
		final ResponseEntity<UserLogInManager> response = restTemplate.exchange(usersLink,metodo,null,UserLogInManager.class);
		
		return response.getBody();
		
	}
	
	public String insertUser(UserLogIn user) {

		UserLogInManager managerUsersLog = getAllUsersLog();
		userList = managerUsersLog.getUsers();
		String ret ="";
		int add=0;
		if(user.getEmail().contains("@gmail.com") || user.getEmail().contains("@hotmail.com") || user.getEmail().contains("@yahoo.es") || user.getEmail().contains("@outlook.com")) {
			if(user.getPassword().length()>8) {		
				for(Object o : userList) {
					if(o instanceof UserLogIn) {
						UserLogIn uli = (UserLogIn) o;
						if(uli.equalsSign(user)) {
							add=1;
						}
					}
				}
				if(add==0) {
					UserLogIn userSign = addUser(user);
					ret = "Usuario añadido correctamente " + userSign.getEmail();
				}else if(add==1) {
					ret = "Usuario existente con ese correo : " + user.getEmail();
				}
			}else{
				ret = "Password demasiado corta";
			}
		}else{
			ret = "Correo Incorrecto";
		}
		return ret;
	}

	private UserLogIn addUser(UserLogIn user) {
		
		final RestTemplate restTemplate = new RestTemplate();
		final HttpMethod metodo = HttpMethod.POST;
		
		HttpHeaders headers= new HttpHeaders();
		
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "application/json");
		
		HttpEntity<UserLogIn> entidad = new HttpEntity<UserLogIn>(user, headers);
				
		final ResponseEntity<UserLogIn> response = restTemplate.exchange(usersLink,metodo,entidad,UserLogIn.class);
		
		return response.getBody();
	}
	

	@PreDestroy
	public void destroy() {
		System.out.print("Apagado del servicio de usuarios");
	}
	
	@PostConstruct
	public void init() {
		System.out.print("Iniciado el servicio de usuarios");
	}

	
}
