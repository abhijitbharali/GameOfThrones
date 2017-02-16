package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

import generics.Excel;

public class DeleteEmployee extends BaseTest{
	@Test
	public void testDeleteEmployee()
	{
		int rc = Excel.getRowCount(INPUT_PATH, "DeleteEmployee");
		for(int i=1;i<=rc;i++)
		{
			String veiPage=Excel.getCellValue(INPUT_PATH, "DeleteEmployee", i, 0);
			String fn=Excel.getCellValue(INPUT_PATH, "DeleteEmployee", i, 1);
		
		//click on PIM
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.clickPIM_Menu();
		
		
		//verify that Employee Information Page is displayed
		EmpInfoPage eiPage=new EmpInfoPage(driver);
		eiPage.verifyURLhas(veiPage);
		
		
		//select the checkbox of required employee
		eiPage.clickEmpCheckBox(fn);
		
		
		
		//click delete
		eiPage.clickDelete();
		
		//click Ok on the confirmation pop-up
		eiPage.clickOk();
		
		
		
		//verify that deleted employee is not present in the table
		eiPage.verifyEmpIsNotPresent(fn);
		
		
		}
	}

}
