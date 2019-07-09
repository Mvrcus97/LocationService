
package no.differitas._2015._10.coveragearea;

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
 *         &lt;element name="Longitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Latitude" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="PartArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SubPartArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Council" type="{http://differitas.no/2015/10/coveragearea}CouncilType" minOccurs="0"/>
 *         &lt;element name="County" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CogQos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Status" type="{http://differitas.no/2015/10/coveragearea}Status"/>
 *         &lt;element name="LocationTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "longitude",
    "latitude",
    "partArea",
    "subPartArea",
    "council",
    "county",
    "country",
    "cogQos",
    "status",
    "locationTime"
})
@XmlRootElement(name = "PlacenameRsp")
public class PlacenameRsp {

    @XmlElement(name = "Longitude")
    protected String longitude;
    @XmlElement(name = "Latitude")
    protected String latitude;
    @XmlElement(name = "PartArea")
    protected String partArea;
    @XmlElement(name = "SubPartArea")
    protected String subPartArea;
    @XmlElement(name = "Council")
    protected CouncilType council;
    @XmlElement(name = "County")
    protected String county;
    @XmlElement(name = "Country")
    protected String country;
    @XmlElement(name = "CogQos")
    protected String cogQos;
    @XmlElement(name = "Status", required = true)
    protected Status status;
    @XmlElement(name = "LocationTime")
    protected String locationTime;

    /**
     * Gets the value of the longitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongitude(String value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the latitude property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatitude(String value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the partArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartArea() {
        return partArea;
    }

    /**
     * Sets the value of the partArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartArea(String value) {
        this.partArea = value;
    }

    /**
     * Gets the value of the subPartArea property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubPartArea() {
        return subPartArea;
    }

    /**
     * Sets the value of the subPartArea property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubPartArea(String value) {
        this.subPartArea = value;
    }

    /**
     * Gets the value of the council property.
     * 
     * @return
     *     possible object is
     *     {@link CouncilType }
     *     
     */
    public CouncilType getCouncil() {
        return council;
    }

    /**
     * Sets the value of the council property.
     * 
     * @param value
     *     allowed object is
     *     {@link CouncilType }
     *     
     */
    public void setCouncil(CouncilType value) {
        this.council = value;
    }

    /**
     * Gets the value of the county property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounty() {
        return county;
    }

    /**
     * Sets the value of the county property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounty(String value) {
        this.county = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the cogQos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCogQos() {
        return cogQos;
    }

    /**
     * Sets the value of the cogQos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCogQos(String value) {
        this.cogQos = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    /**
     * Gets the value of the locationTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationTime() {
        return locationTime;
    }

    /**
     * Sets the value of the locationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationTime(String value) {
        this.locationTime = value;
    }

}
