package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON file and map/convert to JAVA POJO
			// data/simple-lite.json
			
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			System.out.println("First Name: " + theStudent.getFirstName());
			System.out.println("Last Name: " + theStudent.getLastName());
			
			//print out address: street and city
			Address tempAddress = theStudent.getAddress();
			System.out.println("Street: " + theStudent.getAddress().getStreet());
			System.out.println("City: " + theStudent.getAddress().getCity());
			
			// print out languages
			for(String language: theStudent.getLanguages()) {
				System.out.println(language);
			}
			
		}catch (Exception exc){
			exc.printStackTrace();
		}

	}

}