
package no.differitas._2006._09.messaging.sms;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="ReportMessage" type="{http://differitas.no/2006/09/messaging/sms}ReportMessage" maxOccurs="unbounded" minOccurs="0"/>
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
    "reportMessage"
})
@XmlRootElement(name = "SubmitRsp")
public class SubmitRsp {

    @XmlElement(name = "ReportMessage")
    protected List<ReportMessage> reportMessage;

    /**
     * Gets the value of the reportMessage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reportMessage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReportMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportMessage }
     * 
     * 
     */
    public List<ReportMessage> getReportMessage() {
        if (reportMessage == null) {
            reportMessage = new ArrayList<ReportMessage>();
        }
        return this.reportMessage;
    }

}
