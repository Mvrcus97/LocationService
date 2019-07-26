
package no.differitas._2006._09.messaging.sms;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Rating complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Rating">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="AgeLimit" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rating")
public class Rating {

    @XmlAttribute(name = "AgeLimit", required = true)
    protected int ageLimit;

    /**
     * Gets the value of the ageLimit property.
     * 
     */
    public int getAgeLimit() {
        return ageLimit;
    }

    /**
     * Sets the value of the ageLimit property.
     * 
     */
    public void setAgeLimit(int value) {
        this.ageLimit = value;
    }

}
