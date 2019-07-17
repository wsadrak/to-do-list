package model;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class OptionTest {
	
	@Test
	public void whenInput0ThenResultExit() {
		assertEquals(Option.EXIT, Option.createFromInt(0));
	}
	@Test
	public void whenInput1ThenResultNewTask() {
		assertEquals(Option.NEW_TASK, Option.createFromInt(1));
	}
	
	@Test
	public void whenInput2ThenResultExit() {
		assertEquals(Option.EDIT_TASK, Option.createFromInt(2));
	}
	@Test
	public void whenInput3ThenResultNewTask() {
		assertEquals(Option.REMOVE_TASK, Option.createFromInt(3));
	}
	
	@Test
	public void whenInput4ThenResultExit() {
		assertEquals(Option.SHOW_TASKS, Option.createFromInt(4));
	}
	

}
