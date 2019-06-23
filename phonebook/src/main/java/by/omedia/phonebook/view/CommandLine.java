package by.omedia.phonebook.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import by.omedia.phonebook.command.Command;
import by.omedia.phonebook.command.ICommandListener;
import by.phonebook.proxilayer.IContact;
import by.phonebook.proxilayer.INote;
import by.phonebook.proxilayer.IView;

public class CommandLine implements IView,ICommandListener{
	
	private Scanner scanner = new Scanner(System.in);

	@Override
	public void showNotes(List<INote> notes) {
		for(INote note:notes)System.out.println(note.getName());
		System.out.println("всего: "+notes.size()+" записей");
	}

	@Override
	public void showContacts(List<IContact> contacts) {
		for(IContact contact:contacts)System.out.println(contact.getContactLine());
		System.out.println("всего: "+contacts.size()+" контактов");
	}

	@Override
	public void showInfo(INote note) {
		System.out.println("имя: "+note.getName());
		System.out.println("контакты:");
		this.showContacts(note.getContacts());
	}

	@Override
	public void showInfo(IContact contact) {
		System.out.println("Информация о Контакте:");
		System.out.println("   имя владельца: "+contact.getContactHolder().getName());
		System.out.println("   контакт: "+contact.getContactLine());
		
	}

	@Override
	public Command getCommand(Command...commands) {
		System.out.println("Варианты дальнейших действий:");
		boolean exit = false;
		int i = 1;
		Map<Integer,Command>commandMap = new HashMap<>();
		for(Command command:commands){
			if(command==Command.CONTINUE)continue;
			if(command==Command.EXIT)exit=true;
			commandMap.put(i, command);
			System.out.println((i++)+" - "+command.toString());
		}
		if(exit){
			commandMap.put(0, Command.EXIT);
			System.out.println("... для выхода из программы введите '0'");
		}
		Integer integer = this.getInteger("что делаем дальше?");
		Command command = commandMap.get(integer);
		return command!=null?command:Command.CONTINUE;
	}

	@Override
	public Integer getInteger(String question) {
		System.out.println(question);
		String line = scanner.nextLine();
		try{
			return Integer.parseInt(line);
		}catch(NumberFormatException e){
			return null;
		}
	}

	@Override
	public String getString(String question) {
		System.out.println(question);
		return scanner.nextLine();
	}
	
}
