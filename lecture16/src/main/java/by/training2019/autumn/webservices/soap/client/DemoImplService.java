
package by.training2019.autumn.webservices.soap.client;

import by.training2019.autumn.webservices.soap.ws.Demo;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "DemoImplService", targetNamespace = "http://ws.soap.webservices.autumn.training2019.by/", wsdlLocation = "http://localhost:4789/ws/Demo?wsdl")
public class DemoImplService
    extends Service
{

    private final static URL DEMOIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException DEMOIMPLSERVICE_EXCEPTION;
    private final static QName DEMOIMPLSERVICE_QNAME = new QName("http://ws.soap.webservices.autumn.training2019.by/", "DemoImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:4789/ws/Demo?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DEMOIMPLSERVICE_WSDL_LOCATION = url;
        DEMOIMPLSERVICE_EXCEPTION = e;
    }

    public DemoImplService() {
        super(__getWsdlLocation(), DEMOIMPLSERVICE_QNAME);
    }

    public DemoImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    /**
     * 
     * @return
     *     returns Demo
     */
    @WebEndpoint(name = "DemoImplPort")
    public by.training2019.autumn.webservices.soap.ws.Demo getDemoImplPort() {
        return super.getPort(new QName("http://ws.soap.webservices.autumn.training2019.by/", "DemoImplPort"), by.training2019.autumn.webservices.soap.ws.Demo.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Demo
     */
    @WebEndpoint(name = "DemoImplPort")
    public by.training2019.autumn.webservices.soap.ws.Demo getDemoImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.soap.webservices.autumn.training2019.by/", "DemoImplPort"), Demo.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DEMOIMPLSERVICE_EXCEPTION!= null) {
            throw DEMOIMPLSERVICE_EXCEPTION;
        }
        return DEMOIMPLSERVICE_WSDL_LOCATION;
    }

}
