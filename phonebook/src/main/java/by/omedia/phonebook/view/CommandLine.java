package by.omedia.phonebook.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import by.omedia.phonebook.command.Command;
import by.omedia.phonebook.command.ICommandListener;
import by.omedia.phonebook.command.IMessageView;
import by.omedia.phonebook.entities.EmailAddress;
import by.omedia.phonebook.entities.Note;
import by.omedia.phonebook.entities.PhoneNumber;
import by.phonebook.proxilayer.IContact;
import by.phonebook.proxilayer.INote;
import by.phonebook.proxilayer.IView;

public class CommandLine implements IView,ICommandListener,IMessageView{
	
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
		boolean cont = false;
		int i = 1;
		Map<Integer,Command>commandMap = new HashMap<>();
		for(Command command:commands){
			if(command==Command.CONTINUE){
				cont = true;
				continue;
			}
			if(command==Command.EXIT){
				exit=true;
				continue;
			}
			commandMap.put(i, command);
			System.out.println((i++)+" - "+command.toString());
		}
		if(exit){
			commandMap.put(0, Command.EXIT);
			System.out.println("... для выхода из программы введите '0'");
		}
		if(cont){
			System.out.println("... любой другой ключ для выхода в главное меню");
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

	@Override
	public void showMessage(String message) {
		System.out.println(message);
	}
	
	public INote addNote() {
		System.out.println("Введите имя записи:");
		return new Note(scanner.nextLine());
	}
	
	public IContact addContact(INote note) {
		System.out.println("Введите контакт");
		String contact = scanner.nextLine();
		return new EmailAddress(contact, note);
	}
	
}
