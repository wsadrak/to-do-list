
public class ApplicationController {
	private DataReader dataReader = new DataReader();
	private ListController database = new ListController();
	
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
		System.out.println("add task");
		database.addNewTask();
	}

	private void editTask() {
		System.out.println("edit task");

	}

	private void removeTask() {
		System.out.println("remove task");

	}

	private void showTasks() {
		System.out.println("show task");
		
		database.showTasks();
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
		System.out.println("Choose the option: ");
		for (Option option : Option.values()) {
			System.out.println(option);
		}

	}

}
