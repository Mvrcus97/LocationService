
package no.differitas._2006._09.messaging.sms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DeliveryReportType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DeliveryReportType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="retrieved"/>
 *     &lt;enumeration value="rejected"/>
 *     &lt;enumeration value="expired"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DeliveryReportType")
@XmlEnum
public enum DeliveryReportType {

    @XmlEnumValue("retrieved")
    RETRIEVED("retrieved"),
    @XmlEnumValue("rejected")
    REJECTED("rejected"),
    @XmlEnumValue("expired")
    EXPIRED("expired");
    private final String value;

    DeliveryReportType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DeliveryReportType fromValue(String v) {
        for (DeliveryReportType c: DeliveryReportType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
