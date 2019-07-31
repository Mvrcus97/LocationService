
package no.differitas._2006._09.messaging.sms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DeliverMessage" type="{http://differitas.no/2006/09/messaging/sms}DeliverMessage" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "deliverMessage"
})
@XmlRootElement(name = "DeliverReq")
public class DeliverReq {

    @XmlElement(name = "DeliverMessage")
    protected DeliverMessage deliverMessage;

    /**
     * Gets the value of the deliverMessage property.
     * 
     * @return
     *     possible object is
     *     {@link DeliverMessage }
     *     
     */
    public DeliverMessage getDeliverMessage() {
        return deliverMessage;
    }

    /**
     * Sets the value of the deliverMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliverMessage }
     *     
     */
    public void setDeliverMessage(DeliverMessage value) {
        this.deliverMessage = value;
    }

}
