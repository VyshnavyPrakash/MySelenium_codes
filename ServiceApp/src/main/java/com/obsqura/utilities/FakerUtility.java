package com.obsqura.utilities;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

public class FakerUtility {

	public static void firstName() {
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
	}
	public static void lastName() {
		Faker faker = new Faker();
		String lastName = faker.name().lastName();
	}
	public static void userName() {
		Faker faker = new Faker();	
		String userName = faker.name().username();
	}
	public static void cityName() {
		Faker faker = new Faker();	
		String cityName = faker.address().cityName();
	}
	public static void state() {
		Faker faker = new Faker();	
		String userName = faker.address().state();
	}
	public static void country() {
		Faker faker = new Faker();	
		String country = faker.address().country();
		FakeValuesService fakeValuesService = new FakeValuesService(  new Locale("en-GB"), new RandomService());
		String email = fakeValuesService.bothify("????##@gmail.com");
	    String mobile = fakeValuesService.bothify("##########");
	}
	public static String cellPhone() {
		Faker faker = new Faker();	
		String cellPhone = faker.phoneNumber().cellPhone();
		return cellPhone;
	}
	
	
}
