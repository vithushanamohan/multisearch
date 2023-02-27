package com.invic.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import DriverInitiation.Base;

public class SourcesearchMethod extends Base{
	
       public void sourcesearch(String sourcename) {
    	   WebElement sourcesearch = driver.findElement(By.xpath("//th[1]//*[name()='svg']"));
    	   sourcesearch.click();
           WebElement source_input = driver.findElement(By.xpath("//input[@placeholder =' Source' and @name='name']"));
           source_input.sendKeys(sourcename);
       }
       public void descriptionSearch(String description) {
    	   WebElement descriptionsearch = driver.findElement(By.xpath("//th[2]//*[name()='svg']"));
    	   descriptionsearch.click();
           WebElement description_input=driver.findElement(By.xpath("//input[@placeholder=' Description' and @name='description']"));
           description_input.sendKeys(description);
       }
}
