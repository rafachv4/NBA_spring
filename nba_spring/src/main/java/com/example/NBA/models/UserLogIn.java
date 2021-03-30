package com.example.NBA.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"UserLogIn",
"email",
"password"
})
public class UserLogIn {

@JsonProperty("UserLogIn")
private String userLogIn;
@JsonProperty("email")
private String email;
@JsonProperty("password")
private String password;

@JsonProperty("UserLogIn")
public String getUserLogIn() {
return userLogIn;
}

@JsonProperty("UserLogIn")
public void setUserLogIn(String userLogIn) {
this.userLogIn = userLogIn;
}

public UserLogIn withUserLogIn(String userLogIn) {
this.userLogIn = userLogIn;
return this;
}

@JsonProperty("email")
public String getEmail() {
return email;
}

@JsonProperty("email")
public void setEmail(String email) {
this.email = email;
}

public UserLogIn withEmail(String email) {
this.email = email;
return this;
}

@JsonProperty("password")
public String getPassword() {
return password;
}

@JsonProperty("password")
public void setPassword(String password) {
this.password = password;
}

public UserLogIn withPassword(String password) {
this.password = password;
return this;
}

public boolean equals(UserLogIn user) {
	Boolean ret = false;
	if(user.getEmail().equals(this.email)) {
		if(user.getPassword().equals(this.password)) {
			ret = true;
		}
	}
	return ret;
}

public boolean equalsSign(UserLogIn user) {
	Boolean ret = false;
	if(user.getEmail().equals(this.email)) {
		ret = true;
	}
	return ret;
}



}