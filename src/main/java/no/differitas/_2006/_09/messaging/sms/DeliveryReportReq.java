
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
 *         &lt;element name="DeliveryReportMessage" type="{http://differitas.no/2006/09/messaging/sms}DeliveryReportMessage" minOccurs="0"/>
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
    "deliveryReportMessage"
})
@XmlRootElement(name = "DeliveryReportReq")
public class DeliveryReportReq {

    @XmlElement(name = "DeliveryReportMessage")
    protected DeliveryReportMessage deliveryReportMessage;

    /**
     * Gets the value of the deliveryReportMessage property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveryReportMessage }
     *     
     */
    public DeliveryReportMessage getDeliveryReportMessage() {
        return deliveryReportMessage;
    }

    /**
     * Sets the value of the deliveryReportMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveryReportMessage }
     *     
     */
    public void setDeliveryReportMessage(DeliveryReportMessage value) {
        this.deliveryReportMessage = value;
    }

}
