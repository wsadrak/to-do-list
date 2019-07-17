package io;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.Task;
import model.Priority;

public class DataReader {
	private Scanner scanner = new Scanner(System.in);
	private ConsolePrinter printer;

	public DataReader(ConsolePrinter printer) {
		this.printer = printer;
	}

	public int getInt() {
		try {
			return Integer.parseInt(readText());
		} catch (NumberFormatException e) {
			throw new NoSuchElementException("It's not a number");
		}
	}

	public void close() {
		scanner.close();
	}

	public Task readAndCreateTask() {
		printer.printLine("Podaj teœæ zadania: ");
		String description = readText();
		printer.printLine("Podaj priorytet: ");
		Priority priority = readPriority();
		printer.printLine("Podaj datê w formacie dd-MM-yyyy: ");
		LocalDate date = readDate();
		return new Task(description, priority, date);
	}

	public String readText() {
		return scanner.nextLine();
	}

	private Priority readPriority() {
		String priority = readText();
		if (priority.equalsIgnoreCase("low")) {
			return Priority.LOW;
		} else if (priority.equalsIgnoreCase("medium")) {
			return Priority.MEDIUM;
		} else if (priority.equalsIgnoreCase("high")) {
			return Priority.HIGH;
		} else {
			printer.printLine("Nie wprowadzono poprawnej wartoœci. Ustawiono wartoœæ domyœln¹ LOW");
		}
		return Priority.LOW;
	}

	private LocalDate readDate() {
		DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String dateInput = readText();
		LocalDate createdDate = LocalDate.parse(dateInput, datePattern);
		return createdDate;
	}

}
