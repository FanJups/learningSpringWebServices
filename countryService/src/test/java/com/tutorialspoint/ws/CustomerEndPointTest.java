package com.tutorialspoint.ws;

import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.payload;

import javax.xml.transform.Source;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.xml.transform.StringSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-context.xml")
public class CustomerEndPointTest {
	@Autowired
	private ApplicationContext applicationContext;
	private MockWebServiceClient mockClient;

	@Before
	public void createClient() {
		mockClient = MockWebServiceClient.createClient(applicationContext);
		GenericApplicationContext ctx = (GenericApplicationContext) applicationContext;
		final XmlBeanDefinitionReader definitionReader = new XmlBeanDefinitionReader(ctx);
		definitionReader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_NONE);
		definitionReader.setNamespaceAware(true);
	}

	@Test
	public void testCountryEndpoint() throws Exception {
		Source requestPayload = new StringSource("<getCountryRequest xmlns = 'http://tutorialspoint/schemas'>"
				+ "<name>United States</name>" + "</getCountryRequest>");
		Source responsePayload = new StringSource("<getCountryResponse xmlns='http://tutorialspoint/schemas'>"
				+ "<country>" + "<name>United States</name>" + "<population>46704314</population>"
				+ "<capital>Washington</capital>" + "<currency>USD</currency>" + "</country>"
				+ "</getCountryResponse>");
		mockClient.sendRequest(withPayload(requestPayload)).andExpect(payload(responsePayload));
	}
}