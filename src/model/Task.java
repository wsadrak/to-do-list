package model;
import java.time.LocalDate;

public class Task {

	String description;
	Priority priority;
	LocalDate date;
	
	public Task(String description, Priority priority, LocalDate date) {
		this.description = description;
		this.priority = priority;
		this.date = date;
	}

	@Override
	public String toString() {
		return description + " | " + date + " | " + priority;
	}


	
	
}
