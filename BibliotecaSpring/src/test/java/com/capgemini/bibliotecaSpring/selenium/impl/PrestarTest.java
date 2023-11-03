package com.capgemini.bibliotecaSpring.selenium.impl;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.bibliotecaSpring.selenium.SeleniumTesting;
import com.capgemini.bibliotecaSpring.selenium.SeleniumUtils;

@SpringBootTest
class PrestarTest {
	private static String URL = "http://localhost:8080/";

	static WebDriver driver = getDriver();
	static File logLocation;

	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		return driver;
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
//		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");

//		driver.manage().
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.manage().window().maximize();
		driver.get(URL);

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();

	}

	@BeforeEach
	void setUp() throws Exception {
//		ChromeOptions options = new ChromeOptions();
//		driver = new ChromeDriver(options);

//		driver.manage().window().maximize();
		driver.get(URL);

	}

	@AfterEach
	void tearDown() throws Exception {
		driver.manage().deleteAllCookies();
	}

	@Test
	void testIrSociosDevolver() {
		SeleniumTesting.logInAsAdmin(driver);
//		driver.findElement(By.linkText("Socios")).click();
		driver.get(URL+"/prestamos/1");
		SeleniumTesting.espera(2);
		List<WebElement> elementosSocio = SeleniumUtils.EsperaCargaPagina(driver, "free", "//tbody/tr", 2);
		driver.findElement(By.name("Devolver")).click();
		List<WebElement> elementosId = SeleniumUtils.EsperaCargaPaginaxpath(driver, "//*[@id=\"5\"]", 2);
		elementosId.get(0).click();
		SeleniumTesting.espera(3);
//		assertTrue((new WebDriverWait(driver, 2))
//				.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"31\"]"))));

	}
	/**
	 * @Test void testIrSocioPrestar() { SeleniumTesting.logInAsAdmin(driver);
	 *       driver.findElement(By.linkText("Socios")).click();
	 *       SeleniumTesting.espera(2);
	 *       driver.findElement(By.name("Lista")).click(); List<WebElement>
	 *       elementos = SeleniumUtils.EsperaCargaPagina(driver, "free",
	 *       "//tbody/tr", 2); List<WebElement> elementosId =
	 *       SeleniumUtils.EsperaCargaPaginaxpath(driver, "//*[@id=\"1\"]", 2);
	 *       driver.findElement(By.name("Ver prestamos")).click(); List<WebElement>
	 *       elementosSocio = SeleniumUtils.EsperaCargaPagina(driver, "free",
	 *       "//tbody/tr", 2);
	 * 
	 *       SeleniumTesting.espera(500); assertTrue((new WebDriverWait(driver, 2))
	 *       .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"31\"]"))));}
	 */
}