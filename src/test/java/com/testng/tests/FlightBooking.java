package com.testng.tests;

import org.testng.annotations.Test;

public class FlightBooking {
	
	@Test(priority=1)
	public void Signup() {
		System.out.println("Signup");
	}
	
	@Test(priority=2)
	public void Login() {
		System.out.println("Login");
	}
	
	@Test(priority=3)
	public void SearchFlight() {
		System.out.println("SearchFlight");
	}
	
	@Test(priority=4)
	public void BookFlight() {
		System.out.println("BookFlight");
	}
	
	@Test(priority=5)
	public void Logout() {
		System.out.println("Logout");
	}

}
