package de.vergleich.baugeld.webservices.client.with.axis2;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.vergleich.baugeld.hello.client.with.axis2.HelloWorldWebServiceStub;
import de.vergleich.baugeld.hello.client.with.axis2.HelloWorldWebServiceStub.SayHello;
import de.vergleich.baugeld.hello.client.with.axis2.HelloWorldWebServiceStub.SayHelloResponse;

public class TestHelloWorldWithAxis2 {

	private Logger log = LoggerFactory.getLogger(TestHelloWorldWithAxis2.class);
	@Test
	public void test() throws Exception {

		log.debug("wurst");

		HelloWorldWebServiceStub stub = new HelloWorldWebServiceStub();
		Assert.assertNotNull(stub);

		SayHello sayHello0 = new SayHello();
		sayHello0.setArg0("egal");

		SayHelloResponse response = stub.sayHello(sayHello0 );
		Assert.assertEquals("Hello egal!" , response.get_return());
	}

}
