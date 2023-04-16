package com.ab.pageLayer;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ab.utilities.UtilClass;

public class HomePage extends UtilClass {
	
	
	public HomePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (css = "#gh-ac")
	private WebElement SearchBox;
	
	@FindBy (css = "#gh-btn")
	private WebElement Search_btn;
	@FindBy (css = "#glbfooter td:nth-child(1) a")
	private List<WebElement> footerLinks;
	
	public void searchBoxInput(String input) {
		
		SearchBox.sendKeys(input);
		
	}

	public void clickOnSearch() {
		
		Search_btn.click();
	}
	
	public ArrayList<Integer> checkBrokenLinks() {
		
		return findBrokenLinks(footerLinks);
		
	}
	
	
	

}
