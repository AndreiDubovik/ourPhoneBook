package by.omedia.phonebook.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import by.phonebook.proxilayer.INote;

public class ContactTest {
	
	private INote note;
	private Contact contact;
	
	@Before
	public void init(){
		this.note = new Note();
		this.contact = new PhoneNumber();
	}

	@Test
	public void getSetTest(){
		assertNull(this.contact.getContact());
		this.contact.setContact("Line");
		assertEquals("Line",this.contact.getContact());
		assertNull(this.contact.getNote());
		this.contact.setNote(note);
		assertEquals(this.note,this.contact.getNote());
	}
}
