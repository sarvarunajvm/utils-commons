package com.github.sarvarunajvm;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringUtilTest {
	int count = 1;

	@BeforeAll
	static void setup() {
		System.out.println("String Util Test Initiated");
	}

	@BeforeEach
	void setupThis() {
		System.out.println("Test : "+count+ " Initiated");
	}
	
	@Test
	void isNullOrEmpty() {
		String nullStr = null;
		Assertions.assertEquals(true, StringUtil.isNullOrEmpty(nullStr));
	}

	@Test
	void isNullOrEmptyWithEmpty() {
		String emptyStr = "";
		Assertions.assertEquals(true, StringUtil.isNullOrEmpty(emptyStr));
	}

	@Test
	void isNullOrEmptyWithVal() {
		String valStr = "This is test";
		Assertions.assertEquals(false, StringUtil.isNullOrEmpty(valStr));
	}

	@Test
	void isNotNullOrEmpty() {
		String nullStr = null;
		Assertions.assertEquals(false, StringUtil.isNotNullOrEmpty(nullStr));
	}

	@Test
	void isNotNullOrEmptyWithEmpty() {
		String emptyStr = "";
		Assertions.assertEquals(false, StringUtil.isNotNullOrEmpty(emptyStr));
	}

	@Test
	void isNotNullOrEmptyWithVal() {
		String valStr = "This is test";
		Assertions.assertEquals(true, StringUtil.isNotNullOrEmpty(valStr));
	}

	@AfterEach
	void tearThis() {
		System.out.println("Test : "+count+ " ended");
		count++;
	}

	@AfterAll
	static void tear() {
		System.out.println("String Util All Test has been ended");
	}

}
