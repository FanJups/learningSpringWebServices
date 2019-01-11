package com.tutorialspoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
	private static final List<Country> countries = new ArrayList<Country>();

	public CountryRepository() {
		initData();
	}

	public void initData() {
		Country us = new Country();
		us.setName("United States");
		us.setCapital("Washington");
		us.setCurrency(Currency.USD);
		us.setPopulation(46704314);

		countries.add(us);

		Country india = new Country();
		india.setName("India");
		india.setCapital("New Delhi");
		india.setCurrency(Currency.INR);
		india.setPopulation(138186860);

		countries.add(india);

		Country uk = new Country();
		uk.setName("United Kingdom");
		uk.setCapital("London");
		uk.setCurrency(Currency.GBP);
		uk.setPopulation(63705000);

		countries.add(uk);
	}

	public Country findCountry(String name) {
		Assert.notNull(name);
		Country result = null;

		for (Country country : countries) {
			if (name.trim().equals(country.getName())) {
				result = country;
			}
		}
		return result;
	}
}
