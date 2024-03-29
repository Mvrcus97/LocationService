
package no.differitas._2015._10.coveragearea;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.ws.*;

import static java.net.Authenticator.*;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CoverageAreaService", targetNamespace = "http://differitas.no/2015/10/coveragearea", wsdlLocation = "resources/main/wsdl/wscoveragearea2.wsdl")
public class CoverageAreaService_Service
    extends Service
{

    private final static URL COVERAGEAREASERVICE_WSDL_LOCATION;
    private final static WebServiceException COVERAGEAREASERVICE_EXCEPTION;
    private final static QName COVERAGEAREASERVICE_QNAME = new QName("http://differitas.no/2015/10/coveragearea", "CoverageAreaService");

    static {
        URL url = null;
            WebServiceException e = null;
            try {
                url =  CoverageAreaService_Service.class.getResource("/wsdl/wscoveragearea2.wsdl");
        } catch (Exception ex) {
                e = new WebServiceException(ex);
                e.printStackTrace();
        }
        COVERAGEAREASERVICE_WSDL_LOCATION = url;
        COVERAGEAREASERVICE_EXCEPTION = e;
    }

    public CoverageAreaService_Service() {
        super(__getWsdlLocation(), COVERAGEAREASERVICE_QNAME);
    }

    public CoverageAreaService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), COVERAGEAREASERVICE_QNAME, features);
    }

    public CoverageAreaService_Service(URL wsdlLocation) {
        super(wsdlLocation, COVERAGEAREASERVICE_QNAME);
    }

    public CoverageAreaService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, COVERAGEAREASERVICE_QNAME, features);
    }

    public CoverageAreaService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CoverageAreaService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CoverageAreaService
     */
    @WebEndpoint(name = "CoverageAreaServicePort")
    public CoverageAreaService getCoverageAreaServicePort() {
        return super.getPort(new QName("http://differitas.no/2015/10/coveragearea", "CoverageAreaServicePort"), CoverageAreaService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CoverageAreaService
     */
    @WebEndpoint(name = "CoverageAreaServicePort")
    public CoverageAreaService getCoverageAreaServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://differitas.no/2015/10/coveragearea", "CoverageAreaServicePort"), CoverageAreaService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (COVERAGEAREASERVICE_EXCEPTION!= null) {
            throw COVERAGEAREASERVICE_EXCEPTION;
        }
        return COVERAGEAREASERVICE_WSDL_LOCATION;
    }

}
