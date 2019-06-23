package by.omedia.phonebook.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.phonebook.proxilayer.INote;

public class PhoneNumber extends Contact{
	
	public PhoneNumber(){
		
	}
	
	public PhoneNumber(String number, INote note){
		super.setNote(note);
		super.setContact(number);
	}

	@Override
	public boolean validate() {
		if(this.getContact() == null){
			return false;
		}
		final String PNONE_PATTERN = "^((\\+?375)([0-9]{7,9}))$";
		Pattern pattern = Pattern.compile(PNONE_PATTERN);
		Matcher matcher = pattern.matcher(this.getContact());
		return matcher.matches();
	}

	

}
