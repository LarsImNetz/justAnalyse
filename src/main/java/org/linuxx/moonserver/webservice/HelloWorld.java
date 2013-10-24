package org.linuxx.moonserver.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(portName = "HelloWebServices",
            serviceName = "HelloWorldWebService",
			targetNamespace = "http://moonserver.linuxx.org")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class HelloWorld {
	@WebMethod
	public String sayHello(String name) {
		return "Hello " + name + "!";
	}

//	@WebMethod(operationName = "body-mass-index")
//	@WebResult(name = "your-bmi")
//	public double bmi(@WebParam(name = "height") double height,
//			@WebParam(name = "weight") double weight) {
//		return weight / ((height * height) / 10000);
//	}
}