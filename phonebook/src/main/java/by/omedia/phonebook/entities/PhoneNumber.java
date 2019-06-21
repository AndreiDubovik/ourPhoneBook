package by.omedia.phonebook.entities;

import by.phonebook.proxilayer.INote;

public class PhoneNumber extends Contact{
	
	public PhoneNumber(){
		
	}
	
	public PhoneNumber(String number, INote note){
		super.setNote(note);
		super.setContact(number);
	}

	@Override
	boolean validate(String line) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
