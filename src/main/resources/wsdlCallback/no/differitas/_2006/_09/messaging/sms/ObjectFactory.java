
package no.differitas._2006._09.messaging.sms;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the no.differitas._2006._09.messaging.sms package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ServerFault_QNAME = new QName("http://differitas.no/2006/09/messaging/sms", "ServerFault");
    private final static QName _ValidationFault_QNAME = new QName("http://differitas.no/2006/09/messaging/sms", "ValidationFault");
    private final static QName _ValidationFaultMessage_QNAME = new QName("http://differitas.no/2006/09/messaging/sms", "Message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: no.differitas._2006._09.messaging.sms
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidationFault }
     * 
     */
    public ValidationFault createValidationFault() {
        return new ValidationFault();
    }

    /**
     * Create an instance of {@link DeliverRsp }
     * 
     */
    public DeliverRsp createDeliverRsp() {
        return new DeliverRsp();
    }

    /**
     * Create an instance of {@link ReportMessage }
     * 
     */
    public ReportMessage createReportMessage() {
        return new ReportMessage();
    }

    /**
     * Create an instance of {@link DeliverReq }
     * 
     */
    public DeliverReq createDeliverReq() {
        return new DeliverReq();
    }

    /**
     * Create an instance of {@link DeliverMessage }
     * 
     */
    public DeliverMessage createDeliverMessage() {
        return new DeliverMessage();
    }

    /**
     * Create an instance of {@link ServerFault }
     * 
     */
    public ServerFault createServerFault() {
        return new ServerFault();
    }

    /**
     * Create an instance of {@link DeliveryReportRsp }
     * 
     */
    public DeliveryReportRsp createDeliveryReportRsp() {
        return new DeliveryReportRsp();
    }

    /**
     * Create an instance of {@link DeliveryReportReq }
     * 
     */
    public DeliveryReportReq createDeliveryReportReq() {
        return new DeliveryReportReq();
    }

    /**
     * Create an instance of {@link DeliveryReportMessage }
     * 
     */
    public DeliveryReportMessage createDeliveryReportMessage() {
        return new DeliveryReportMessage();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link UserData }
     * 
     */
    public UserData createUserData() {
        return new UserData();
    }

    /**
     * Create an instance of {@link Text }
     * 
     */
    public Text createText() {
        return new Text();
    }

    /**
     * Create an instance of {@link Content }
     * 
     */
    public Content createContent() {
        return new Content();
    }

    /**
     * Create an instance of {@link Binary }
     * 
     */
    public Binary createBinary() {
        return new Binary();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServerFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://differitas.no/2006/09/messaging/sms", name = "ServerFault")
    public JAXBElement<ServerFault> createServerFault(ServerFault value) {
        return new JAXBElement<ServerFault>(_ServerFault_QNAME, ServerFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidationFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://differitas.no/2006/09/messaging/sms", name = "ValidationFault")
    public JAXBElement<ValidationFault> createValidationFault(ValidationFault value) {
        return new JAXBElement<ValidationFault>(_ValidationFault_QNAME, ValidationFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://differitas.no/2006/09/messaging/sms", name = "Message", scope = ValidationFault.class)
    public JAXBElement<String> createValidationFaultMessage(String value) {
        return new JAXBElement<String>(_ValidationFaultMessage_QNAME, String.class, ValidationFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://differitas.no/2006/09/messaging/sms", name = "Message", scope = ServerFault.class)
    public JAXBElement<String> createServerFaultMessage(String value) {
        return new JAXBElement<String>(_ValidationFaultMessage_QNAME, String.class, ServerFault.class, value);
    }

}
