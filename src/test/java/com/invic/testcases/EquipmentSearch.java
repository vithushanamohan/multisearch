package com.invic.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.invic.pages.EquipmentPage;

import DriverInitiation.Base;

public class EquipmentSearch extends Base {
	EquipmentPage equpage = new EquipmentPage();
	PlantEquip pl = new PlantEquip();

	@Test

	public void multiplesearch() throws InterruptedException {
		PageFactory.initElements(driver, equpage);
		EquipmentPage.Username.sendKeys("admin");
		EquipmentPage.password.sendKeys("tokyo@admin");
		EquipmentPage.submit.click();
		Thread.sleep(3000);
		EquipmentPage.master.click();
		Thread.sleep(3000);
		EquipmentPage.Equipment.click();
		Thread.sleep(4000);

		WebElement icon1 = driver.findElement(By.xpath("//th[1]//*[name()='svg']"));
		icon1.click();
		EquipmentPage.EquipSearch.sendKeys("Ba");
		WebElement searchequtype = driver
				.findElement(By.xpath("//input[@class='ant-select-selection-search-input' and @type='search']"));
		WebElement searchEqtype = driver.findElement(By.xpath("//th[3]//div[1]//span[2]//span[1]//*[name()='svg']"));
		searchEqtype.click();
		String x = "Production Equipment";
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@id='equipmentType' and @type='search'])")).click();
		driver.findElement(By.xpath("//div[contains(text(),'" + x + "')]")).click();

		Thread.sleep(3000);
	

		
		List<String> EquipmentTextList = new ArrayList<String>();
		List<String> EquipmentTypeTextList = new ArrayList<String>();
        
		
		List<String> equipmentType_Return_List=pl.tableColumnList(EquipmentTypeTextList, x);
		List<String> equipment_Return_List=pl.tableColumnList(EquipmentTextList, x);
		
		
		String list1 = "Batching Plant Admixture Scale,Batching Plant Water Scale,Batching Plant Cement Scale,Batching Plant Aggregate Scale,Wire Basket,Laboratory Analytical Balance,Digital Balance";
		List<String> Equip = Arrays.asList(list1.split(","));
		Collections.sort(Equip);
		Collections.sort(equipment_Return_List);

		String list2 = "PRODUCTION_EQUIPMENT,PRODUCTION_EQUIPMENT,PRODUCTION_EQUIPMENT,PRODUCTION_EQUIPMENT";
		List<String> Equiptype = Arrays.asList(list2.split(","));
		Collections.sort(Equiptype);
		Collections.sort(equipmentType_Return_List);
		
		boolean searchdata = true;
		
		
		try {
            AssertJUnit.assertTrue(equipment_Return_List.equals(Equip) && equipmentType_Return_List.equals(Equiptype));
        } catch (AssertionError e) {
        	searchdata = false;
        }

		if (searchdata) {
			testCase = extent.createTest("Check Correct Data Count Filter In Equipment");
			testCase.log(Status.INFO, "Correct Data Count Filtered");
			testCase.log(Status.PASS, "Correct Data Count Filtered").assignCategory("High-Severity");
		} else {
			testCase = extent.createTest("Check Correct Data Count Filter In Equipment");
			testCase.log(Status.INFO, "Wrong Datda Count Filtered");
			testCase.log(Status.FAIL, "Wrong Data Count Filtered").assignCategory("High-Severity");
		}

	}

}
