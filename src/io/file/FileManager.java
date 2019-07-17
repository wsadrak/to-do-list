package io.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import exception.DataExportException;
import exception.DataImportException;
import model.Database;

public class FileManager {

	private static final String FILE_NAME = "Database.o";

	public Database importData() {
		try (FileInputStream fis = new FileInputStream(FILE_NAME);
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			return (Database) ois.readObject();
		} catch (ClassNotFoundException e) {
			throw new DataImportException("Niezgodny typ danych w pliku " + FILE_NAME);
		} catch (IOException e) {
			throw new DataImportException("B³¹d odczytu pliku " + FILE_NAME);
		}


	}

	public void exportData(Database database) {
		try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(database);
		} catch (FileNotFoundException e) {
			System.out.println("FNT");
			throw new DataExportException("Brak pliku " + FILE_NAME);
		} catch (IOException e1) {
			System.out.println("IO");
			throw new DataExportException("B³¹d odczytu pliku " + FILE_NAME);
		}
	}

}
