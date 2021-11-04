package com.neotech.steps;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BackgroundSteps extends CommonMethods {

	@Given("Precondition1")
	public void precondition1() {
		System.out.println("Running Precondition1");
	}

	@Given("Precondition2")
	public void precondition2() {
		System.out.println("Running Precondition2");
	}

	@When("Test step Nr1 firstname is {string} and lastname is {string}")
	public void test_step_nr1_firstname_is_and_lastname_is(String firstName, String lastName) {
		System.out.println("Running Test step Nr1 with firstname = " + firstName + " and lastname = " + lastName);
	}

	@When("Test step Nr2")
	public void test_step_nr2() {
		System.out.println("Running Test step Nr2");
	}

	@When("Test step Nr3 age is {int}")
	public void test_step_nr3_age_is(Integer age) {
		System.out.println("Running Test step Nr3 with age = " + age);
	}

	@Then("Validation N1")
	public void validation_n1() {
		System.out.println("Running Validation N1");
	}

	@Then("Validation N2")
	public void validation_n2() {
		System.out.println("Running Validation N2");
	}

	@When("Test step Nr4")
	public void test_step_nr4() {
		System.out.println("Running Test step Nr4");
	}

	@When("Test step Nr5")
	public void test_step_nr5() {
		System.out.println("Running Test step Nr5");
	}

	@When("Test step Nr6")
	public void test_step_nr6() {
		System.out.println("Running Test step Nr6");
	}

	@Then("Validation N3")
	public void validation_n3() {
		System.out.println("Running Validation N3");
	}

	@Then("Validation N4")
	public void validation_n4() {
		System.out.println("Running Validation N4");
	}

}
