package com.hrm.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class HomePage extends BasePage{

	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcome;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void logout() throws InterruptedException{	
		welcome.click();
		Thread.sleep(1000);
		logout.click();
	}
	@FindBy(id="menu_pim_viewPimModule")
	private WebElement pim_Menu;
	
	@FindBy(id="menu_pim_addEmployee")
	private WebElement addEmp_Menu;
	
	public void clickPIM_Menu()
	{
		pim_Menu.click();
	}
	
	public void clickAddEmp_Menu()
	{
		addEmp_Menu.click();
	}
	
	
	
}
