package com.ab.testLayer;

import org.testng.annotations.Test;

import com.ab.baseTest.BaseTestEbay;

public class AddtoCartFunctionaltyTest extends BaseTestEbay {
	
	
	@Test
	public void addToCartTest() {
	
		hp_obj.searchBoxInput("Camera");
		hp_obj.clickOnSearch();
		spp_obj.clickOnFirstProduct();
		pp_obj.getFirstProductName();
	     
		
	}

}
