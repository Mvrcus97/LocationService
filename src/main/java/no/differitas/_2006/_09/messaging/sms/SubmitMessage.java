
package no.differitas._2006._09.messaging.sms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubmitMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubmitMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Account" type="{http://differitas.no/2006/09/messaging/sms}Address" minOccurs="0"/>
 *         &lt;element name="DA" type="{http://differitas.no/2006/09/messaging/sms}Address" minOccurs="0"/>
 *         &lt;element name="Destinations" type="{http://differitas.no/2006/09/messaging/sms}Destinations" minOccurs="0"/>
 *         &lt;element name="OA" type="{http://differitas.no/2006/09/messaging/sms}Address" minOccurs="0"/>
 *         &lt;element name="Content" type="{http://differitas.no/2006/09/messaging/sms}Content" minOccurs="0"/>
 *         &lt;element name="Cost" type="{http://differitas.no/2006/09/messaging/sms}Cost" minOccurs="0"/>
 *         &lt;element name="InvoiceText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExpiryDate" type="{http://differitas.no/2006/09/messaging/sms}RelativeOrAbsoluteDateTime" minOccurs="0"/>
 *         &lt;element name="DeliveryDate" type="{http://differitas.no/2006/09/messaging/sms}RelativeOrAbsoluteDateTime" minOccurs="0"/>
 *         &lt;element name="Rating" type="{http://differitas.no/2006/09/messaging/sms}Rating" minOccurs="0"/>
 *         &lt;element name="Service" type="{http://differitas.no/2006/09/messaging/sms}Service" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="cref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitMessage", propOrder = {
    "account",
    "da",
    "destinations",
    "oa",
    "content",
    "cost",
    "invoiceText",
    "expiryDate",
    "deliveryDate",
    "rating",
    "service"
})
public class SubmitMessage {

    @XmlElement(name = "Account")
    protected Address account;
    @XmlElement(name = "DA")
    protected Address da;
    @XmlElement(name = "Destinations")
    protected Destinations destinations;
    @XmlElement(name = "OA")
    protected Address oa;
    @XmlElement(name = "Content")
    protected Content content;
    @XmlElement(name = "Cost")
    protected Cost cost;
    @XmlElement(name = "InvoiceText")
    protected String invoiceText;
    @XmlElement(name = "ExpiryDate")
    protected RelativeOrAbsoluteDateTime expiryDate;
    @XmlElement(name = "DeliveryDate")
    protected RelativeOrAbsoluteDateTime deliveryDate;
    @XmlElement(name = "Rating")
    protected Rating rating;
    @XmlElement(name = "Service")
    protected Service service;
    @XmlAttribute(name = "cref")
    protected String cref;

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAccount(Address value) {
        this.account = value;
    }

    /**
     * Gets the value of the da property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getDA() {
        return da;
    }

    /**
     * Sets the value of the da property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setDA(Address value) {
        this.da = value;
    }

    /**
     * Gets the value of the destinations property.
     * 
     * @return
     *     possible object is
     *     {@link Destinations }
     *     
     */
    public Destinations getDestinations() {
        return destinations;
    }

    /**
     * Sets the value of the destinations property.
     * 
     * @param value
     *     allowed object is
     *     {@link Destinations }
     *     
     */
    public void setDestinations(Destinations value) {
        this.destinations = value;
    }

    /**
     * Gets the value of the oa property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getOA() {
        return oa;
    }

    /**
     * Sets the value of the oa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setOA(Address value) {
        this.oa = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link Content }
     *     
     */
    public Content getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link Content }
     *     
     */
    public void setContent(Content value) {
        this.content = value;
    }

    /**
     * Gets the value of the cost property.
     * 
     * @return
     *     possible object is
     *     {@link Cost }
     *     
     */
    public Cost getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cost }
     *     
     */
    public void setCost(Cost value) {
        this.cost = value;
    }

    /**
     * Gets the value of the invoiceText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInvoiceText() {
        return invoiceText;
    }

    /**
     * Sets the value of the invoiceText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInvoiceText(String value) {
        this.invoiceText = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link RelativeOrAbsoluteDateTime }
     *     
     */
    public RelativeOrAbsoluteDateTime getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelativeOrAbsoluteDateTime }
     *     
     */
    public void setExpiryDate(RelativeOrAbsoluteDateTime value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the deliveryDate property.
     * 
     * @return
     *     possible object is
     *     {@link RelativeOrAbsoluteDateTime }
     *     
     */
    public RelativeOrAbsoluteDateTime getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the value of the deliveryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelativeOrAbsoluteDateTime }
     *     
     */
    public void setDeliveryDate(RelativeOrAbsoluteDateTime value) {
        this.deliveryDate = value;
    }

    /**
     * Gets the value of the rating property.
     * 
     * @return
     *     possible object is
     *     {@link Rating }
     *     
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * Sets the value of the rating property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rating }
     *     
     */
    public void setRating(Rating value) {
        this.rating = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * @return
     *     possible object is
     *     {@link Service }
     *     
     */
    public Service getService() {
        return service;
    }

    /**
     * Sets the value of the service property.
     * 
     * @param value
     *     allowed object is
     *     {@link Service }
     *     
     */
    public void setService(Service value) {
        this.service = value;
    }

    /**
     * Gets the value of the cref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCref() {
        return cref;
    }

    /**
     * Sets the value of the cref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCref(String value) {
        this.cref = value;
    }

}
