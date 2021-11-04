package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.utils.CommonMethods;

public class PersonalDetailsPageElements extends CommonMethods {

	@FindBy(id = "pdMainContainer")
	public WebElement personalDetails;

	@FindBy(id = "personal_txtEmployeeId")
	public WebElement employeeId;

	@FindBy(xpath = "//div[@id='profile-pic']/h1")
	public WebElement profilePic;

	@FindBy(id = "btnSave")
	public WebElement btnEditSave;

	@FindBy(id = "personal_txtLicenNo")
	public WebElement driverLicense;

	@FindBy(id = "personal_txtLicExpDate")
	public WebElement licExpDate;

	@FindBy(id = "personal_txtNICNo")
	public WebElement ssn;

	@FindBy(id = "personal_optGender_1")
	public WebElement male;

	@FindBy(id = "personal_optGender_2")
	public WebElement female;

	@FindBy(id = "personal_cmbNation")
	public WebElement nationality;

	public PersonalDetailsPageElements() {
		PageFactory.initElements(driver, this);
	}

}
