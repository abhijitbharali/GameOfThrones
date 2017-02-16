package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.AddEmpPage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpPersonalDetailsPage;

import generics.Excel;

public class CreateEmployee extends BaseTest{
	
	@Test
	public void testCreateEmployee()
	{
		int rc = Excel.getRowCount(INPUT_PATH, "CreateEmployee");
		for(int i=1;i<=rc;i++)
		{
			String aepURL = Excel.getCellValue(INPUT_PATH, "CreateEmployee", i, 0);
			String fn = Excel.getCellValue(INPUT_PATH, "CreateEmployee", i, 1);
			String ln = Excel.getCellValue(INPUT_PATH, "CreateEmployee", i, 2);
			String vpdURl = Excel.getCellValue(INPUT_PATH, "CreateEmployee", i, 3);
		
		//Click on PIM Module
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.clickPIM_Menu();
		
		
		//Click on Add Employee
		dbPage.clickAddEmp_Menu();
		
		//Verify that Add Employee page is displayed
		AddEmpPage aePage=new AddEmpPage(driver);
		aePage.verifyURLhas(aepURL);
		
		
		//Enter valid First Name
		aePage.setFirstName(fn);
		
		//Enter valid Last Name
		aePage.setLastName(ln);
		
		//Click on Save
		aePage.clickSave();
		
		//Verify that Employee Personal details page is displayed
		EmpPersonalDetailsPage epdPage=new EmpPersonalDetailsPage(driver);
		epdPage.verifyURLhas(vpdURl);
		
		//Verify that proper First Name is displayed
		epdPage.verifyFirstName(fn);
		}
	}

}
