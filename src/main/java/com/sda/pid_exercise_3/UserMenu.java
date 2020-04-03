package com.sda.pid_exercise_3;

import java.util.Scanner;

public class UserMenu {
	
	Scanner keyboard;
	
	public UserMenu() {
		keyboard = new Scanner(System.in);
	}
	
	public void displayApplicationHeader() {
		System.out.println("Pokemon Database (Pokedex)" + "\n"  + "\n" + "---------------------" + "\n"
		+ "\n" + "Welcome to Pokedex");
	}
	
	public void OptionMenu() {
		System.out.println("\n" + "Pick an option:" + "\n" + "(1) Pokemon lookup" + "\n"
	    + "(2) Location lookup" + "\n" + "(3) Quit" + "\n" + "\n" + "Select operation: ");
	}
	
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
