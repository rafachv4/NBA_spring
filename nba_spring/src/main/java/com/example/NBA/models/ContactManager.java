package com.example.NBA.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"contacts"
})
public class ContactManager {

@JsonProperty("contacts")
private List<Contact> contacts = null;
@JsonProperty("contacts")
public List<Contact> getContacts() {
return contacts;
}

@JsonProperty("contacts")
public void setContacts(List<Contact> contacts) {
this.contacts = contacts;
}

public ContactManager withContacts(List<Contact> contacts) {
this.contacts = contacts;
return this;
}

}