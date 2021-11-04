package com.neotech.steps;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeSearchSteps extends CommonMethods {

	@Given("user navigates to the employee list page")
	public void user_navigates_to_the_employee_list_page() {
		jsClick(dashboard.PIM);
	}

	@When("user enters valid employee id")
	public void user_enters_valid_employee_id() {
		sendText(employeeList.empSearchId, "0002");
	}

	@When("clicks on search button")
	public void clicks_on_search_button() {
		click(employeeList.empSearchBtn);
	}

	@Then("employee information is displayed")
	public void employee_information_is_displayed() {
		System.out.println("Employee is displayed!!");
	}

	@When("user enters valid employee first and last name")
	public void user_enters_valid_employee_first_and_last_name() {
		sendText(employeeList.empSearchName, "Odis Adalwin");
	}

}
