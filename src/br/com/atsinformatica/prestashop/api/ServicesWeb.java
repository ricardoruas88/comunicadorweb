//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b01 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2013.11.11 a las 08:07:22 PM CET 
//


package com.prestashopService.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.prestashopService.factory.ProductSuppliers;
import com.prestashopService.factory.Products;
import com.prestashopService.model.ProductSupplier;


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
 *         &lt;element ref="{}products"/>
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
    "products",
    "productSuppliers",
})
@XmlRootElement(name = "prestashop")
public class ServicesWeb{

    @XmlElement
    protected Products products;
    
    @XmlElement(name="product_suppliers")
    protected ProductSuppliers productSuppliers;

	//==========PRODUCTS=========================//
    /**
     * Obtiene el valor de la propiedad products.
     * 
     * @return
     *     possible object is
     *     {@link Products }
     *     
     */
    public Products getProducts() {
        return products;
    }

    /**
     * Define el valor de la propiedad products.
     * 
     * @param value
     *     allowed object is
     *     {@link Products }
     *     
     */
    public void setProducts(Products value) {
        this.products = value;
    }

  //==========PRODUCT_SUPPLIERS=========================//
    /**
     * Obtiene el valor de la propiedad Product_suppliers.
     * 
     * @return
     *     possible object is
     *     {@link Product_suppliers }
     *     
     */
    public ProductSuppliers getProductSuppliers() {
		return productSuppliers;
	}

    /**
     * Define el valor de la propiedad Product_suppliers.
     * 
     * @param value
     *     allowed object is
     *     {@link Product_suppliers }
     *     
     */
    public void setProductSuppliers(ProductSuppliers productSuppliers) {
		this.productSuppliers = productSuppliers;
	}
    
    
}
