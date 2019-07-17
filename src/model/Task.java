package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Comparable<Task>, Serializable {
	private static final long serialVersionUID = 2413167338316421989L;
	String description;
	Priority priority;
	LocalDate date;

	public Task(String description, Priority priority, LocalDate date) {
		this.description = description;
		this.priority = priority;
		this.date = date;
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
		return description + " | " + date + " | " + priority;
	}

	@Override
	public int compareTo(Task t) {
		int priorityCompare = priority.compareTo(t.getPriority());
	    if (priorityCompare != 0) {
	        return priorityCompare;
	    }
	    int dateCompare = date.compareTo(t.getDate());
	    if (dateCompare != 0) {
	        return dateCompare;
	    }
	    return description.compareTo(t.getDescription());
	}

}
