package application;

import exception.DataExportException;
import exception.DataImportException;
import io.ConsolePrinter;
import io.DataReader;
import io.file.FileManager;
import model.Database;
import model.Option;
import model.Task;

public class ApplicationController {
	private ConsolePrinter printer = new ConsolePrinter();
	private DataReader dataReader = new DataReader(printer);

	private Database database;
	private FileManager fileManager = new FileManager();

	public ApplicationController() {
		try {
			database = fileManager.importData();
			System.out.println("Zaimportowano dane z pliku");

		} catch (DataImportException e) {
			printer.printLine(e.getMessage());
			printer.printLine("Zainicjowano now¹ bazê.");
			database = new Database();
		}
	}

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

		printer.printLine("Jak chcesz posortowaæ?: ");

		printSubMenu();
		int optionValue = dataReader.getInt();

		switch (optionValue) {
		case 0:
			printDefault();
			break;
		case 1:
			printByPriority();
			break;
		case 2:
			printByDate();
			break;
		default:
			printDefault();

		}

//		database.showTasks();
//		printer.printTasks(database.getSortedTasks());
	}

	private void printDefault() {
		// TODO Auto-generated method stub

	}

	private void printByDate() {
		// TODO Auto-generated method stub

	}

	private void printByPriority() {
		// TODO Auto-generated method stub
		printer.printTasks(database.getSortedByPriority());

	}

	private void printSubMenu() {
		System.out.println("[0] - po id ");
		System.out.println("[1] - po priorytecie");
		System.out.println("[2] - po dacie");
	}

	private void exit() {

		try {
			fileManager.exportData(database);
			printer.printLine("Eksport danych do pliku zakoñczony powodzeniem");
		} catch (DataExportException e) {
			printer.printLine(e.getMessage());
		}
		dataReader.close();
		printer.printLine("Koniec programu, papa");
	}

	private Option getOption() {
		Option option = null;
		boolean isOptionCorrect = false;
		while (!isOptionCorrect) {
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
