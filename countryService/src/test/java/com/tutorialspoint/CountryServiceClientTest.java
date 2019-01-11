package com.tutorialspoint;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.tutorialspoint.client.CountryServiceClient;

public class CountryServiceClientTest {
	CountryServiceClient client;

	@Before
	public void setUp() throws Exception {
		client = new CountryServiceClient();
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.tutorialspoint");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
	}

	@Test
	public void test() {
		GetCountryResponse response = client.getCountryDetails("United States");
		Country expectedCountry = new Country();
		expectedCountry.setCapital("Washington");
		Country actualCountry = response.getCountry();
		Assert.assertEquals(expectedCountry.getCapital(), actualCountry.getCapital());
	}
}