package com.capgemini.bibliotecaSpring.selenium;

import java.io.File;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class CommonTests {

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
		driver.get(URL);

	}

	@AfterEach
	void tearDown() throws Exception {
		driver.manage().deleteAllCookies();
	}


	@Test
	void testLogOut() {
		SeleniumTesting.logInAsUser(driver);
		SeleniumTesting.logOut(driver);
	}

	
	@Test
	void testLogInAsUser() {
		SeleniumTesting.logInAsUser(driver);
	}
	@Test
	void testLogInAsAdmin() {
		SeleniumTesting.logInAsAdmin(driver);
	}
	
	@Test
	void testSignUp() {
		String usr = "testSignUp@email.com";
		String pssd = "1234";
		SeleniumTesting.signIn(driver,usr, pssd, "Nombre", "123456789", "Calle Ejemplo");
	}
	
	@Test
	void testSignUpAndLogIn() {
		String usr = "testSignUpAndLogIn@email.com";
		String pssd = "1234";
		SeleniumTesting.signIn(driver,usr, pssd, "Nombre", "123456789", "Calle Ejemplo");
//		SeleniumTesting.checkOnLoginPage();

		SeleniumTesting.logIn(driver,usr, pssd);
//		SeleniumTesting.logOut();
	}


}
