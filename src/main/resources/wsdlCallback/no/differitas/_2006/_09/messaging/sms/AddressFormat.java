
package no.differitas._2006._09.messaging.sms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AddressFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AddressFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="number"/>
 *     &lt;enumeration value="shortcode"/>
 *     &lt;enumeration value="alphanum"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AddressFormat")
@XmlEnum
public enum AddressFormat {

    @XmlEnumValue("number")
    NUMBER("number"),
    @XmlEnumValue("shortcode")
    SHORTCODE("shortcode"),
    @XmlEnumValue("alphanum")
    ALPHANUM("alphanum");
    private final String value;

    AddressFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AddressFormat fromValue(String v) {
        for (AddressFormat c: AddressFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
