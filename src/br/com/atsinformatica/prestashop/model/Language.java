//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b01 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2013.11.11 a las 08:18:12 PM CET 
//


package br.com.atsinformatica.prestashop.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="href" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="1"/>
 *             &lt;enumeration value="2"/>
 *             &lt;enumeration value="3"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "language_code",
    "iso_code",
    "active",
    "is_rtl",
    "date_format_lite",
    "date_format_full",
})
@XmlRootElement(name = "language")
public class Language {

//    @XmlValue
//    protected String content;
    @XmlAttribute(name = "href", required = true)
    protected String href;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String id;
    
    @XmlElement(name="name")
    private String name;
    @XmlElement(name="iso_code")
    private String iso_code;
    @XmlElement(name="language_code")
    private String language_code;
    @XmlElement(name="active")
    private boolean active;
    @XmlElement(name="is_rtl")
    private boolean is_rtl;
    @XmlElement(name="date_format_lite")
    private String date_format_lite;
    @XmlElement(name="date_format_full")
    private String date_format_full;

    public Language() {
    }

    public Language(String name, String iso_code, String date_format_lite, 
        String date_format_full) {

        this.name = name;
        this.iso_code = iso_code;
        this.date_format_lite = date_format_lite;
        this.date_format_full = date_format_full;
    }

    public Language(Id id, String name, String iso_code, String language_code, 
        boolean active, boolean is_rtl, String date_format_lite, 
        String date_format_full) {

        this.name = name;
        this.iso_code = iso_code;
        this.language_code = language_code;
        this.active = active;
        this.is_rtl = is_rtl;
        this.date_format_lite = date_format_lite;
        this.date_format_full = date_format_full;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso_code() {
        return iso_code;
    }

    public void setIso_code(String iso_code) {
        this.iso_code = iso_code;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isIs_rtl() {
        return is_rtl;
    }

    public void setIs_rtl(boolean is_rtl) {
        this.is_rtl = is_rtl;
    }

    public String getDate_format_lite() {
        return date_format_lite;
    }

    public void setDate_format_lite(String date_format_lite) {
        this.date_format_lite = date_format_lite;
    }

    public String getDate_format_full() {
        return this.date_format_full;
    }

    public void setDate_format_full(String date_format_full) {
        this.date_format_full = date_format_full;
    }

    @Override
    public String toString(){
         return "Language ["
                + "id=" + id + ", "
                + "name=" + name + ", "
                + "iso_code=" + iso_code + ", "
                + "language_code=" + language_code + ", "
                + "active=" + active + ", "
                + "is_rtl=" + is_rtl + ", "
                + "date_format_lite=" + date_format_lite + ", "
                + "date_format_full=" +  date_format_full+ ","
                + " ]";
   }
    /**
     * Obtiene el valor de la propiedad content.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
//    public String getContent() {
//        return content;
//    }

    /**
     * Define el valor de la propiedad content.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
//    public void setContent(String value) {
//        this.content = value;
//    }

    /**
     * Obtiene el valor de la propiedad href.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Define el valor de la propiedad href.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}