package com.capgemini.bibliotecaSpring.selenium.impl;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bibliotecaSpring.selenium.SeleniumTesting;
import com.capgemini.bibliotecaSpring.selenium.SeleniumUtils;

@SpringBootTest
class LibrosTest {
	private static String URL = "http://localhost:8080/";

	static WebDriver driver;
	static File logLocation;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		SeleniumTesting.setUpBeforeClass(driver, URL);

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		SeleniumTesting.tearDownAfterClass(driver);

	}

	@BeforeEach
	void setUp() throws Exception {
		SeleniumTesting.setUp(driver, URL);

	}

	@AfterEach
	void tearDown() throws Exception {
		SeleniumTesting.tearDown(driver);
	}

	@Test
	void testVerLectores() {
		SeleniumTesting.logInAsAdmin(driver);
		driver.findElement(By.linkText("Libros")).click();
		SeleniumTesting.checkNumberOfUsersOnList(driver, 5);
		SeleniumTesting.espera(1);


	}


	@Test
	void testIrCopiasLibro() {
		SeleniumTesting.logInAsAdmin(driver);
		driver.findElement(By.linkText("Libros")).click();
		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "free", "//tbody/tr",
				2);
		
	}


}
