package br.com.atsinformatica.prestashop.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://W6AYITEGCXEFALUDYV0S952CPTAKNF8Q@localhost/prestashop/api/product_suppliers/id", name = "", propOrder = {
    "id",
    "idProduct",
    "idProductAttribute",
    "productSupplierReference",
    "productSupplierPriceTe",
    "idCurrency",
    "idSupplier"
})
@XmlRootElement(name = "product_supplier")
public class ProductSupplier {

	@XmlElement(name="id", required = true)
    protected Id id;
    @XmlElement(name = "id_product", required = true)
    protected String idProduct;
    @XmlElement(name = "id_product_attribute", required = true)
    protected String idProductAttribute;
    @XmlElement(name = "id_supplier",required = true)
    protected String idSupplier;
    @XmlElement(name = "id_currency",required = true)
    protected String idCurrency;
    @XmlElement(name = "product_supplier_reference", required = true)
    protected String productSupplierReference;
    @XmlElement(name = "product_supplier_price_te", required = true)
    protected String productSupplierPriceTe;
    
    
	public Id getId() {
		return id;
	}
	public void setId(Id id) {
		this.id = id;
	}
	public String getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	public String getIdProductAttribute() {
		return idProductAttribute;
	}
	public void setIdProductAttribute(String idProductAttribute) {
		this.idProductAttribute = idProductAttribute;
	}
	public String getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(String idSupplier) {
		this.idSupplier = idSupplier;
	}
	public String getIdCurrency() {
		return idCurrency;
	}
	public void setIdCurrency(String idCurrency) {
		this.idCurrency = idCurrency;
	}
	public String getProductSupplierReference() {
		return productSupplierReference;
	}
	public void setProductSupplierReference(String productSupplierReference) {
		this.productSupplierReference = productSupplierReference;
	}
	public String getProductSupplierPriceTe() {
		return productSupplierPriceTe;
	}
	public void setProductSupplierPriceTe(String productSupplierPriceTe) {
		this.productSupplierPriceTe = productSupplierPriceTe;
	}

    
    
}
