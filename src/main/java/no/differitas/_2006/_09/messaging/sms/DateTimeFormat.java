
package no.differitas._2006._09.messaging.sms;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DateTimeFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DateTimeFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="relative"/>
 *     &lt;enumeration value="absolute"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DateTimeFormat")
@XmlEnum
public enum DateTimeFormat {

    @XmlEnumValue("relative")
    RELATIVE("relative"),
    @XmlEnumValue("absolute")
    ABSOLUTE("absolute");
    private final String value;

    DateTimeFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DateTimeFormat fromValue(String v) {
        for (DateTimeFormat c: DateTimeFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
