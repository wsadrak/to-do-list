package model;
import java.util.NoSuchElementException;

public enum Option {
	EXIT(0, "Exit"), NEW_TASK(1, "Add new task"), EDIT_TASK(2, "Edit task"), REMOVE_TASK(3, "Remove task"), SHOW_TASKS(4, "Show task");

	private int value;
	private String description;
	
	private Option(int value, String description) {
		this.value = value;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "[" + value + "] - " + description; 
	}

	public static Option createFromInt(int option) {
		try {
			return Option.values()[option];
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new NoSuchElementException("Option with ID " + option + " doesn't exist. ");
			
		}
	}
}
