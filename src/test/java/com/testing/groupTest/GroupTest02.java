package com.testing.groupTest;

import org.testng.annotations.Test;

public class GroupTest02 {
	
	@Test(groups = {"smoke"})
	public void test04() {
		System.out.println("GoupTest02.test04()");
	}
	
	@Test(groups = {"smoke", "functional", "regression", "sanity"})
	public void test05() {
		System.out.println("GoupTest02.test05()");
	}
	
	@Test(groups = {"functional", "regression"})
	public void test06() {
		System.out.println("GoupTest02.test06()");
	}

}
