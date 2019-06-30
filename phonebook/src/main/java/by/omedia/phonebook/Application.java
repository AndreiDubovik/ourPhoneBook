package by.omedia.phonebook;

import java.util.HashSet;
import java.util.Set;

import by.omedia.phonebook.command.Command;
import by.omedia.phonebook.command.Controller;
import by.omedia.phonebook.command.ICommandListener;
import by.omedia.phonebook.command.IController;
import by.omedia.phonebook.command.IMessageView;
import by.omedia.phonebook.core.ContactBookCore;
import by.omedia.phonebook.view.CommandLine;
import by.phonebook.proxilayer.IContact;
import by.phonebook.proxilayer.IContactBook;
import by.phonebook.proxilayer.INote;
import by.phonebook.proxilayer.IView;

public class Application implements IApplication {
	
	private static Application APP = new Application();
	private static String FILE_NAME = "contacts.dat"; 
	
	private ICommandListener commandListener;
	private IMessageView messageView;
	private IView view;
	private IContactBook book;
	private IController controller;
	
	private Application(){
		
	}
	
	private void init(){
		CommandLine cl = new CommandLine();
		this.commandListener = cl;
		this.messageView = cl;
		this.view = cl;
		ContactBookCore cb = new ContactBookCore();
		cb.setContacts(readContacts());
		cb.setNotes(readNotes());
		this.book = cb;
		this.controller = new Controller(this);
		
	}
	
	private void run(){
		Command[]commands = {Command.SHOW_NOTE_LIST,Command.SHOW_CONTACT_LIST,Command.ADD_NOTE,Command.EXIT};
		while(this.controller.process(this.commandListener.getCommand(commands)));
		exit();
	}
	
	private void exit(){
		write(this.book);
		this.messageView.showMessage("До свиданья");
	}
	
	public static void start(){
		APP.init();
		APP.run();
	}

	@Override
	public ICommandListener getCommandListener() {
		// TODO Auto-generated method stub
		return this.commandListener;
	}

	@Override
	public IMessageView getMessageView() {
		// TODO Auto-generated method stub
		return this.messageView;
	}

	@Override
	public IView getView() {
		// TODO Auto-generated method stub
		return this.view;
	}

	@Override
	public IContactBook getBook() {
		// TODO Auto-generated method stub
		return this.book;
	}

	
	private Set<INote> readNotes(){
		return new HashSet<>();
	}
	
	private Set<IContact> readContacts(){
		return new HashSet<>();
	}
	
	private void write(IContactBook book){
		
	};
	

}
