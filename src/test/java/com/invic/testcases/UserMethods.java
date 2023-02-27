package com.invic.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverInitiation.Base;

public class UserMethods extends Base {
	public void userSearch(String username) throws InterruptedException {
		WebElement userSearch = driver.findElement(By.xpath("//th[1]//*[name()='svg']"));
		userSearch.click();
		WebElement userSearch_input = driver
				.findElement(By.xpath("//input[@placeholder=' Username' and @name='userName']"));
		userSearch_input.sendKeys(username);
		Thread.sleep(3000);
	}
	public void employeSearch(String employee) throws InterruptedException {
		WebElement employeSearch = driver.findElement(By.xpath("//th[2]//*[name()='svg']"));
		employeSearch.click();
		WebElement employeSearch_input = driver
				.findElement(By.xpath("//input[@placeholder=' Employee' and @name='firstName']"));
		employeSearch_input.sendKeys(employee);
		Thread.sleep(3000);
	}
	public void plantSearch(String plant) throws InterruptedException {
		WebElement plantSearch = driver.findElement(By.xpath("//th[3]//*[name()='svg']"));
		plantSearch.click();
		WebElement plantSearch_input = driver
				.findElement(By.xpath("//input[@placeholder=' Plant' and @name='plantName']"));
		plantSearch_input.sendKeys(plant);
		Thread.sleep(3000);
	}
	public void designationSearch(String designation) throws InterruptedException {
		WebElement designationSearch = driver.findElement(By.xpath("//th[4]//*[name()='svg']"));
		designationSearch.click();
		WebElement designationSearch_input = driver
				.findElement(By.xpath("//input[@placeholder=' Designation' and @name='designationName']"));
		designationSearch_input.sendKeys(designation);
		Thread.sleep(3000);
	}
	public void contactNoSearch(String contactNo) throws InterruptedException {
		WebElement contactNoSearch = driver.findElement(By.xpath("//th[5]//*[name()='svg']"));
		contactNoSearch.click();
		WebElement contactNoSearch_input = driver
				.findElement(By.xpath("//input[@placeholder=' Contact No' and @name='phoneNumber']"));
		contactNoSearch_input.sendKeys(contactNo);
		Thread.sleep(3000);
	}
}
