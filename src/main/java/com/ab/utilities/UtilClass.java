package com.ab.utilities;

import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UtilClass {
	private WebDriver driver;
	private ArrayList<Integer> links;

	public UtilClass(WebDriver driver) {

		links = new ArrayList<>();
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public ArrayList<Integer> findBrokenLinks(List<WebElement> element) {
		int i = 0;
		for (WebElement link : element) {

			String urlTxt = link.getAttribute("href");
			int rc = 0;

			try {
				URL url = new URL(urlTxt);
				URLConnection conn = url.openConnection();
				HttpURLConnection http = (HttpURLConnection) conn;
				http.setRequestMethod("GET");
				http.connect();
				rc = http.getResponseCode();
				i++;
				System.out.println(i + " " + urlTxt + " has the response code =" + rc);

				links.add(rc);

			} catch (Exception e) {

			}

		}
		return links;
	}

}
