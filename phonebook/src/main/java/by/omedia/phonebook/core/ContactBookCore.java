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
	public boolean addNote(INote note) {
		if(note == null)return false;
		if(this.notes.contains(note))return false;
		this.notes.add(note);
		return true;
	}

	@Override
	public INote getForContact(IContact contact) {
		if(contact==null)return null;
		return contact.getContactHolder();
	}

	@Override
	public INote getForName(String arg0) {
		List<INote>list = this.notes.stream().filter(note->note.getName().equals(arg0)).limit(1).collect(Collectors.toList());
		return list.size()==0?null:list.get(0);
	}

	@Override
	public List<IContact> getFullContactList() {
		return this.contacts.stream().collect(Collectors.toList());
	}

	@Override
	public List<INote> getFullNoteList() {
		return this.notes.stream().collect(Collectors.toList());
	}

	@Override
	public List<INote> getNoteListForName(String arg0) {
		return this.notes.stream().filter(note->note.getName().contains(arg0)).collect(Collectors.toList());
	}

	@Override
	public boolean removeContact(IContact contact) {
		if(!this.contacts.contains(contact))return false;
		INote note = contact.getContactHolder();
		while(note.removeContact(contact));
		if(!this.contacts.remove(contact)){
			note.addContact(contact);
			return false;
		}else return true;
	}

	@Override
	public boolean removeNote(INote arg0) {
		if(!this.notes.contains(arg0))return false;
		for(IContact contact:this.contacts){
			if(contact.getContactHolder()== arg0)
				this.contacts.remove(contact);
		}
		return this.notes.remove(arg0);
	}

	public Set<IContact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<IContact> contacts) {
		this.contacts = contacts;
	}

	public Set<INote> getNotes() {
		return notes;
	}

	public void setNotes(Set<INote> notes) {
		this.notes = notes;
	}

}
