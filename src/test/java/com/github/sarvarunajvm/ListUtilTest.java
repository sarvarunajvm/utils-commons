package com.github.sarvarunajvm;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListUtilTest {
	int count = 1;

	@BeforeAll
	static void setup() {
		System.out.println("List Util Test Initiated");
	}

	@BeforeEach
	void setupThis() {
		System.out.println("Test : "+count+ " Initiated");
	}
	
	@Test
	void isNullOrEmpty() {
		List<String> nullList = null;
		Assertions.assertEquals(true, ListUtil.isNullOrEmpty(nullList));
	}

	@Test
	void isNullOrEmptyWithEmpty() {
		List<String> emptyList = new ArrayList<String>();
		Assertions.assertEquals(true, ListUtil.isNullOrEmpty(emptyList));
	}

	@Test
	void isNullOrEmptyWithVal() {
		List<String> valueList = new ArrayList<String>();
		valueList.add("Test");
		Assertions.assertEquals(false, ListUtil.isNullOrEmpty(valueList));
	}

	@Test
	void isNotNullOrEmpty() {
		List<String> nullList = null;
		Assertions.assertEquals(false, ListUtil.isNotNullOrEmpty(nullList));
	}

	@Test
	void isNotNullOrEmptyWithEmpty() {
		List<String> emptyList = new ArrayList<String>();
		Assertions.assertEquals(false, ListUtil.isNotNullOrEmpty(emptyList));
	}

	@Test
	void isNotNullOrEmptyWithVal() {
		List<String> valueList = new ArrayList<String>();
		valueList.add("Test");
		Assertions.assertEquals(true, ListUtil.isNotNullOrEmpty(valueList));
	}

	@AfterEach
	void tearThis() {
		System.out.println("Test : "+count+ " ended");
		count++;
	}

	@AfterAll
	static void tear() {
		System.out.println("List Util All Test has been ended");
	}

}
