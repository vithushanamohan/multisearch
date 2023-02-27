package com.invic.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverInitiation.Base;

public class Material extends Base {
	public void maincategory(String maincategory) throws InterruptedException {
		WebElement mainSearch = driver.findElement(By.xpath("//th[1]//*[name()='svg']"));
		mainSearch.click();
		WebElement main_input = driver
				.findElement(By.xpath("//input[@placeholder='Main Category' and @name='name']"));
		main_input.sendKeys(maincategory);
		Thread.sleep(3000);
	}
	public void mainPrefix(String mainPre) throws InterruptedException {
		WebElement main_Prefix= driver.findElement(By.xpath("//th[2]//*[name()='svg']"));
		main_Prefix.click();
		WebElement mainPrefix_input = driver
				.findElement(By.xpath("//input[@placeholder='Prefix' and @name='prefix']"));
		mainPrefix_input.sendKeys(mainPre);
		Thread.sleep(3000);
	}
	public void mainType(String mainTy) throws InterruptedException {
		WebElement main_Type= driver.findElement(By.xpath("//th[3]//*[name()='svg']"));
		main_Type.click();
		Thread.sleep(3000);
		WebElement mainType_input = driver
				.findElement(By.xpath("//input[@id='mainType'  and @type='search']"));
		mainType_input.click();
		WebElement mainType_select = driver.findElement(By.xpath("//div[@class='ant-select-item-option-content' and text()='"+mainTy+"']"));
		mainType_select.click();
		Thread.sleep(3000);
	}
	public void materialsubcategory(String subcategory) throws InterruptedException {
		WebElement subcategorySearch = driver.findElement(By.xpath("//th[1]//*[name()='svg']"));
		subcategorySearch.click();
		WebElement subcategory_input = driver
				.findElement(By.xpath("//input[@placeholder='Material Sub Category' and @name='name']"));
		subcategory_input.sendKeys(subcategory);
		Thread.sleep(3000);
	}
	public void materialsubMaincategory(String subMaincategory) throws InterruptedException {
		WebElement subMaincategorySearch = driver.findElement(By.xpath("//th[2]//*[name()='svg']"));
		subMaincategorySearch.click();
		WebElement subMaincategory_input = driver
				.findElement(By.xpath("//input[@placeholder='Material Main Category' and @name='materialCategoryName']"));
		subMaincategory_input.sendKeys(subMaincategory);
		Thread.sleep(3000);
	}
	public void subPrefix(String subPre) throws InterruptedException {
		WebElement sub_Prefix= driver.findElement(By.xpath("//th[3]//*[name()='svg']"));
		sub_Prefix.click();
		WebElement subPrefix_input = driver
				.findElement(By.xpath("//input[@placeholder='Prefix' and @name='prefix']"));
		subPrefix_input.sendKeys(subPre);
		Thread.sleep(3000);
	}
	public void subMainType(String subMainTy) throws InterruptedException {
		WebElement subMain_Type= driver.findElement(By.xpath("//th[4]//*[name()='svg']"));
		subMain_Type.click();
		Thread.sleep(3000);
		WebElement subMainType_input = driver
				.findElement(By.xpath("//input[@id='materialCategoryMainType'  and @type='search']"));
		subMainType_input.click();
		WebElement submainType_select = driver.findElement(By.xpath("//div[@class='ant-select-item-option-content' and text()='"+subMainTy+"']"));
		submainType_select.click();
		Thread.sleep(3000);
	}

}
