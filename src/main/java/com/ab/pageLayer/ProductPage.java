package com.ab.pageLayer;


import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
    public ProductPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	@FindBy(css = "h1.x-item-title__mainTitle")
	private WebElement product;

	public void getFirstProductName() {
		
		String pid =driver.getWindowHandle();
		
		Set<String> childId = driver.getWindowHandles();
		
		for(String id: childId ) {
			
			if(!id.equals(pid)) {
				
				driver.switchTo().window(id);
				System.out.println(product.getText());
				
			}
		}

	}

}
