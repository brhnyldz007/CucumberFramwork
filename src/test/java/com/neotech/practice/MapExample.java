package com.neotech.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
		Map<String, String> map = new LinkedHashMap<>();
		map.put("firstname", "John");
		map.put("lastname", "Smith");
		map.put("age", "35");

		System.out.println(map);

		String var1 = map.get("firstname");
		System.out.println(var1);

		String var2 = map.get("lastname");
		System.out.println(var2);

	}

}
