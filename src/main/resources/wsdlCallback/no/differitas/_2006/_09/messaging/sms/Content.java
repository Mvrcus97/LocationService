
package no.differitas._2006._09.messaging.sms;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Content complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Content">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element name="Text" type="{http://differitas.no/2006/09/messaging/sms}Text" minOccurs="0"/>
 *           &lt;element name="Binary" type="{http://differitas.no/2006/09/messaging/sms}Binary" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element name="DCS" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Content", propOrder = {
    "textOrBinary",
    "dcs"
})
public class Content {

    @XmlElements({
        @XmlElement(name = "Text", type = Text.class),
        @XmlElement(name = "Binary", type = Binary.class)
    })
    protected List<UserData> textOrBinary;
    @XmlElement(name = "DCS")
    protected Integer dcs;

    /**
     * Gets the value of the textOrBinary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textOrBinary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextOrBinary().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Text }
     * {@link Binary }
     * 
     * 
     */
    public List<UserData> getTextOrBinary() {
        if (textOrBinary == null) {
            textOrBinary = new ArrayList<UserData>();
        }
        return this.textOrBinary;
    }

    /**
     * Gets the value of the dcs property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDCS() {
        return dcs;
    }

    /**
     * Sets the value of the dcs property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDCS(Integer value) {
        this.dcs = value;
    }

}
