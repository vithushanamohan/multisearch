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

public class MaterialMainCategory extends Base {
	Masterclick master = new Masterclick();
	PlantEquip equip = new PlantEquip();
	Material mainMaterial = new Material();
	@Test
	public void materialsearch() throws InterruptedException {
		master.navigateMaster();
		WebElement material = driver.findElement(By.xpath("//a[@href='#/master/materiallevel']"));
		material.click();
		WebElement materialMainCategory = driver.findElement(By.xpath("//div[@class='sc-dnqmqq eHflwQ' and text()='Material Main Category']"));
		materialMainCategory.click();
		mainMaterial.maincategory("o");
		mainMaterial.mainPrefix("M");
		mainMaterial.mainType("Finish Product");
		
		List<String> mainCategoryTextList = new ArrayList<String>();
		List<String> mainPrefixTextList = new ArrayList<String>();
		List<String> mainTypeTextList = new ArrayList<String>();
		
		String mainCategory_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[1]";
		String mainPrefix_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[2]";
		String mainType_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[3]";
		
		List<String> mainCategory_Return_List = equip.tableColumnList(mainCategoryTextList, mainCategory_xpath);
		List<String> mainPrefix_Return_List = equip.tableColumnList(mainPrefixTextList, mainPrefix_xpath);
		List<String> mainType_Return_List = equip.tableColumnList(mainTypeTextList, mainType_xpath);

		String list1 = "Innovation Dry Mortar";
		List<String> expectMaincategory = Arrays.asList(list1.split(","));
		Collections.sort(expectMaincategory);
		Collections.sort(mainCategory_Return_List);

		String list2 = "IDM";
		List<String> expectedmainPrefix = Arrays.asList(list2.split(","));
		Collections.sort(expectedmainPrefix);
		Collections.sort(mainPrefix_Return_List);

		String list3 = "FINISH_PRODUCT";
		List<String> expectedMainType = Arrays.asList(list3.split(","));
		Collections.sort(expectedMainType);
		Collections.sort(mainType_Return_List);

		boolean searchdata = true;

		try {
			AssertJUnit.assertTrue(mainCategory_Return_List.equals(expectMaincategory)
					&& mainPrefix_Return_List.equals(expectedmainPrefix) && mainType_Return_List.equals(expectedMainType));
		} catch (AssertionError e) {
			searchdata = false;
		}

		if (searchdata) {
			testCase = extent.createTest("Check Correct Data Count Filter In Material MAin CAtegory");
			testCase.log(Status.INFO, "Correct Data Count Filtered");
			testCase.log(Status.PASS, "Correct Data Count Filtered").assignCategory("High-Severity");
		} else {
			testCase = extent.createTest("Check Correct Data Count Filter In Material MAin CAtegory");
			testCase.log(Status.INFO, "Wrong Datda Count Filtered");
			testCase.log(Status.FAIL, "Wrong Data Count Filtered").assignCategory("High-Severity");
		}
		
	}
}
