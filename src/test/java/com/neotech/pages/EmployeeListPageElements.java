package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class EmployeeListPageElements extends CommonMethods{

	@FindBy(id="empsearch_id")
	public WebElement empSearchId;
	
	
	@FindBy(id="empsearch_employee_name_empName")
	public WebElement empSearchName;
	
	
	
	@FindBy(id="searchBtn")
	public WebElement empSearchBtn;
	
	public EmployeeListPageElements()
	{
		PageFactory.initElements(driver, this);
	}
	
}
