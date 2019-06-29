package by.omedia.phonebook.command;

import by.omedia.phonebook.IApplication;
import by.omedia.phonebook.view.CommandLine;

public class Controller implements IController{

	private IApplication app;
	
	public Controller(IApplication app){
		this.app = app;
	}
	
	@Override
	public boolean process(Command command) {
		switch(command){
		case SHOW_NOTE_LIST:
			showNoteList();
			return true;
		case ADD_NOTE:
			addNote();
			return true;
		case SHOW_CONTACT_LIST:
			showContactList();
			return true;
		case SHOW_NOTE_INFO:
			showNoteInfo();
			return true;
		case DELETE_NOTE:
			deleteNote();
			return true;
		case UPDATE_NOTE:
			updateNote();
			return true;
		case ADD_CONTACT:
			addContact();
			return true;
		case UPDATE_CONTACT:
			updateContact();
			return true;
		case DELETE_CONTACT:
			deleteContact();
			return true;
		case SHOW_CONTACT_INFO:
			showContactInfo();
			return true;
		case SEARCH_NOTE_FOR_NAME:
			searchNoteForName();
			return true;
		case SEARCH_NOTE_FOR_CONTACT:
			searchNoteForContact();
			return true;
		case EXIT:return false;
		}
		return false;
	}
	
	private void showNoteList(){
		this.app.getView().showNotes(this.app.getBook().getFullNoteList());
		this.process(this.app.getCommandListener().getCommand(Command.SHOW_NOTE_INFO, Command.SEARCH_NOTE_FOR_NAME, Command.UPDATE_NOTE, Command.DELETE_NOTE, Command.CONTINUE));
	}
	
	private void showNoteInfo(){
		this.app.getView().showInfo(this.app.getBook().getForName(this.app.getCommandListener().getString("Введите имя записи")));
	}
	
	private void addNote(){
		this.app.getBook().addNote(((CommandLine)this.app.getCommandListener()).addNote());
		this.process(this.app.getCommandListener().getCommand(Command.ADD_CONTACT, Command.DELETE_CONTACT, Command.UPDATE_CONTACT, Command.CONTINUE));
	}
	
	private void deleteNote(){
		this.app.getBook().removeNote(this.app.getBook().getForName(this.app.getCommandListener().getString("Введите имя записи")));
	}
	
	private void updateNote(){
		
	}
	
	private void searchNoteForName(){
		
	}
	
	private void searchNoteForContact(){
		
	}
	
	private void showContactList(){
		this.app.getView().showContacts(this.app.getBook().getFullContactList());
		this.process(this.app.getCommandListener().getCommand(Command.SHOW_CONTACT_INFO, Command.SEARCH_NOTE_FOR_CONTACT, Command.CONTINUE));
	}
	
	private void showContactInfo(){
		
	}
	
	private void addContact(){
		this.app.getBook().addContact(((CommandLine)this.app.getCommandListener()).addContact(this.app.getBook().getForName(this.app.getCommandListener().getString("Введите имя записи, для которой хотите добавить контакт"))));
	}
	
	private void deleteContact(){
		
	}
	
	private void updateContact(){
		
	}

}
