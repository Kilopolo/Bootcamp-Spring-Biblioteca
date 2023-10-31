package com.capgemini.bibliotecaSpring.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LectorTest {
	static WebDriver driver = SeleniumTesting.getDriver();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		SeleniumTesting.setUpBeforeClass();

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		SeleniumTesting.tearDownAfterClass();
	}

	@BeforeEach
	void setUp() throws Exception {
		SeleniumTesting.setUp();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		SeleniumTesting.logInAsUser();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	@Test
//	public void register() throws InterruptedException {
//		driver.findElement(By.linkText("REGISTER")).click();
////		driver.get("https://demo.guru99.com/test/newtours/register.php");
//		
//		driver.findElement(By.name("firstName")).sendKeys("firstName");
//		driver.findElement(By.name("lastName")).sendKeys("lastName");
//		driver.findElement(By.name("phone")).sendKeys("123123123");
//		driver.findElement(By.name("userName")).sendKeys("123@123.123");
//		driver.findElement(By.name("address1")).sendKeys(" 123");
//		driver.findElement(By.name("city")).sendKeys("123");
//		driver.findElement(By.name("state")).sendKeys("123");
//		driver.findElement(By.name("postalCode")).sendKeys("12312");
//		driver.findElement(By.name("email")).sendKeys("123");
//		driver.findElement(By.name("password")).sendKeys("123");
//		driver.findElement(By.name("confirmPassword")).sendKeys("123");
//
//		Thread.sleep(3000);//para comprobar que esta bien
//		driver.findElement(By.name("submit")).click();
//		WebElement texto = driver.findElement(By.xpath(
//				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]"));
//		assertEquals("Note: Your user name is 123.", texto.getText());
//	}
//	@Test
//	public void signOn() throws InterruptedException {
//		driver.findElement(By.linkText("SIGN-ON")).click();
////		driver.findElement(By.id("email")).click();
//		driver.get("https://demo.guru99.com/test/newtours/login.php");
//		driver.findElement(By.name("userName")).sendKeys("123");
//		driver.findElement(By.name("password")).sendKeys("1234");
//		Thread.sleep(3000);//para comprobar que esta bien
//		driver.findElement(By.name("submit")).click();
//		WebElement texto = driver.findElement(By.xpath(
//				"/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3"));
//		assertEquals("Login Successfully", texto.getText());
//	}

}
