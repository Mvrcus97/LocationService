
package no.differitas._2006._09.messaging.sms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeliverMessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliverMessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Account" type="{http://differitas.no/2006/09/messaging/sms}Address" minOccurs="0"/>
 *         &lt;element name="OA" type="{http://differitas.no/2006/09/messaging/sms}Address" minOccurs="0"/>
 *         &lt;element name="DA" type="{http://differitas.no/2006/09/messaging/sms}Address" minOccurs="0"/>
 *         &lt;element name="Content" type="{http://differitas.no/2006/09/messaging/sms}Content" minOccurs="0"/>
 *         &lt;element name="DeliveryTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliverMessage", propOrder = {
    "account",
    "oa",
    "da",
    "content",
    "deliveryTime"
})
public class DeliverMessage {

    @XmlElement(name = "Account")
    protected Address account;
    @XmlElement(name = "OA")
    protected Address oa;
    @XmlElement(name = "DA")
    protected Address da;
    @XmlElement(name = "Content")
    protected Content content;
    @XmlElement(name = "DeliveryTime")
    protected String deliveryTime;
    @XmlAttribute(name = "id")
    protected String id;

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
     * Gets the value of the deliveryTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * Sets the value of the deliveryTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryTime(String value) {
        this.deliveryTime = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
