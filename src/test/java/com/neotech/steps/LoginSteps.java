package com.neotech.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonMethods {

//	LoginPageElements login;
//	DashboardPageElements dashboard;

//	@Given("I navigated to Orange HRM website")
//	public void i_navigated_to_orange_hrm_website() {
//		setUp();
////		login = new LoginPageElements();
////		dashboard = new DashboardPageElements();
//	}

	@When("I enter a valid username")
	public void i_enter_a_valid_username() {
		sendText(login.username, ConfigsReader.getProperty("username"));
	}

	@When("I enter a valid password")
	public void i_enter_a_valid_password() {
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() {
		click(login.loginBtn);
	}

	@Then("I validate that I am logged in")
	public void i_validate_that_i_am_logged_in() {
		String expectedText = "Welcome Ram";
		String actualText = dashboard.welcome.getText();

		if (actualText.equals(expectedText)) {
			System.out.println("Test passed!!!");
		} else {
			System.out.println("Test failed!!!");
		}
	}

	@Then("I will quit the browser")
	public void i_will_quit_the_browser() {
		tearDown();
	}

	@When("I enter an invalid password")
	public void i_enter_a_invalid_password() {
		sendText(login.password, "test");
	}

	@Then("I validate that Invalid credentials message is displayed")
	public void i_validate_that_invalid_credentials_message_is_displayed() {
		String message = "Invalid credentials";

		String actualMessage = login.errorMsg.getText();

		if (actualMessage.equals(message)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed!");
		}
	}

	@Given("user is logged in with valid credentials")
	public void user_is_logged_in_with_valid_credentials() {

		// setUp();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

	}

	@When("user enters login info {string} and {string}")
	public void user_enters_login_info_and(String username, String password) {
		sendText(login.username, username);
		sendText(login.password, password);

		wait(2);
	}

	@Then("Welcome {string} message is displayed")
	public void welcome_message_is_displayed(String firstname) {
		String expectedTxt = "Welcome " + firstname;
		String actualTxt = dashboard.welcome.getText();

		wait(2);
		Assert.assertEquals("The welcome message is different!!!", expectedTxt, actualTxt);
	}

	@When("user enters username and password and clicks on login")
	public void user_enters_username_and_password_and_clicks_on_login(DataTable dataTable) {
		// System.out.println("What is inside the datatable?");
		// System.out.println(dataTable);

		List<Map<String, String>> listOfMaps = dataTable.asMaps();
		// System.out.println(listOfMaps);

		for (Map<String, String> map : listOfMaps) {
			// System.out.println(map);

			// Login step
			sendText(login.username, map.get("username"));
			sendText(login.password, map.get("password"));
			click(login.loginBtn);
			wait(1);

			// If we want we can take screeshot

			// Assertion
			String expectedTxt = "Welcome " + map.get("firstname");
			String actualTxt = dashboard.welcome.getText();

			Assert.assertEquals(expectedTxt, actualTxt);

			// Logout
			dashboard.welcome.click();
			dashboard.logout.click();
		}
	}

}
