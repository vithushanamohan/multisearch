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

public class SourceSearch extends Base {
	Masterclick master = new Masterclick();
	SourcesearchMethod source = new SourcesearchMethod();
	PlantEquip pl = new PlantEquip();

	@Test
	public void sourcesearch() throws InterruptedException {
		master.navigateMaster();
		WebElement material = driver.findElement(By.xpath("//a[@href='#/master/materiallevel']"));
		material.click();
		WebElement sourceside = driver
				.findElement(By.xpath("//div[@class='sc-dnqmqq hnktPT'][normalize-space()='Source']"));
		sourceside.click();

		List<String> SourceTextList = new ArrayList<String>();
		List<String> descriptionTextList = new ArrayList<String>();

		String Source_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[1]";
		String description_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[2]";

		source.sourcesearch("Mannar");
		source.descriptionSearch("River");
		Thread.sleep(3000);
		List<String> return_source_List = pl.tableColumnList(SourceTextList, Source_xpath);
		List<String> return_descrip_List = pl.tableColumnList(descriptionTextList, description_xpath);

		String list1 = "Mannar";
		List<String> expectSource = Arrays.asList(list1.split(","));
		Collections.sort(expectSource);
		Collections.sort(return_source_List);

		String list2 = "River Sand from Mannar";
		List<String> expectDescription = Arrays.asList(list2.split(","));
		Collections.sort(expectDescription);
		Collections.sort(return_descrip_List);

		boolean searchdata = true;

		try {
			AssertJUnit.assertTrue(
					return_source_List.equals(expectSource) && return_descrip_List.equals(expectDescription));
		} catch (AssertionError e) {
			searchdata = false;
		}

		if (searchdata) {
			testCase = extent.createTest("Check Correct Data Count Filter In Source");
			testCase.log(Status.INFO, "Correct Data Count Filtered");
			testCase.log(Status.PASS, "Correct Data Count Filtered").assignCategory("High-Severity");
		} else {
			testCase = extent.createTest("Check Correct Data Count Filter In Description");
			testCase.log(Status.INFO, "Wrong Datda Count Filtered");
			testCase.log(Status.FAIL, "Wrong Data Count Filtered").assignCategory("High-Severity");
		}

	}

}
