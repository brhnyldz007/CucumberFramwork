package com.neotech.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddEmployeeSteps extends CommonMethods {

	@Given("user navigates to AddEmployee page")
	public void user_navigates_to_add_employee_page() {
		jsClick(dashboard.PIM);
		click(dashboard.addEmp);
	}

	// hardcoded step
	@When("user enters employee first name and last name")
	public void user_enters_employee_first_name_and_last_name() {
		sendText(addEmployee.firstName, "Lionel");
		sendText(addEmployee.lastName, "Messi");
		wait(1);
	}

	// parametrized step
	@When("user enters employee first name {string} and last name {string}")
	public void user_enters_employee_first_name_and_last_name(String firstName, String lastName) {
		sendText(addEmployee.firstName, firstName);
		sendText(addEmployee.lastName, lastName);
		wait(1);
	}

	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		click(addEmployee.saveBnt);
	}

	// hardcoded step
	@Then("validate that employee is added successfully")
	public void validate_that_employee_is_added_successfully() {
		wait(1);
		String expected = "Lionel Messi";
		String actual = personalDetails.profilePic.getText();

		Assert.assertEquals("The name does NOT match!", expected, actual);
	}

	// parametrized step
	@Then("validate that employee {string} is added successfully")
	public void validate_that_employee_is_added_successfully(String expectedText) {
		wait(1);
		String actualText = personalDetails.profilePic.getText();

		Assert.assertEquals("The name does NOT match!", expectedText, actualText);
	}

	@When("user deletes employee id")
	public void user_deletes_employee_id() {
		wait(1);
		addEmployee.employeeId.clear();
		wait(1);
	}

	@When("user clicks on Create Login Details")
	public void user_clicks_on_create_login_details() {
		click(addEmployee.checkBoxLoginDetails);
	}

	@When("user provides credentials")
	public void user_provides_credentials() {
		sendText(addEmployee.username, "GOAT123");
		sendText(addEmployee.password, "Argentina@123");
		sendText(addEmployee.confirmPassword, "Argentina@123");
		wait(1);
	}

	@When("user enters employee {string}, {string} and {string}")
	public void user_enters_employee_and(String first_name, String middle_name, String last_name) {
		sendText(addEmployee.firstName, first_name);
		sendText(addEmployee.middleName, middle_name);
		sendText(addEmployee.lastName, last_name);
	}

	@Then("validate that {string}, {string} and {string} is added successfully")
	public void validate_that_and_is_added_successfully(String firstN, String middleN, String lastN) {
		String expectedTxt = firstN + " " + middleN + " " + lastN;
		String actualTxt = personalDetails.profilePic.getText();

		Assert.assertEquals("The name does NOT match!", expectedTxt, actualTxt);
	}

	@When("user enters employee details and clicks on save and validates it is added")
	public void user_enters_employee_details_and_clicks_on_save_and_validates_it_is_added(
			io.cucumber.datatable.DataTable dataTable) {

		System.out.println(dataTable);

		// We convert it to a list of maps -> {map1, map2, .....}
		List<Map<String, String>> empList = dataTable.asMaps();

		for (Map<String, String> employee : empList) {
			System.out.println(employee);

			String fName = employee.get("FirstName");
			String mName = employee.get("MiddleName");
			String lName = employee.get("LastName");

			sendText(addEmployee.firstName, fName);
			sendText(addEmployee.middleName, mName);
			sendText(addEmployee.lastName, lName);

			click(addEmployee.saveBnt);

			String expectedTxt = fName + " " + mName + " " + lName;
			String actualTxt = personalDetails.profilePic.getText();

			Assert.assertEquals("The name does NOT match!", expectedTxt, actualTxt);

			// Before next iteration
			// I need to go to AddEmployee page again
			wait(1);
			click(dashboard.addEmp);
			wait(1);
		}

	}

	@When("I click on Personal Details Edit")
	public void i_click_on_personal_details_edit() {
		jsClick(personalDetails.btnEditSave);
	}

	@Then("I am able to modify Employee Details {string}, {string}, {string}, {string}, {string}")
	public void i_am_able_to_modify_employee_details(String driverLic, String expDate, String ssn, String gender,
			String nation) {

		sendText(personalDetails.driverLicense, driverLic);

		// sendText(personalDetails.licExpDate, expDate);
		
		// Another way to select the date
		String[] parts = expDate.split("-"); // 2024-02-08
		personalDetails.licExpDate.click();

		WebElement year = driver.findElement(By.className("ui-datepicker-year"));
		selectDropdown(year, parts[0]);
		wait(1);

		WebElement month = driver.findElement(By.className("ui-datepicker-month"));
		// converting 02 -> int 2
		int m = Integer.parseInt(parts[1]);
		selectDropdown(month, m - 1); // because February has index=1
		wait(1);

		List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		// converting 08 -> 8
		int d = Integer.parseInt(parts[2]);
		selectCalendarDate(dates, d + ""); // concatenating to convert 8 to a String
		wait(1);

		sendText(personalDetails.ssn, ssn);
		wait(1);

		if (gender.equalsIgnoreCase("Male")) {
			click(personalDetails.male);
		} else {
			click(personalDetails.female);
		}

		selectDropdown(personalDetails.nationality, nation);

		wait(2);
	}

	@Then("I click on Personal Details Save")
	public void i_click_on_personal_details_save() {
		jsClick(personalDetails.btnEditSave);
	}

}
