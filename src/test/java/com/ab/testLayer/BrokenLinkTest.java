package com.ab.testLayer;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ab.baseTest.BaseTestEbay;

public class BrokenLinkTest extends BaseTestEbay{

	
	@Test
	public void checkAllFooterLinks() {
		List<Integer> list = hp_obj.checkBrokenLinks();
		SoftAssert a = new SoftAssert();
		
		for(int i =1 ; i <list.size();i++) {
			
			a.assertTrue(list
					.get(i)<400,i+"number Link is broken"); 
			System.out.println("done");
			
			
		}
		a.assertAll();
		
		
	}
	
	
}
