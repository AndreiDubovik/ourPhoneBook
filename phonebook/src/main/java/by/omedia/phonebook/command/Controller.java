package by.omedia.phonebook.command;

import by.omedia.phonebook.IApplication;

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
		case EXIT:return false;
		}
		return false;
	}
	
	private void showNoteList(){
		this.app.getView().showNotes(this.app.getBook().getFullNoteList());
		this.process(this.app.getCommandListener().getCommand(Command.SHOW_NOTE_INFO,Command.CONTINUE));
	}
	
	private void showNoteInfo(){
		
	}
	
	private void showContactList(){
		
	}
	
	private void addNote(){
		
	}

}
