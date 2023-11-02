package com.capgemini.bibliotecaSpring.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommonTests {

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
		SeleniumTesting.getDriver().quit();
	}

	@Test
	void testLogInAsAdmin() {
		SeleniumTesting.logInAsAdmin();
	}

	@Test
	void testLogInAsUser() {
		SeleniumTesting.logInAsUser();
	}

	@Test
	void testLogOut() {
		SeleniumTesting.logOut();
	}

	@Test
	void testSignUp() {
		String usr = "testSignUp@email.com";
		String pssd = "1234";
		SeleniumTesting.signIn(usr, pssd, "Nombre", "123456789", "Calle Ejemplo");
	}

	@Test
	void testSignUpAndLogIn() {
		String usr = "testSignUpAndLogIn@email.com";
		String pssd = "1234";
		SeleniumTesting.signIn(usr, pssd, "Nombre", "123456789", "Calle Ejemplo");
		SeleniumTesting.logIn(usr, pssd);
	}

}
