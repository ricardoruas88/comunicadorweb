/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.TEST;

import br.com.atsinformatica.prestashop.api.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.api.ServicesWeb;
import br.com.atsinformatica.prestashop.client.ClientPrestashop;
import br.com.atsinformatica.prestashop.model.ProductFeature;
import br.com.atsinformatica.prestashop.model.entitygeneric.Language;
import br.com.atsinformatica.prestashop.model.entitygeneric.Name;
import br.com.atsinformatica.prestashop.model.list.ProductFeatures;
import br.com.atsinformatica.prestashop.prestashop.GetPrestashopItem;
import br.com.atsinformatica.prestashop.prestashop.SetPrestashopItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author ricardosilva
 */
public class Main {

    public static void main(String args[]) throws Exception {
        Main m = new Main();
        //m.getItensPrestaShop();
        //m.getItemPrestaShop();
        m.testPostProduct();
    }

    private void getItensPrestaShop() {
        try {
            ClientPrestashop clientPrestashop = new ClientPrestashop();
            ServicesWeb prestashop = (ServicesWeb) clientPrestashop.getPrestashopPackage("product_features/2", ServicesWeb.class);
            ProductFeatures productFeatures = prestashop.getProductFeatures();
            List<AccessXMLAttribute> ps = productFeatures.getProductFeature();
            for (AccessXMLAttribute p : ps) {
                clientPrestashop.mostrar(p.getId() + "---" + p.getHref());
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void getItemPrestaShop() throws Exception {
        ClientPrestashop client = new ClientPrestashop();
        GetPrestashopItem clss = new GetPrestashopItem();
        GetPrestashopItem prestashop = (GetPrestashopItem) client.getPrestashopPackage("product_features/2", clss.getClass());
        String id = prestashop.getProductFeature().getId();
        System.out.println(id);
    }
    
    public void testPostProduct() throws JAXBException, ParserConfigurationException, SAXException, IOException {

        ClientPrestashop client = new ClientPrestashop();
        List<Language> listLang = new ArrayList<Language>();

        Language language = new Language();
        language.setContent("ricardo ruas silva é um cara muito bom top");
        language.setId("1");
        listLang.add(language);

        Name name = new Name();
        name.setLanguage(listLang);

        ProductFeature feature = new ProductFeature();
        //feature.setId(6);
        feature.setName(name);
        feature.setPosition("0");

        SetPrestashopItem prestashop = new SetPrestashopItem();
        prestashop.setProductFeature(feature);

        client.postPrestashopPackage("product_features/",prestashop);
    }
}
