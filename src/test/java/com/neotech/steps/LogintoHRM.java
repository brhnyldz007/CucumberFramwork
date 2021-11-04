//package com.neotech.steps;
//
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Assert;
//
//import com.neotech.utils.CommonMethods;
//import com.neotech.utils.ConfigsReader;
//
//import io.cucumber.datatable.DataTable;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class LogintoHRM extends CommonMethods {
//
//	@When("user enters login info {string} and {string}")
//	public void user_enters_login_info_and(String username, String password) {
//		sendText(login.username, username);
//		sendText(login.password, password);
//
//	}
//
//	@When("I click on login button")
//	public void i_click_on_login_button() {
//		click(login.loginBtn);
//	}
//
//	@Then("Welcome {string} message is displayed")
//	public void welcome_message_is_displayed(String username) {
//		String expectedText = username;
//		String actualText = dashboard.welcome.getText();
//		Assert.assertEquals(expectedText, actualText, "The name does NOT match!");
//	}
//
//	@When("user enters username and password and clicks on login")
//	public void user_enters_username_and_password_and_clicks_on_login(DataTable dataTable1) {
//		List<Map<String, String>> empList = dataTable1.asMaps();
//
//		for (Map<String, String> employee : empList) {
//			System.out.println(employee);
//
//			String username = employee.get("username");
//			String password = employee.get("password");
//			
//
//			sendText(login.username, username);
//			sendText(login.password, password);
//			click(login.loginBtn);
//			String expectedText = username;
//			String actualText = dashboard.welcome.getText();
//			Assert.assertEquals(expectedText, actualText, "The name does NOT match!");
//
//		}
//	}
//
//}
