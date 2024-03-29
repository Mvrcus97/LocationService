
package no.differitas._2006._09.messaging.sms;

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
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SmsCallbackService", targetNamespace = "http://differitas.no/2006/09/messaging/sms", wsdlLocation = "file:wsdlCallback/telia-smscallback.wsdl")
public class SmsCallbackService_Service
    extends Service
{

    private final static URL SMSCALLBACKSERVICE_WSDL_LOCATION;
    private final static WebServiceException SMSCALLBACKSERVICE_EXCEPTION;
    private final static QName SMSCALLBACKSERVICE_QNAME = new QName("http://differitas.no/2006/09/messaging/sms", "SmsCallbackService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL(SmsCallbackService_Service.class.getClassLoader().getResource("wsdlCallback/telia-smscallback.wsdl").getFile());
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SMSCALLBACKSERVICE_WSDL_LOCATION = url;
        SMSCALLBACKSERVICE_EXCEPTION = e;
    }

    public SmsCallbackService_Service() {
        super(__getWsdlLocation(), SMSCALLBACKSERVICE_QNAME);
    }

    public SmsCallbackService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SMSCALLBACKSERVICE_QNAME, features);
    }

    public SmsCallbackService_Service(URL wsdlLocation) {
        super(wsdlLocation, SMSCALLBACKSERVICE_QNAME);
    }

    public SmsCallbackService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SMSCALLBACKSERVICE_QNAME, features);
    }

    public SmsCallbackService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SmsCallbackService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SmsCallbackService
     */
    @WebEndpoint(name = "SmsCallbackPort")
    public SmsCallbackService getSmsCallbackPort() {
        return super.getPort(new QName("http://differitas.no/2006/09/messaging/sms", "SmsCallbackPort"), SmsCallbackService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SmsCallbackService
     */
    @WebEndpoint(name = "SmsCallbackPort")
    public SmsCallbackService getSmsCallbackPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://differitas.no/2006/09/messaging/sms", "SmsCallbackPort"), SmsCallbackService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SMSCALLBACKSERVICE_EXCEPTION!= null) {
            throw SMSCALLBACKSERVICE_EXCEPTION;
        }
        return SMSCALLBACKSERVICE_WSDL_LOCATION;
    }

}
