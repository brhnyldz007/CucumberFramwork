package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {

	@FindBy(id = "welcome")
	public WebElement welcome;

	@FindBy(xpath = "//*[@id='menu_pim_viewPimModule']")
	public WebElement PIM;

	@FindBy(id = "menu_pim_addEmployee")
	public WebElement addEmp;

	@FindBy(xpath = "//div[@id='welcome-menu']/ul/li[3]/a")
	public WebElement logout;

	@FindBy(xpath = "//ul[@id='mainMenuFirstLevelUnorderedList']/li/a")
	public List<WebElement> menuList;

	@FindBy(id = "btnAdd")
	public WebElement addEmployeeBtn;

	public DashboardPageElements() {
		PageFactory.initElements(driver, this);
	}
}
