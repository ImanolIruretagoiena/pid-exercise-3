package com.sda.pid_exercise_3;

import java.util.Scanner;

/**
 * Class for displaying a user menu in the console.
 * @author ImanolIruretagoiena
 * @version 2020.04.29
 */
public class UserMenu {
	
	// Scanner object for user input.
	Scanner keyboard;
	
	/**
	 * Constructor for user menu class. Initializes the scanner object.
	 */
	public UserMenu() {
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * Method which displays the application header when it is started.
	 */
	public void displayApplicationHeader() {
		System.out.println("Pokemon Database (Pokedex)" + "\n"  + "\n" + "---------------------" + "\n"
		+ "\n" + "Welcome to Pokedex");
	}
	
	/**
	 * Method which displays options for the user to choose from.
	 */
	public void OptionMenu() {
		System.out.println("\n" + "Pick an option:" + "\n" + "(1) Pokemon lookup" + "\n"
	    + "(2) Location lookup" + "\n" + "(3) Quit" + "\n" + "\n" + "Select operation: ");
	}
	
	/**
	 * Method which displays the option menu and does the appropriate operation based on the option
	 * chosen by the user.
	 */
	public void displayMenu() {
		GetWebInfo webInfo = new GetWebInfo();
		while(true) {
			OptionMenu();
			int operation = keyboard.nextInt();
			if(operation == 1) {
				webInfo.getPokemonInfo();
			} else if(operation == 2) {
				webInfo.getLocationInfo();
			} else if(operation == 3) {
				System.out.println("Goodbye!");
				break;
			}
		}
	}
}
