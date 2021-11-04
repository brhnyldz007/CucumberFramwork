package com.neotech.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;

public class DashboardSteps extends CommonMethods {

	@Then("I want to see this items in the menu")
	public void i_want_to_see_this_items_in_the_menu(DataTable dataTable) {

		// System.out.println(dataTable);

		List<String> expectedList = dataTable.asList();
		System.out.println(expectedList);

		// I will iterate the WebElements, get the text, and store into List<String>
		List<String> actualList = new ArrayList<>();

		for (WebElement element : dashboard.menuList) {
			// get the text from the WebElement and put it into the List<String>
			actualList.add(element.getText());
		}

		System.out.println(actualList);

		Assert.assertEquals(expectedList, actualList);

	}

}
