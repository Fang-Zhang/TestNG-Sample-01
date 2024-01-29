package com.testng.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//@Ignore
public class IgnoreDemo {
	@Ignore
	@Test
	public void test1() {
		System.out.println("test1");
	}

	@Test(enabled = true)
	public void test2() {
		System.out.println("test2");
	}

	@Ignore
	@Test(enabled = false)
	public void test3() {
		System.out.println("test3");
	}
}
