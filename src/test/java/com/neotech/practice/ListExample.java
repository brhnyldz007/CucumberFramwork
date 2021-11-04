package com.neotech.practice;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("John");
		list.add("Brad");
		list.add("Mary");

		System.out.println(list);

		for (String element : list) {
			System.out.println(element);
		}
	}

}
