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

public class PlantEquipment extends Base {

	PlantEquip equip = new PlantEquip();
	Masterclick master = new Masterclick();

	@Test
	public void search() throws InterruptedException {
		// TODO Auto-generated method stub

		master.navigateMaster();

		WebElement plantEquipSideButton = driver
				.findElement(By.xpath("//div[contains(text(),'Plant Equipment') and @class ='sc-dnqmqq bEdMec']"));
		plantEquipSideButton.click();

		equip.plantSearch("RMC Peliyagoda Plant");
		equip.equipmentSearch("Digital Balance");
		equip.equipmentTypeSearch("TEST_EQUIPMENT");

//List of Search Element

		List<String> PlantTextList = new ArrayList<String>();
		List<String> EquipmentTextList = new ArrayList<String>();
		List<String> EquipmentTypeTextList = new ArrayList<String>();
		List<String> SerialNoTextList = new ArrayList<String>();
		List<String> BrandTextList = new ArrayList<String>();
		List<String> modelTextList = new ArrayList<String>();
		List<String> typeTextList = new ArrayList<String>();
		List<String> formatTextList = new ArrayList<String>();

		String plant_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[1]";
		String equipment_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[2]";
		String equipmentType_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[3]";
		String serialNo_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[4]";
		String brand_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[5]";
		String model_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[6]";
		String typeElementList_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[6]";
		String formatElementList_xpath = "//tr[contains(@class,'ant-table-row')]/child::td[6]";

		List<String> plant_Return_List = equip.tableColumnList(PlantTextList, plant_xpath);
		List<String> equipment_Return_List = equip.tableColumnList(EquipmentTextList, equipment_xpath);
		List<String> equipmenttype_Return_List = equip.tableColumnList(EquipmentTypeTextList, equipmentType_xpath);

		String list1 = "RMC Peliyagoda Plant,RMC Peliyagoda Plant,RMC Peliyagoda Plant";
		List<String> expectPlant = Arrays.asList(list1.split(","));
		Collections.sort(expectPlant);
		Collections.sort(plant_Return_List);

		String list2 = "Digital Balance,Digital Balance,Digital Balance";
		List<String> expectedequipment = Arrays.asList(list2.split(","));
		Collections.sort(expectedequipment);
		Collections.sort(equipment_Return_List);

		String list3 = "TEST_EQUIPMENT,TEST_EQUIPMENT,TEST_EQUIPMENT";
		List<String> expectedequipmenttype = Arrays.asList(list3.split(","));
		Collections.sort(expectedequipmenttype);
		Collections.sort(equipmenttype_Return_List);
		
		boolean searchdata = true;

		try {
			AssertJUnit
					.assertTrue(plant_Return_List.equals(expectPlant) && equipment_Return_List.equals(expectedequipment)
							&& equipmenttype_Return_List.equals(expectedequipmenttype));
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
