/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.atsinformatica.prestashop.prestashop;

/**
 *
 * @author ricardosilva
 */
import br.com.atsinformatica.prestashop.model.ProductFeature;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}productFeature"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {
    "productFeature"
})
@XmlRootElement(name = "prestashop")
public class SetPrestashopItem{
    
//    @XmlAttribute(name = "xmlns:xlink", required = true)
//    protected String xmlns = "http://www.w3.org/1999/xlink";
    
    @XmlElement(required = true)
    protected ProductFeature productFeature;

    /**
     * Obtiene el valor de la propiedad productFeature.
     * 
     * @return
     *     possible object is
     *     {@link Product }
     *     
     */
    public ProductFeature getProductFeature() {
        return productFeature;
    }

    /**
     * Define el valor de la propiedad productFeature.
     * 
     * @param value
     *     allowed object is
     *     {@link Product }
     *     
     */
    public void setProductFeature(ProductFeature value) {
        this.productFeature = value;
    }

//    public String getXmlns() {
//        return xmlns;
//    }
//
//    public void setXmlns(String xmlns) {
//        this.xmlns = xmlns;
//    }

    @Override
    public String toString() {
        //return "Prestashop{" + "xmlns=" + xmlns + ", productFeature=" + productFeature + '}';
         return "Prestashop{productFeature=" + productFeature + '}';
    }

    
}

