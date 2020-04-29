package com.sda.pid_exercise_3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class for retrieving information from API.
 * @author ImanolIruretagoiena
 * @version 2020.04.29
 */
public class GetWebInfo {

	// Scanner for user input.
	private Scanner keyboard;
	// JSON object to store retrieved
	private JSONObject object;
	
	/**
	 * Constructor for the class. Initializes the scanner object.
	 */
	public GetWebInfo() {
		keyboard = new Scanner(System.in);
	}
	
	/**
	 * Method which loads data from the given URL and saves is as a JSON object.
	 * @param urlString URL from which to load the information.
	 */
	public void loadJSONObjectFromWebsite(String urlString) {
		String response = null;
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.addRequestProperty("User-Agent", 
			"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
			connection.connect();
			Scanner responseScanner = new Scanner(connection.getInputStream());
			while(responseScanner.hasNext()) {
				response = responseScanner.nextLine();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		object = new JSONObject(response);
	}
	
	/**
	 * Method which retrieves information about the Pokemon entered by the user.
	 */
	public void getPokemonInfo() {
		System.out.println("Enter name of pokemon: ");
		String pokemonInput = keyboard.nextLine().toLowerCase();
		String urlString = "https://pokeapi.co/api/v2/pokemon/" + pokemonInput;
		loadJSONObjectFromWebsite(urlString);
		System.out.println("\n" + "Information about " + pokemonInput + ":" + "\n" + "ID: " 
		+ object.get("id") + "\n" + "Name: " + object.get("name") + "\n" + "Height: " 
		+ object.get("height") + "\n" + "Weight: " + object.get("weight"));
		JSONArray types = (JSONArray) object.get("types");
		System.out.println("Types:");
		for(int i = 0; i < types.length(); i++) {
			JSONObject typeObject = (JSONObject) types.get(i);
			JSONObject type = (JSONObject) typeObject.get("type");
			String typeName = (String) type.get("name");
			System.out.println(typeName);
		}
	}
	
	/**
	 * Method which retrieves information about the location entered by the user.
	 */
	public void getLocationInfo() {
		System.out.println("Enter name of location: ");
		String locationInput = keyboard.nextLine().toLowerCase();
		String urlString = "https://pokeapi.co/api/v2/location/" + locationInput;
		loadJSONObjectFromWebsite(urlString);
		JSONArray namesArray = (JSONArray) object.get("names");
		System.out.println("\n" + "Names for " + locationInput + ":");
		for(int i = 0; i < namesArray.length(); i++) {
			JSONObject nameObject = (JSONObject) namesArray.get(i);
			String locationName = (String) nameObject.get("name");
			JSONObject languageObject = (JSONObject) nameObject.get("language");
			String languageName = (String) languageObject.get("name");
			System.out.println(locationName + "  (" + languageName + ")");
		}
		JSONObject region = (JSONObject) object.get("region");
		String regionName = (String) region.get("name");
		System.out.println("\n" + "Region: " + regionName);
		
	}
}
