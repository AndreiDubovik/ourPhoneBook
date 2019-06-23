package by.omedia.phonebook.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.phonebook.proxilayer.INote;

public class EmailAddress extends Contact{

	public EmailAddress(){
		
	}
	
	public EmailAddress(String number, INote note){
		super.setNote(note);
		super.setContact(number);
	}
	
	@Override
	public boolean validate() {
		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(this.getContact());
		return matcher.matches();
	}

}
