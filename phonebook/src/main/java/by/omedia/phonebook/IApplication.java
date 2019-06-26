package by.omedia.phonebook;

import by.omedia.phonebook.command.ICommandListener;
import by.omedia.phonebook.command.IMessageView;
import by.phonebook.proxilayer.IContactBook;
import by.phonebook.proxilayer.IView;

public interface IApplication {
	
	ICommandListener getCommandListener();
	IMessageView getMessageView();
	IView getView();
	IContactBook getBook();

}
