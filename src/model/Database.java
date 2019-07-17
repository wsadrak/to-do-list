package model;

import java.util.ArrayList;
import java.util.List;

public class Database {
	private List<Task> dataBase = new ArrayList<>();

	public void addTask(Task task) {
		dataBase.add(task);
	}

	public void showTasks() {
		for (Task tasks : dataBase) {
			System.out.println(tasks);
		}
	}
}
