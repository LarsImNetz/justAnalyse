package de.vergleich.baugeld.hello.with.wsimport;


import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class TestHelloWebServices {

	@Ignore("ServiceConstructionException: Failed to create service")
	@Test
	public void test() {
		HelloWorldWebService service = new HelloWorldWebService();
		// TODO: liefert hier keinen Service
		Assert.assertNotNull(service);

		HelloWorld port = service.getHelloWebServices();

		System.out.println(port.sayHello("auch egal"));
	}

	private URL getWsdlLocation() {
		URL url = null;
		try {
			url = new URL("http://localhost:8080/services?wsdl");
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		}
		return url;
	}
}
