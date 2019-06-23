package by.omedia.phonebook.core;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import by.omedia.phonebook.entities.Contact;
import by.phonebook.proxilayer.IContact;
import by.phonebook.proxilayer.IContactBook;
import by.phonebook.proxilayer.INote;

public class ContactBookCore implements IContactBook{

	private Set<IContact> contacts;
	private Set<INote> notes;
	
	@Override
	public boolean addContact(IContact arg0) {
		if(!((Contact)arg0).validate())return false;
		if(this.contacts.contains(arg0))return false;
		if(!this.notes.contains(arg0.getContactHolder()))return false;
		this.contacts.add(arg0);
		return true;
	}

	@Override
	public boolean addNote(INote arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public INote getForContact(IContact arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public INote getForName(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IContact> getFullContactList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<INote> getFullNoteList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<INote> getNoteListForName(String arg0) {
		return this.notes.stream().filter(note->note.getName().contains(arg0)).collect(Collectors.toList());
	}

	@Override
	public boolean removeContact(IContact arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeNote(INote arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
