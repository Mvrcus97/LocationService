
package no.differitas._2015._10.coveragearea;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the no.differitas._2015._10.coveragearea package. 
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

    private final static QName _ValidationFault_QNAME = new QName("http://differitas.no/2015/10/coveragearea", "ValidationFault");
    private final static QName _ServerFault_QNAME = new QName("http://differitas.no/2015/10/coveragearea", "ServerFault");
    private final static QName _ServerFaultMessage_QNAME = new QName("http://differitas.no/2015/10/coveragearea", "Message");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: no.differitas._2015._10.coveragearea
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
     * Create an instance of {@link ServerFault }
     * 
     */
    public ServerFault createServerFault() {
        return new ServerFault();
    }

    /**
     * Create an instance of {@link CoverageAreaRsp }
     * 
     */
    public CoverageAreaRsp createCoverageAreaRsp() {
        return new CoverageAreaRsp();
    }

    /**
     * Create an instance of {@link CouncilType }
     * 
     */
    public CouncilType createCouncilType() {
        return new CouncilType();
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link CoverageAreaReq }
     * 
     */
    public CoverageAreaReq createCoverageAreaReq() {
        return new CoverageAreaReq();
    }

    /**
     * Create an instance of {@link PlacenameRsp }
     * 
     */
    public PlacenameRsp createPlacenameRsp() {
        return new PlacenameRsp();
    }

    /**
     * Create an instance of {@link PlacenameReq }
     * 
     */
    public PlacenameReq createPlacenameReq() {
        return new PlacenameReq();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidationFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://differitas.no/2015/10/coveragearea", name = "ValidationFault")
    public JAXBElement<ValidationFault> createValidationFault(ValidationFault value) {
        return new JAXBElement<ValidationFault>(_ValidationFault_QNAME, ValidationFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServerFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://differitas.no/2015/10/coveragearea", name = "ServerFault")
    public JAXBElement<ServerFault> createServerFault(ServerFault value) {
        return new JAXBElement<ServerFault>(_ServerFault_QNAME, ServerFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://differitas.no/2015/10/coveragearea", name = "Message", scope = ServerFault.class)
    public JAXBElement<String> createServerFaultMessage(String value) {
        return new JAXBElement<String>(_ServerFaultMessage_QNAME, String.class, ServerFault.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://differitas.no/2015/10/coveragearea", name = "Message", scope = ValidationFault.class)
    public JAXBElement<String> createValidationFaultMessage(String value) {
        return new JAXBElement<String>(_ServerFaultMessage_QNAME, String.class, ValidationFault.class, value);
    }

}
