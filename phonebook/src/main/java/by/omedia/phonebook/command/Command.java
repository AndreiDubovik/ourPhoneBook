package by.omedia.phonebook.command;

public enum Command {
	
	SHOW_NOTE_LIST("Показать весь список записей"),
	SHOW_CONTACT_LIST("Показать весь список контактов"),
	ADD_NOTE("Добавить запись"),
	DELETE_NOTE("Удалить запись"),
	UPDATE_NOTE("Изменить запись"),
	ADD_CONTACT("Добавить контакт"),
	DELETE_CONTACT("Удалить контакт"),
	UPDATE_CONTACT("Изменить контакт"),
	SEARCH_NOTE_FOR_NAME("Искать запись по имени"),
	SEARCH_NOTE_FOR_CONTACT("Искать запись по контакту"),
	SHOW_CONTACT_INFO("Показать информацию о контакте"),
	SHOW_NOTE_INFO("Показать информацию о записи"),
	CANCEL("Отмена"),
	CONTINUE("Продолжить"),
	SAVE("Сохранить изменения"),
	EXIT("Выход");
	
	private String command;
	
	private Command(String command){
		this.command = command;
	}
	
	public String toString(){
		return this.command;
	}

}
