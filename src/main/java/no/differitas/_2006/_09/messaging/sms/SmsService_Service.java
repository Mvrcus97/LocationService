
package no.differitas._2006._09.messaging.sms;

import java.io.File;
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
@WebServiceClient(name = "SmsService", targetNamespace = "http://differitas.no/2006/09/messaging/sms", wsdlLocation = "resources/main/wsdl/telia-smsbulk.wsdl")
public class SmsService_Service
    extends Service
{

    private final static URL SMSSERVICE_WSDL_LOCATION;
    private final static WebServiceException SMSSERVICE_EXCEPTION;
    private final static QName SMSSERVICE_QNAME = new QName("http://differitas.no/2006/09/messaging/sms", "SmsService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            System.out.println("Before url smsservice");
            url =  SmsService_Service.class.getResource("/wsdl/telia-smsbulk.wsdl");
            System.out.println("after url smsservice");
        } catch (Exception ex) {
            e = new WebServiceException(ex);
        }
        SMSSERVICE_WSDL_LOCATION = url;
        SMSSERVICE_EXCEPTION = e;

    }

    public SmsService_Service() {
        super(__getWsdlLocation(), SMSSERVICE_QNAME);
    }

    public SmsService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SMSSERVICE_QNAME, features);
    }

    public SmsService_Service(URL wsdlLocation) {
        super(wsdlLocation, SMSSERVICE_QNAME);
    }

    public SmsService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SMSSERVICE_QNAME, features);
    }

    public SmsService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SmsService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SmsService
     */
    @WebEndpoint(name = "SmsPort")
    public SmsService getSmsPort() {
        return super.getPort(new QName("http://differitas.no/2006/09/messaging/sms", "SmsPort"), SmsService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SmsService
     */
    @WebEndpoint(name = "SmsPort")
    public SmsService getSmsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://differitas.no/2006/09/messaging/sms", "SmsPort"), SmsService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SMSSERVICE_EXCEPTION!= null) {
            throw SMSSERVICE_EXCEPTION;
        }
        return SMSSERVICE_WSDL_LOCATION;
    }

}
