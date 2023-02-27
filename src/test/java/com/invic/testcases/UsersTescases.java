package com.invic.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import DriverInitiation.Base;

public class UsersTescases extends Base {
	Masterclick master = new Masterclick();
	PlantEquip equip = new PlantEquip();
	UserMethods usemetd = new UserMethods();

	@Test
	public void user() throws InterruptedException {
		master.navigateMaster();
		WebElement employee = driver.findElement(By.xpath("//a[@href='#/master/employeelevel']"));
		employee.click();
		WebElement userside = driver.findElement(By.xpath("//div[@class='sc-dnqmqq hnktPT' and text()='User']"));
		userside.click();

		usemetd.userSearch("ho");
		usemetd.employeSearch("ho");
		usemetd.plantSearch("RMC");

		List<String> usernameTextList = new ArrayList<String>();
		List<String> employeeTextList = new ArrayList<String>();
		List<String> plantTextList = new ArrayList<String>();
		List<String> designationTextList = new ArrayList<String>();
		List<String> contactTextList = new ArrayList<String>();

		String username_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[1]";
		String employee_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[2]";
		String plant_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[3]";
		String designation_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[4]";
		String contact_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[5]";

		List<String> username_Return_List = equip.tableColumnList(usernameTextList, username_xpath);
		List<String> employee_Return_List = equip.tableColumnList(employeeTextList, employee_xpath);
		List<String> plant_Return_List = equip.tableColumnList(plantTextList, plant_xpath);

		String list1 = "hojojo7295@youke1.com,hocip59602@wiroute.com,jiwohod242@youke1.com,hokep93031@mustbeit.com";
		List<String> expectUsername = Arrays.asList(list1.split(","));
		Collections.sort(expectUsername);
		Collections.sort(username_Return_List);

		String list2 = "hojoj,hocip,jiwohod,hoke";
		List<String> expectedemployee = Arrays.asList(list2.split(","));
		Collections.sort(expectedemployee);
		Collections.sort(employee_Return_List);

		String list3 = "RMC Balangoda Plant,RMC Balangoda Plant,RMC Balangoda Plant,RMC Jaffna Plant";
		List<String> expectedPlant = Arrays.asList(list3.split(","));
		Collections.sort(expectedPlant);
		Collections.sort(plant_Return_List);

		boolean searchdata = true;

		try {
			AssertJUnit.assertTrue(username_Return_List.equals(expectUsername)
					&& employee_Return_List.equals(expectedemployee) && plant_Return_List.equals(expectedPlant));
		} catch (AssertionError e) {
			searchdata = false;
		}

		if (searchdata) {
			testCase = extent.createTest("Check Correct Data Count Filter In User");
			testCase.log(Status.INFO, "Correct Data Count Filtered");
			testCase.log(Status.PASS, "Correct Data Count Filtered").assignCategory("High-Severity");
		} else {
			testCase = extent.createTest("Check Correct Data Count Filter In User");
			testCase.log(Status.INFO, "Wrong Datda Count Filtered");
			testCase.log(Status.FAIL, "Wrong Data Count Filtered").assignCategory("High-Severity");
		}

	}

}
