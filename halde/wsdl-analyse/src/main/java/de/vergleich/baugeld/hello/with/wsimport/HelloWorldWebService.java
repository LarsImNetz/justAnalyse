
package de.vergleich.baugeld.hello.with.wsimport;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "HelloWorldWebService", targetNamespace = "http://moonserver.linuxx.org", wsdlLocation = "file:/C:/develop/vgl_bv_second/de.vergleich.baushup--parentPom/interhyp-interface/src/main/resources/de/vergleich/baugeld/webservices/HelloWorld.wsdl")
public class HelloWorldWebService
    extends Service
{

    private final static URL HELLOWORLDWEBSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(de.vergleich.baugeld.hello.with.wsimport.HelloWorldWebService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = de.vergleich.baugeld.hello.with.wsimport.HelloWorldWebService.class.getResource(".");
            url = new URL(baseUrl, "file:/C:/develop/vgl_bv_second/de.vergleich.baushup--parentPom/interhyp-interface/src/main/resources/de/vergleich/baugeld/webservices/HelloWorld.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/C:/develop/vgl_bv_second/de.vergleich.baushup--parentPom/interhyp-interface/src/main/resources/de/vergleich/baugeld/webservices/HelloWorld.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        HELLOWORLDWEBSERVICE_WSDL_LOCATION = url;
    }

    public HelloWorldWebService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWorldWebService() {
        super(HELLOWORLDWEBSERVICE_WSDL_LOCATION, new QName("http://moonserver.linuxx.org", "HelloWorldWebService"));
    }

    /**
     * 
     * @return
     *     returns HelloWorld
     */
    @WebEndpoint(name = "HelloWebServices")
    public HelloWorld getHelloWebServices() {
        return super.getPort(new QName("http://moonserver.linuxx.org", "HelloWebServices"), HelloWorld.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWorld
     */
    @WebEndpoint(name = "HelloWebServices")
    public HelloWorld getHelloWebServices(WebServiceFeature... features) {
        return super.getPort(new QName("http://moonserver.linuxx.org", "HelloWebServices"), HelloWorld.class, features);
    }

}