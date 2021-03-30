package com.example.NBA.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import com.example.NBA.models.Contact;
import com.example.NBA.models.ContactManager;

@Service
public class ContactService {
	
	@Value("${contacts.api}")
	private String usersLink;
	
	private List contactList;


	public String saveContact(Contact contacto) {
		
		ContactManager contactmanag = getAllContacts();
		contactList = contactmanag.getContacts();
		String ret = "WRONG";
		int add = 0;
		if(contacto.getEmail().contains("@gmail.com") || contacto.getEmail().contains("@hotmail.com") || contacto.getEmail().contains("@yahoo.es") || contacto.getEmail().contains("@outlook.com")) {
			if(contacto.getPhoneNumber().toString().length()==9) {
				if(contactList.size() == 0) {
					Contact contact = addContact(contacto);
					ret ="Contacto añadido correctamente a la lista vacia : "+contact.getFirstName()+" "+contact.getLastName()+" from "+contact.getCity()+ "with email = " + contact.getEmail()+ " and phone number = " + contact.getPhoneNumber();
				}else {
					for(Object o : contactList) {
						if(o instanceof Contact) {
							Contact cont = (Contact) o;
							if(cont.equals(contacto)) {
								add=1;
							}
						}
					}
					if(add == 1) {
						ret = "Contacto ya especificado con el mismo correo :"+contacto.getEmail();
					}else if(add==0){
						Contact contact = addContact(contacto);
						ret ="Contacto añadido correctamente : "+contact.getFirstName()+" "+contact.getLastName()+" from "+contact.getCity()+ " with email = " + contact.getEmail()+ " and phone number = " + contact.getPhoneNumber();
					}
				}
				
			}else{
				ret = "Nº de telefono no admitido, tiene que tener 9 digitos";
			}
		}else{
			ret = "Correo Incorrecto";
		}	
		return ret;
	}
	
	private Contact addContact(Contact contacto) {
		
		final RestTemplate restTemplate = new RestTemplate();
		final HttpMethod metodo = HttpMethod.POST;
		
		HttpHeaders headers= new HttpHeaders();
		
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "application/json");
		
		HttpEntity<Contact> entidad = new HttpEntity<Contact>(contacto, headers);
				
		final ResponseEntity<Contact> response = restTemplate.exchange(usersLink,metodo,entidad,Contact.class);
		
		return response.getBody();
		
	}

	private ContactManager getAllContacts() {

		final RestTemplate restTemplate = new RestTemplate();
		final HttpMethod metodo = HttpMethod.GET;
				
		final ResponseEntity<ContactManager> response = restTemplate.exchange(usersLink,metodo,null,ContactManager.class);
		
		return response.getBody();
		
	}
	
	@PreDestroy
	public void destroy() {
		System.out.print("Apagado del servicio de contactos");
	}
	
	@PostConstruct
	public void init() {
		System.out.print("Iniciado el servicio de contactos");
	}
}

