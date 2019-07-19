package model;

import java.io.PrintStream;
import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
	private static final long serialVersionUID = 2413167338316421989L;
	String description;
	Priority priority;
	LocalDate date;
	private int taskId = 1000;

	public Task(String description, Priority priority, LocalDate date) {
		this.description = description;
		this.priority = priority;
		this.date = date;
		this.setTaskId(1000);
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	
	@Override
	public String toString() {
		return String.format("%-5s| %20s     | %8s     | %12s |", taskId, description, priority, date);
	}

//	@Override
//	public int compareTo(Task t) {
//		
//		public int compare(Task o1, Task o2) {
//			return Integer.compare(o1.getTaskId(), o2.getTaskId());
//		}
//		
//		int idCompare = Integer.taskId.compareTo(t.getPriority());
//	    if (priorityCompare != 0) {
//	        return priorityCompare;
//	    }
//	    
//		int priorityCompare = priority.compareTo(t.getPriority());
//	    if (priorityCompare != 0) {
//	        return priorityCompare;
//	    }
//	    int dateCompare = date.compareTo(t.getDate());
//	    if (dateCompare != 0) {
//	        return dateCompare;
//	    }
//	    return description.compareTo(t.getDescription());
////	    return 
//	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	
}
