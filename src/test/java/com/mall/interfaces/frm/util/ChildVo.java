package com.mall.interfaces.frm.util;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductItmOptLstVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductItmOptLstVO">
 *   &lt;complexContent>
 *     &lt;extension base="{com.lton.interfaces.vo}LtonCommonVO">
 *       &lt;sequence>
 *         &lt;element name="optCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="optNm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="optValCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="optVal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dtlsVal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProductItmOptLstVO", propOrder = {
    "optCd",
    "optNm",
    "optValCd",
    "optVal",
    "dtlsVal"
})
public class ChildVo
    extends LtonCommonVO
{

    @XmlElement(required = true)
    protected String optCd;

    /**
     * Gets the value of the optCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOptCd() {
        return optCd;
    }

    /**
     * Sets the value of the optCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOptCd(String value) {
        this.optCd = value;
    }
}
 