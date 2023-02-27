package com.invic.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EquipmentPage {
	@FindBy(xpath="//h1[text()='MASTER']")
	public static WebElement master;
	@FindBy(id="usernameOrEmail")
	public static WebElement Username;
	@FindBy(id="password")
	public static WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	public static WebElement submit;
	@FindBy(xpath="//a[@href='#/master/equipmentlevel']")
	public static WebElement Equipment;
    @FindBy(xpath="//div[@class='sc-dnqmqq bEdMec'][normalize-space()='Equipment']")
    public static WebElement SideEquipment;
    @FindBy(xpath="//input[@placeholder=' Equipment']")
    public static WebElement EquipSearch;
    @FindBy(xpath="//tr[contains(@class,'ant-table-row')]/child::td[1]")
    public static WebElement EquipmentList;
}
