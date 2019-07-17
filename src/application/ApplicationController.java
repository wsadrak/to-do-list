package application;
import io.ConsolePrinter;
import io.DataReader;
import model.Database;
import model.Option;
import model.Task;

public class ApplicationController {
	private ConsolePrinter printer = new ConsolePrinter();
	private DataReader dataReader = new DataReader(printer);
	
	private Database database = new Database();
	
	public void mainLoop() {
		Option option;
		do {
			printMenu();
			option = getOption();

			switch (option) {
			case NEW_TASK:
				addTask();
				break;
			case EDIT_TASK:
				editTask();
				break;
			case REMOVE_TASK:
				removeTask();
				break;
			case SHOW_TASKS:
				showTasks();
				break;
			case EXIT:
				exit();
				break;
			}
		} while (option != Option.EXIT);
	}

	private void addTask() {
		
		Task newTask = dataReader.readAndCreateTask();
		database.addTask(newTask);
	}

	private void editTask() {
		System.out.println("edit task");

	}

	private void removeTask() {
		System.out.println("remove task");

	}

	private void showTasks() {
		database.showTasks();
		printer.printTasks(database);
	}

	private void exit() {
		System.out.println("exit");
	}


	private Option getOption() {
		Option option = null;
		boolean isOptionCorrect = false;
		while(!isOptionCorrect) {
			option = Option.createFromInt(dataReader.getInt());
			isOptionCorrect = true;
		}
		return option;
	}

	private void printMenu() {
		printer.printLine("Choose the option: ");
		for (Option option : Option.values()) {
			System.out.println(option);
		}

	}

}
