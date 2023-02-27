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

public class MaterialSubCategory extends Base {
	Masterclick master = new Masterclick();
	PlantEquip equip = new PlantEquip();
	Material subMaterial = new Material();
	@Test
	public void subsearch() throws InterruptedException {
		master.navigateMaster();
		WebElement material = driver.findElement(By.xpath("//a[@href='#/master/materiallevel']"));
		material.click();
		WebElement materialSubCategory = driver.findElement(By.xpath("//div[@class='sc-dnqmqq eHflwQ' and text()='Material Sub Category']"));
		materialSubCategory.click();
		
		subMaterial.materialsubMaincategory("Concrete");
		subMaterial.subPrefix("G3");
		subMaterial.subMainType("Finish Product");
		
		List<String> materialsubcategoryTextList = new ArrayList<String>();
		List<String> materialsubMaincategoryTextList = new ArrayList<String>();
		List<String> subPrefixTextList = new ArrayList<String>();
		List<String> subMainTypeTextList = new ArrayList<String>();
		
		String materialsubcategory_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[1]";
		String materialsubMaincategory_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[2]";
		String subPrefix_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[3]";
		String subMainType_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[4]";
		
		List<String> materialsubcategory_Return_List = equip.tableColumnList(materialsubcategoryTextList, materialsubcategory_xpath);
		List<String> materialsubMaincategory_Return_List = equip.tableColumnList(materialsubMaincategoryTextList, materialsubMaincategory_xpath);
		List<String> subPrefix_Return_List = equip.tableColumnList(subPrefixTextList, subPrefix_xpath);
		List<String> subMainType_Return_List = equip.tableColumnList(subMainTypeTextList, subMainType_xpath);
		
		String list1 = "35 Pile Concrete,Grade 30,Grade 35,Grade 30A,Grade 35A,Grade 37";
		List<String> expectmaterialsubcategory = Arrays.asList(list1.split(","));
		Collections.sort(expectmaterialsubcategory);
		Collections.sort(materialsubcategory_Return_List);

		String list2 = "Concrete,Concrete,Concrete,Concrete,Concrete,Concrete";
		List<String> expectedmaterialsubMaincategory = Arrays.asList(list2.split(","));
		Collections.sort(expectedmaterialsubMaincategory);
		Collections.sort(materialsubMaincategory_Return_List);

		String list3 = "G35PILE,G30,G35,G30A,G35A,G37";
		List<String> expectedsubPrefix = Arrays.asList(list3.split(","));
		Collections.sort(expectedsubPrefix);
		Collections.sort(subPrefix_Return_List);

		String list4 = "FINISH_PRODUCT,FINISH_PRODUCT,FINISH_PRODUCT,FINISH_PRODUCT,FINISH_PRODUCT,FINISH_PRODUCT";
		List<String> expectedsubMainType = Arrays.asList(list4.split(","));
		Collections.sort(expectedsubMainType);
		Collections.sort(subMainType_Return_List);

		boolean searchdata = true;

		try {
			AssertJUnit.assertTrue(materialsubcategory_Return_List.equals(expectmaterialsubcategory)
					&& materialsubMaincategory_Return_List.equals(expectedmaterialsubMaincategory) && subPrefix_Return_List.equals(expectedsubPrefix) && subMainType_Return_List.equals(expectedsubMainType) );
		} catch (AssertionError e) {
			searchdata = false;
		}

		if (searchdata) {
			testCase = extent.createTest("Check Correct Data Count Filter In Material Sub CAtegory");
			testCase.log(Status.INFO, "Correct Data Count Filtered");
			testCase.log(Status.PASS, "Correct Data Count Filtered").assignCategory("High-Severity");
		} else {
			testCase = extent.createTest("Check Correct Data Count Filter In Material Sub CAtegory");
			testCase.log(Status.INFO, "Wrong Datda Count Filtered");
			testCase.log(Status.FAIL, "Wrong Data Count Filtered").assignCategory("High-Severity");
		}

		
	}
}
