package by.omedia.phonebook.entities;

import by.phonebook.proxilayer.INote;

public class PhoneNumber extends Contact{
	
	public PhoneNumber(String number, INote note) throws ValidateException{
		if(!validate(number))throw new ValidateException();
		super.setContact(number);
		super.setNote(note);
	}

	@Override
	boolean validate(String line) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
