package de.vergleich.baugeld.webservices.client.with.cxf;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import de.vergleich.baugeld.hello.client.with.cxf.HelloWorld;
import de.vergleich.baugeld.hello.client.with.cxf.HelloWorldWebService;


public class TestHelloWebServiceWithCXF {

	@Ignore("WebServiceException: Could not send Message")
	@Test
	public void test() {
		HelloWorldWebService service = new HelloWorldWebService();
		Assert.assertNotNull(service);
		HelloWorld port = service.getHelloWebServices();

		Assert.assertNotNull(port);

		String sayHello = port.sayHello("Mir wurst");
		Assert.assertEquals("Hello Mir wurst!", sayHello);
	}
}
