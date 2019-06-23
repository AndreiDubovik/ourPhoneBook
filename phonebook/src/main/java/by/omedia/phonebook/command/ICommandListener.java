package by.omedia.phonebook.command;

public interface ICommandListener {
	
	Command getCommand(Command...commands);
	Integer getInteger(String question);
	String getString(String question);

}
