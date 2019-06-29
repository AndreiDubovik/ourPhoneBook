package by.omedia.phonebook.entities;

import java.util.ArrayList;
import java.util.List;

import by.phonebook.proxilayer.IContact;
import by.phonebook.proxilayer.INote;


public class Note implements INote{

	private String name;
	private List<IContact> contacts;
	
	public Note() {
		
	}
	
	public Note(String name){
		this.name = name;
		this.contacts = new ArrayList<>();
	}
	
	public Note(String name, List<IContact> contacts) {
		this.name = name;
		this.contacts = contacts;
	}
	
	public String getName() {
		return this.name;
	}

	public List<IContact> getContacts() {
		return this.contacts;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setContacts(List<IContact> contacts) {
		this.contacts = contacts;
	}
	
	public boolean removeContact(IContact contact) {
		return this.contacts != null && this.contacts.remove(contact);
	}

	public boolean addContact(IContact contact) {
		return this.contacts != null && contact != null && this.contacts.add(contact);
	}
	
}
