package com.example.NBA.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"users"
})
public class UserLogInManager {

@JsonProperty("users")
private List<UserLogIn> users = null;

@JsonProperty("users")
public List<UserLogIn> getUsers() {
return users;
}

@JsonProperty("users")
public void setUsers(List<UserLogIn> users) {
this.users = users;
}

public UserLogInManager withUsers(List<UserLogIn> users) {
this.users = users;
return this;
}

}