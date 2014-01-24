package de.vergleich.baugeld;

// import org.apache.cxf.aegis.databinding.AegisDatabinding;
import javax.xml.namespace.QName;

import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


public class TestMain {

	@Ignore
	@Test
	public void test() {

		ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
		// factory.setServiceClass(serviceInterfaceClassObject);
		factory.setServiceName(new QName("SimpleInterestCheckService"));
		factory.setBindingId("tns:SimpleInterestCheckBySoap");

		factory.setAddress("http://www.interhyp.de/schema/SimpleInterestCheck");
		factory.setWsdlLocation("http://preview.interhyp.de/ehyp/servlet/ehyp?view=getSchema&dataset=SimpleInterestCheck"); //TODO: preview
		// factory.getServiceFactory().setDataBinding(new AegisDatabinding());
		Object client = factory.create();

		Assert.assertNotNull(client);
	}

}
