package com.tutorialspoint.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.tutorialspoint.GetCountryRequest;
import com.tutorialspoint.GetCountryResponse;

public class CountryServiceClient extends WebServiceGatewaySupport {
	public GetCountryResponse getCountryDetails(String country) {
		String uri = "http://localhost:8080/countryService/";
		GetCountryRequest request = new GetCountryRequest();
		request.setName(country);

		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(uri, request);
		return response;
	}
}
