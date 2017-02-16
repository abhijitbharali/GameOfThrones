package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Demo extends BaseTest{
	@Test
	public void testA()
	{
	ExtentReports e=new ExtentReports("./report/res.html");
	ExtentTest t1 = e.startTest("Test1");
	t1.log(LogStatus.PASS, "Test1 is passed");
	e.endTest(t1);
	e.flush();
	
}
}
