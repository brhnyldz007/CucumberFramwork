package com.neotech.practice;

import java.util.*;

public class ListOfMaps {

	public static void main(String[] args) {

		List<Map<String, String>> listOfMaps = new ArrayList<>();

		Map<String, String> map1 = new HashMap<>();
		map1.put("firstname", "John");
		map1.put("lastname", "Smith");
		map1.put("age", "35");

		Map<String, String> map2 = new HashMap<>();
		map2.put("firstname", "Mary");
		map2.put("lastname", "Brown");
		map2.put("age", "25");

		listOfMaps.add(map1);
		listOfMaps.add(map2);

		System.out.println(listOfMaps);

		for (Map<String, String> element : listOfMaps) {
			System.out.println(element);

			String fName = element.get("firstname");
			System.out.println(fName);

			// You can print the lastname & age
		}
	}

}
