import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ListController {
	private List<Task> dataBase = new ArrayList<>();
	DataReader dataReader = new DataReader();
	public void addNewTask() {

		String description = dataReader.readInput();
		Priority priority = readPriority();
		LocalDate date = readDate();
		
		dataBase.add(new Task(description, priority, date));
	}
	private LocalDate readDate() {
		System.out.println("Podaj datê w formacie dd-MM-yyyy");
		DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dateInput = dataReader.readInput();
		LocalDate createdDate = LocalDate.parse(dateInput, datePattern);
		return createdDate;
	}
	private Priority readPriority() {
		System.out.println("Type priority: ");
		String priodesc = dataReader.readInput();
		
		if(priodesc.equalsIgnoreCase("medium")) {
			return Priority.MEDIUM;
		} else if(priodesc.equalsIgnoreCase("low")) {
			return Priority.LOW;
		} else if(priodesc.equalsIgnoreCase("high")) {
			return Priority.HIGH;
		}
		return Priority.EMPTY;
		
		// TODO - obs³u¿yæ sytuacjê gdy u¿ytkownik wpisze coœ innego
			
			
		
	}
	public void showTasks() {
//		dataBase.
		for(Task tasks: dataBase) {
			System.out.println(tasks);
		}
	}
}
