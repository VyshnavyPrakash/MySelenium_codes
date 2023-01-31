package com.obsqura.utilities;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class FakerUtility {

	public static String firstName() {
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		return firstName;
	}
	public static String lastName() {
		Faker faker = new Faker();
		String lastName = faker.name().lastName();
		return lastName;
	}
	public static String userName() {
		Faker faker = new Faker();	
		String userName = faker.name().username();
		return userName;
	}
	public static String cityName() {
		Faker faker = new Faker();	
		String cityName = faker.address().cityName();
		return cityName;
	}
	public static void state() {
		Faker faker = new Faker();	
		String userName = faker.address().state();
	}
	
	public static String address() {
		Faker faker = new Faker();	
		String address = faker.address().streetAddress();
		return address;
	}
	
	public static void country() {
		Faker faker = new Faker();	
		String country = faker.address().country();
		FakeValuesService fakeValuesService = new FakeValuesService(  new Locale("en-GB"), new RandomService());
	}
	
	public static String cellPhone() {
		Faker faker = new Faker();	
		String cellPhone = faker.phoneNumber().cellPhone();
		return cellPhone;
	}
	public static String fakeValuesServiceEmail() {
		FakeValuesService fakeValuesService = new FakeValuesService(  new Locale("en-GB"), new RandomService());
		String email = fakeValuesService.bothify("????##@gmail.com");
		return email;
	}
	public static String fakeValuesServiceMobile() {
		FakeValuesService fakeValuesService = new FakeValuesService(  new Locale("en-GB"), new RandomService());
		 String mobile = fakeValuesService.bothify("##########");
		 return mobile;
	}
	
	
}
