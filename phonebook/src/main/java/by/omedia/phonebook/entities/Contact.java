package by.omedia.phonebook.entities;

import by.phonebook.proxilayer.IContact;
import by.phonebook.proxilayer.INote;

public abstract  class Contact implements IContact{
	
	private String contact;
	private INote note;
	
	public Contact(){
		
	}

	public String getContactLine() {
		return contact;
	}

	public INote getContactHolder() {
		return note;
	}

	public abstract boolean validate() ;

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public INote getNote() {
		return this.note;
	}

	public void setNote(INote note) {
		this.note = note;
	}
	
}
