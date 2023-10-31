package com.capgemini.bibliotecaSpring.model;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTesting {
	private static final String URL = "http://localhost:8080/";
	static WebDriver driver;
	static File logLocation;

	public static void setUpBeforeClass() {
		/*
		 * #0 Configuraciones para poder usar mi WebDriver Cada Browser tiene distinta
		 * configuración y diferente driver (.exe) Firefox: ->
		 * https://github.com/mozilla/geckodriver#selenium ->
		 * https://github.com/SeleniumHQ/selenium/wiki/FirefoxDriver Chrome: ->
		 * https://github.com/SeleniumHQ/selenium/wiki/ChromeDriver IE: ->
		 * https://github.com/SeleniumHQ/selenium/wiki/InternetExplorerDriver Safari: ->
		 * https://github.com/SeleniumHQ/selenium/wiki/SafariDriver Otros: ->
		 * https://github.com/SeleniumHQ/selenium/wiki
		 */

//		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//		capabilities.setCapability("marionette", true);
//		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "/maven-demo/src/test/resources/chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("test-type");
//		options.addArguments("start-maximized");
//		options.addArguments("--window-size=1920,1080");
//		options.addArguments("--enable-precise-memory-info");
//		options.addArguments("--disable-popup-blocking");
//		options.addArguments("--disable-default-apps");
//		options.addArguments("test-type=browser");
		// #1 Creo el WebDriver (el objeto que contiene lo necesario para controlar el
		// browser)
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize(); // maximizo mi browser
		// #2 Le indico al webdriver que visite la URL
		driver.get(URL);
//		driver.get("https://demo.guru99.com/test/newtours/index.php");
//		logPrefs.enable(LogType.BROWSER, Level.ALL);
		
//		WebDriverManager.chromedriver().setup();
	}

	public static void tearDownAfterClass() {
		// Duermo el proceso para ver las modificaciones
//		Thread.sleep(5000);

		// #5 Cierro el browser
		if (logLocation != null && logLocation.exists()) {
			logLocation.delete();
		}
		System.clearProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY);
		System.clearProperty(ChromeDriverService.CHROME_DRIVER_LOG_LEVEL_PROPERTY);

		driver.quit();

	}

	public static void setUp() {
//		driver.get(URL);
//		Thread.sleep(3000);//lo uso para quitar cookies manualmente
//		driver = WebDriverManager.chromedriver().create();
//		driver = new ChromeDriver();
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void logIn(String user, String password) {
		driver.findElement(By.id("login")).click();
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		WebElement texto = driver.findElement(By.xpath("/html/body/h3"));
		assertEquals("Bienvenido a la Biblioteca de Capgemini", texto.getText());

	}

	public static void logInAsUser() {
		logIn("user@gmail.com", "1234");

	}

	public static void logInAsAdmin() {
		logIn("admin@gmail.com", "1234");

	}

}
