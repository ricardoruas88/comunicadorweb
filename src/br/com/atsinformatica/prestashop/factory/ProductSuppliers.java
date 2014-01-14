package com.prestashopService.factory;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.prestashopService.api.AccessXMLAttribute;
import com.prestashopService.model.ProductSupplier;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "productSupplier" })
@XmlRootElement(name = "product_suppliers")
public class ProductSuppliers {

	@XmlElement(name="product_supplier")
	protected List<AccessXMLAttribute> productSupplier;

	public List<AccessXMLAttribute> getProductSupplier() {
		if (productSupplier == null) {
			productSupplier = new ArrayList<AccessXMLAttribute>();
		}
		return this.productSupplier;
	}

}
