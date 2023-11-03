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
		SeleniumTesting.tearDown();
	}

	@Test
	void testLogOut() {
		SeleniumTesting.logInAsUser();
		SeleniumTesting.logOut();
	}

	
	@Test
	void testLogInAsUser() {
		SeleniumTesting.logInAsUser();
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
//		SeleniumTesting.checkOnLoginPage();

		SeleniumTesting.logIn(usr, pssd);
//		SeleniumTesting.logOut();
	}


}
