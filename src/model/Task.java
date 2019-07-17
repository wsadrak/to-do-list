import java.time.LocalDate;

public class Task {

	String description;
	Priority priority;
	LocalDate date;
	
	Task(String description, Priority priority, LocalDate date) {
		this.description = description;
		this.priority = priority;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Task [description=" + description + ", priority=" + priority + ", date=" + date + "]";
	}
	
	
	
}
