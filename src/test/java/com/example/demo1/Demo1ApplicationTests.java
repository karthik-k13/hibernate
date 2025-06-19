package com.example.demo1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo1ApplicationTests {

	@Test
	void test1() {
		System.out.println("test1");
	}
	
	@Test
	void test2() {
		System.out.println("test2");
	}
	
	@BeforeEach
	void test3() {
		System.out.println("before each test");
	}
	
	@AfterEach
	void test4() {
		System.out.println("after each test");
	}
	
	@BeforeAll
	static void test5() {
		System.out.println("before all tests");
	}
	
	@AfterAll
	static void test6() {
		System.out.println("after all tests");
	}
}
