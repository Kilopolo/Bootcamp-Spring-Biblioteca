package com.capgemini.bibliotecaSpring.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTesting {



	public static void logIn(WebDriver driver, String user, String password) {
		driver.findElement(By.id("login")).click();
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		checkOnHomePage(driver);

	}

	/**
	 * Vamos a la login page
	 * 
	 * @param user
	 * @param password
	 * @param nombre
	 * @param telefono
	 * @param direccion
	 */
	public static void signIn(WebDriver driver, String user, String password, String nombre, String telefono,
			String direccion) {
		driver.findElement(By.id("signup")).click();

		driver.findElement(By.name("lector.nombre")).sendKeys(nombre);
		driver.findElement(By.name("lector.telefono")).sendKeys(telefono);
		driver.findElement(By.name("lector.direccion")).sendKeys(direccion);
		driver.findElement(By.name("email")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("passwordConfirm")).sendKeys(password);
		driver.findElement(By.name("submit")).click();
		checkOnLoginPage(driver);

	}

	public static void checkOnHomePage(WebDriver driver) {
		WebElement texto;
		try {
			texto = driver.findElement(By.id("userLogedIn"));
			assertEquals("Esta es la parte privada de la web", texto.getText());
		} catch (NoSuchElementException e) {
			fail("Usuario no esta en la pagina de inicio");
		}

	}

	public static void checkOnLoginPage(WebDriver driver) {
		WebElement texto;

		texto = driver.findElement(By.id("loginPage"));
		assertNotEquals(texto, null);
	}

	public static void espera(int tiempo) {
		try {
			Thread.sleep(tiempo*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void logInAsUser(WebDriver driver) {
		logIn(driver, "user@gmail.com", "1234");

	}

	public static void logInAsAdmin(WebDriver driver) {
		logIn(driver, "admin@gmail.com", "1234");

	}

	public static void logOut(WebDriver driver) {
		driver.findElement(By.id("logout")).click();
	}

	public static void checkNumberOfUsersOnList(WebDriver driver, int expectedSize) {
		// Contamos el número de filas de notas
		List<WebElement> elementos = SeleniumUtils.EsperaCargaPagina(driver, "free", "//tbody/tr", 2);
//		CUIDADO AL AÑADIR MAS USUARIOS EN PRUEBAS ANTERIORES
		assertTrue(elementos.size() == expectedSize);
	}

}
