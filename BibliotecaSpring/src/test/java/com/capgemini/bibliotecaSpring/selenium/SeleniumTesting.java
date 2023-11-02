package com.capgemini.bibliotecaSpring.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTesting {
	private static String URL = "http://localhost:8080/";

	static WebDriver driver;
	static File logLocation;

	public static void setUpBeforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get(URL);
	}

	public static void tearDownAfterClass() {

		driver.quit();

	}

	public static void setUp() {

//		driver = new ChromeDriver();
//		driver.get(URL);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void logIn(String user, String password) {
		driver.findElement(By.id("login")).click();
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		checkOnHomePage();

	}

	public static void signIn(String user, String password, String nombre, String telefono, String direccion) {
		driver.findElement(By.id("signup")).click();
		espera(10000);
		driver.findElement(By.name("lector.nombre")).sendKeys(nombre);
		driver.findElement(By.name("lector.telefono")).sendKeys(telefono);
		driver.findElement(By.name("lector.direccion")).sendKeys(direccion);
		driver.findElement(By.name("email")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("passwordConfirm")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		checkOnHomePage();

	}
	private static void checkOnLoginPage() {
		WebElement texto;
		try {
//			espera(10000);
			texto = driver.findElement(By.id("loginPage"));

//			assertEquals("Esta es la parte privada de la web", texto.getText());

		} catch (NoSuchElementException e) {
			fail("Usuario no esta en la pagina login");
		}
	}
	
	
	private static void checkOnHomePage() {
		WebElement texto;
		try {
//			espera(10000);
			texto = driver.findElement(By.id("userLogedIn"));

			assertEquals("Esta es la parte privada de la web", texto.getText());

		} catch (NoSuchElementException e) {
			fail("Usuario no esta en la pagina de inicio");
		}
	}

	public static void espera(int tiempo) {
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void logInAsUser() {
		logIn("user@gmail.com", "1234");

	}

	public static void logInAsAdmin() {
		logIn("admin@gmail.com", "1234");

	}

	public static void logOut() {
		driver.findElement(By.id("logout")).click();
	}

}
