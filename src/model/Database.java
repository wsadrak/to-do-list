package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Database implements Serializable {
	private static final long serialVersionUID = 7908549133902311217L;
	private List<Task> listOfTasks = new ArrayList<>();

	public void addTask(Task task) {
		listOfTasks.add(task);
	}

	public void showTasks() {
		for (Task tasks : listOfTasks) {
			System.out.println(tasks);
		}
	}
	
	// TODO - poprawiæ
	public List<Task> getSortedByPriority() {
		Comparator<Task> comp = new Comparator<Task>() {
			@Override
			public int compare(Task o1, Task o2) {
				return o1.getPriority().compareTo(o2.getPriority());
			}
		};
		Collections.sort(listOfTasks, comp );
		
		return listOfTasks;
	}

	

}
