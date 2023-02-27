package com.invic.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.invic.pages.EquipmentPage;

import DriverInitiation.Base;

public class PlantEquip extends Base {
	EquipmentPage equpage = new EquipmentPage();

	public List<String> tableColumnList(List<String> list, String xPath) throws InterruptedException {
		WebElement next = driver.findElement(By.xpath("//li[@title='Next Page']//button"));
		boolean nextBtn = next.isEnabled();
		nextBtn = true;
		while (nextBtn) {
			List<WebElement> PlantElementList = driver.findElements(By.xpath(xPath));

			for (WebElement linkElement : PlantElementList) {
				String linkText = linkElement.getText();

				list.add(linkText);
				System.out.println(linkText);
			}

			nextBtn = next.isEnabled();
			if (nextBtn) {
				next.click();
				Thread.sleep(3000);
			}

			else
				break;

		}

		return list;

	}

	public void plantSearch(String plantName) {
		WebElement plantsearch = driver.findElement(By.xpath("//th[1]//*[name()='svg']"));
		plantsearch.click();
		WebElement plantsearch_input = driver
				.findElement(By.xpath("//input[@placeholder='Plant' and @name='plantName']"));
		plantsearch_input.sendKeys(plantName);
	}

	public void equipmentSearch(String equipmentName) throws InterruptedException {
		WebElement Equipsearch = driver.findElement(By.xpath("//th[2]//*[name()='svg']"));
		Equipsearch.click();
		Thread.sleep(3000);
		WebElement Equipsearch_input = driver
				.findElement(By.xpath("//input[@Placeholder='Equipment' and @name='equipmentName']"));
		Equipsearch_input.sendKeys(equipmentName);
	}

	public void equipmentTypeSearch(String equipmentType) throws InterruptedException {
		WebElement Equiptype = driver.findElement(By.xpath("//th[3]//*[name()='svg']"));
		Equiptype.click();
		Thread.sleep(3000);
		WebElement equipinput = driver.findElement(By.xpath("//input[@id='equipmentType' and @type='search']"));
		equipinput.click();
		WebElement Equiptype_input = driver.findElement(
				By.xpath("//div[@class='ant-select-item-option-content' and text()='" + equipmentType + "']"));
		Equiptype_input.click();
	}

	public void serialNoSearch(String serialNo) {
		WebElement serialno = driver.findElement(By.xpath("//th[4]//*[name()='svg']"));
		serialno.click();
		WebElement serialno_input = driver
				.findElement(By.xpath("//input[@placeholder='Serial No' and @name='serialNo']"));
		serialno_input.sendKeys(serialNo);
	}

	public void brandSearch(String brandName) {
		WebElement Brand = driver.findElement(By.xpath("//th[5]//*[name()='svg']"));
		Brand.click();
		WebElement brand_input = driver.findElement(By.xpath("//input[@placeholder='Brand' and @name='brandName']"));
		brand_input.sendKeys(brandName);

	}

	public void modelSearch(String ModelName) {
		WebElement Model = driver.findElement(By.xpath("//th[6]//*[name()='svg']"));
		Model.click();
		WebElement model_input = driver.findElement(By.xpath("//input[@placeholder='Model' and @name='modelName']"));
		model_input.sendKeys(ModelName);
	}
	public void typeSearch(String typeName) {
		WebElement Type = driver.findElement(By.xpath("//th[8]//*[name()='svg']"));
		Type.click();
		
		WebElement Type_input = driver
				.findElement(By.xpath("//span[@class='ant-select-selection-item' and @title='" + typeName + "']"));
		Type_input.click();
	}
    public void formatNoSearch(int formatNo) {
    	WebElement FormatEquipsearch = driver.findElement(By.xpath("//th[9]//*[name()='svg']"));
    	FormatEquipsearch.click();
		WebElement formatno_input = driver
				.findElement(By.xpath("//input[@placeholder='formatNumber' and @name='formatNumber']"));
		formatno_input.sendKeys(String.valueOf(formatNo));

    }
}
