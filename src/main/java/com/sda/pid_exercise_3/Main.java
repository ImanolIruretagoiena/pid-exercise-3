package com.sda.pid_exercise_3;

/**
 * Main class for the application.
 * @author ImanolIruretagoiena
 * @version 2020.04.29
 */
public class Main {

	/**
	 * Runs the application.
	 * @param args Command-line arguments.
	 */
	public static void main(String[] args) {

		UserMenu menu = new UserMenu();
		menu.displayApplicationHeader();
		menu.displayMenu();
	}

}
