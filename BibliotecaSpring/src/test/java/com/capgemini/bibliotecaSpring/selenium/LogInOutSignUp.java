package com.capgemini.bibliotecaSpring.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LogInOutSignUp {

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
	void testSignUp() {
		String usr = "testSignUp@testSignUp.testSignUp";
		String pssd = "1234" ;
		SeleniumTesting.signIn(usr,pssd);
	}
	
	@Test
	void testSignUpAndLogIn() {
		String usr = "testSignUpAndLogIn@testSignUpAndLogIn.testSignUpAndLogIn";
		String pssd = "1234" ;
		SeleniumTesting.signIn(usr,pssd);
		SeleniumTesting.logIn(usr,pssd);
	}


}
