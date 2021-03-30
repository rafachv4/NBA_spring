package com.example.NBA.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Contact",
"FirstName",
"LastName",
"Email",
"City",
"PhoneNumber"
})
public class Contact {

@JsonProperty("Contact")
private String contact;
@JsonProperty("FirstName")
private String firstName;
@JsonProperty("LastName")
private String lastName;
@JsonProperty("Email")
private String email;
@JsonProperty("City")
private String city;
@JsonProperty("PhoneNumber")
private Integer phoneNumber;

@JsonProperty("Contact")
public String getContact() {
return contact;
}

@JsonProperty("Contact")
public void setContact(String contact) {
this.contact = contact;
}

public Contact withContact(String contact) {
this.contact = contact;
return this;
}

@JsonProperty("FirstName")
public String getFirstName() {
return firstName;
}

@JsonProperty("FirstName")
public void setFirstName(String firstName) {
this.firstName = firstName;
}

public Contact withFirstName(String firstName) {
this.firstName = firstName;
return this;
}

@JsonProperty("LastName")
public String getLastName() {
return lastName;
}

@JsonProperty("LastName")
public void setLastName(String lastName) {
this.lastName = lastName;
}

public Contact withLastName(String lastName) {
this.lastName = lastName;
return this;
}

@JsonProperty("Email")
public String getEmail() {
return email;
}

@JsonProperty("Email")
public void setEmail(String email) {
this.email = email;
}

public Contact withEmail(String email) {
this.email = email;
return this;
}

@JsonProperty("City")
public String getCity() {
return city;
}

@JsonProperty("City")
public void setCity(String city) {
this.city = city;
}

public Contact withCity(String city) {
this.city = city;
return this;
}

@JsonProperty("PhoneNumber")
public Integer getPhoneNumber() {
return phoneNumber;
}

@JsonProperty("PhoneNumber")
public void setPhoneNumber(Integer phoneNumber) {
this.phoneNumber = phoneNumber;
}

public Contact withPhoneNumber(Integer phoneNumber) {
this.phoneNumber = phoneNumber;
return this;
}

public boolean equals(Contact contacto) {

	if(contacto.getEmail().equals(this.getEmail())) {
			return true;
	}else {
		return false;
	}
}

}