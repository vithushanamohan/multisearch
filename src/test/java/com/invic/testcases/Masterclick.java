package com.invic.testcases;

import org.openqa.selenium.support.PageFactory;

import com.invic.pages.EquipmentPage;

import DriverInitiation.Base;

public class Masterclick extends Base{
	
	EquipmentPage equpage = new EquipmentPage();
	public void navigateMaster() throws InterruptedException {
		PageFactory.initElements(driver, equpage);
		
		EquipmentPage.Username.sendKeys("admin");
		EquipmentPage.password.sendKeys("tokyo@admin");
		EquipmentPage.submit.click();
		Thread.sleep(3000);
		EquipmentPage.master.click();
		Thread.sleep(3000);
	}
	
}
