package by.omedia.phonebook.entities;

import by.phonebook.proxilayer.IContact;
import by.phonebook.proxilayer.INote;

public abstract  class Contact implements IContact{
	
	private int id;
	private String contact;
	private INote note;
	
	public Contact(){
		
	}

	public String getContactLine() {
		// TODO Auto-generated method stub
		return this.contact;
	}

	public INote getContactHolder() {
		// TODO Auto-generated method stub
		return null;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	
}
