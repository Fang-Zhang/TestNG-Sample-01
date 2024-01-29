package com.testing.groupTest;

import org.testng.annotations.Test;

public class GroupTest01 {
	
	@Test(groups = {"smoke"})
	public void test01() {
		System.out.println("GoupTest01.test01()");
	}
	
	@Test(groups = {"smoke", "functional", "regression", "sanity"})
	public void test02() {
		System.out.println("GoupTest01.test02()");
	}
	
	@Test(groups = {"functional", "regression"})
	public void test03() {
		System.out.println("GoupTest01.test03()");
	}

}
