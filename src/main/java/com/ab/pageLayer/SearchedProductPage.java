package com.ab.pageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchedProductPage {

	public SearchedProductPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".srp-results.srp-list.clearfix .s-item__link")
	private WebElement firstProduct;

	public void clickOnFirstProduct() {
		firstProduct.click();

	}

}
