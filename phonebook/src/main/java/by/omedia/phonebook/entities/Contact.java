package by.omedia.phonebook.entities;

import by.phonebook.proxilayer.IContact;
import by.phonebook.proxilayer.INote;

public abstract  class Contact implements IContact{
	
	private String contact;
	private INote note;
	
	public Contact(){
		
	}

	public String getContactLine() {
		// TODO Auto-generated method stub
		return null;
	}

	public INote getContactHolder() {
		// TODO Auto-generated method stub
		return null;
	}

	abstract boolean validate(String line) ;

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public INote getNote() {
		return note;
	}

	public void setNote(INote note) {
		this.note = note;
	}
	
	

	
}
