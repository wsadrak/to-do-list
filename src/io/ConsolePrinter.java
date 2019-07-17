package io;

import java.util.List;

import model.Database;
import model.Task;

public class ConsolePrinter {
	public void printLine(String text) {
		System.out.println(text);
	}

//	public void printTasks(Object sortedByPriority) {
//		// TODO Auto-generated method stub
//		
//	}

	public void printTasks(List<Task> database) {
		for(Task anotherTask : database) {
			printLine(anotherTask.toString());
		}
	}
}
