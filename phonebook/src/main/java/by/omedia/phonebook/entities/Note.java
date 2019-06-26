package by.omedia.phonebook.entities;

import java.util.List;

import by.phonebook.proxilayer.IContact;
import by.phonebook.proxilayer.INote;


public class Note implements INote{

	private String holderName;
	private List<IContact> contacts;
	
	public Note() {
		
	}
	
	public Note(String holderName, List<IContact> contacts) {
		this.holderName = holderName;
		this.contacts = contacts;
	}
	
	public String getName() {
		return this.holderName;
	}

	public List<IContact> getContacts() {
		return this.contacts;
	}

	public boolean removeContact(IContact contact) {
		if(contact == null){
			return false;
		} else if(this.contacts.isEmpty()) {
			return false;
		}else if(!this.contacts.contains(contact)) {
			return false;
		} else {
			this.contacts.remove(contact);
		}
		return true;
	}

	public boolean addContact(IContact contact) {
		if(contact == null) {
			return false;
		} else if(this.contacts.contains(contact)){
			return false;
		} else {
			this.contacts.add(contact);
		}
		return true;
	}
}
