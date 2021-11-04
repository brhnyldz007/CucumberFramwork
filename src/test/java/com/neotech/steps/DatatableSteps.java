package com.neotech.steps;


import java.util.List;
import java.util.Map;



import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DatatableSteps {

	@When("I login to HRMS")
	public void i_login_to_hrms() {
		System.out.println("Login");
	}

	@When("I want to add employees")
	public void i_want_to_add_employees(DataTable dataTable) {
		// How a List of Maps is created
		// Map<String, String> map1 = new HashedMap<>();
		// map1.put("FN", "Shodmon");
		// map1.put("LN", "Baba");
		//
		// Map<String, String> map2 = new HashedMap<>();
		// map2.put("FN", "Enes");
		// map2.put("LN", "Safran");
		//
		// List<Map<String, String>> lm = new ArrayList<>();
		// lm.add(map1);
		// lm.add(map2);

		// This will convert dataTable to a List of Maps
		List<Map<String, String>> listOfMaps = dataTable.asMaps();

		for (Map<String, String> map : listOfMaps) {
			// System.out.println(map);

			System.out.println("--------------------------------");
			System.out.println("Start using data from the map!");
			System.out.println("First Name = " + map.get("FirstName"));
			System.out.println("Middle Name = " + map.get("MiddleName"));
			System.out.println("Last Name = " + map.get("LastName"));

		}

	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		System.out.println("Validating");
	}

}
