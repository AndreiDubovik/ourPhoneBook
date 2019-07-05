package by.omedia.phonebook.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.omedia.phonebook.entities.Contact;
import by.omedia.phonebook.entities.EmailAddress;
import by.omedia.phonebook.entities.PhoneNumber;
import by.phonebook.proxilayer.IContact;
import by.phonebook.proxilayer.IContactBook;
import by.phonebook.proxilayer.INote;

public class SQLContactBook implements IContactBook{
	
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost/test";
	private static final String LOGIN = "postgres";
	private static final String PASSWORD = "1111";
	
	private static Connection CONNECTION;
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			CONNECTION = (Connection) DriverManager.getConnection(URL, LOGIN, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Ooops... I`m sorry... I can`t find out this database...");
			e.printStackTrace();
		}
	}
	
	static{
		String createTableTypes = "create table types (type character varying unique not null, primary key(type));";
		String createTableNotes = "create table notes (id serial, name character varying not null, primary key(id));";
		String createContacts = "create table contacts (id serial, contact character varying not null, note_id bigint references notes(id), type character varying not null references types(type), primary key(id));";
		Statement statement=null;
		try {
			statement = CONNECTION.createStatement();
			statement.execute(createTableTypes);
			statement.execute(createTableNotes);
			statement.execute(createContacts);
		} catch (SQLException e) {
		}
		
	}

	@Override
	public boolean addContact(IContact arg0) {
		// TODO Auto-generated method stub
		return false;
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
		Statement statement = null;
		ResultSet rs = null;
		String query = "select contact,type from contacts";
		List<IContact>list = new ArrayList<>();
		try {
			statement = CONNECTION.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()){
				Contact contact = null;
				String type = rs.getString("type");
				String name = rs.getString("contact");
				switch(type){
				case "email":
					contact = new EmailAddress(name,null);
					break;
				case "phone":
					contact = new PhoneNumber(name,null);
				}
				if(contact!=null)list.add(contact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<INote> getFullNoteList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<INote> getNoteListForName(String arg0) {
		// TODO Auto-generated method stub
		return null;
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
