package br.com.atsinformatica.midler;

import br.com.atsinformatica.prestashop.api.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.api.ServicesWeb;
import br.com.atsinformatica.prestashop.client.ClientPrestashop;
import br.com.atsinformatica.prestashop.factory.Languages;
import br.com.atsinformatica.prestashop.factory.ProductSuppliers;
import br.com.atsinformatica.prestashop.model.Language;
import br.com.atsinformatica.prestashop.prestashop.PrestashopItens;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class TestCase {

    @Test
    public void testGetAllItens() throws Exception {
        ClientPrestashop client = new ClientPrestashop();
        ServicesWeb prestashop = (ServicesWeb) client.getPrestashopPackage("languages", ServicesWeb.class);
//		Products product = prestashop.getProducts();
//		List<AccessXMLAttribute> ps = product.getProduct();
//		for(AccessXMLAttribute p : ps ){
//			mostrar(p.getId() + "---" + p.getHref());
//		}
        Languages languages = prestashop.getLanguages();
        List<AccessXMLAttribute> ps = languages.getLanguage();
        for (AccessXMLAttribute p : ps) {
            mostrar(p.getId() + "---" + p.getHref());
        }
    }

    @Test
    public Language testGetItem() throws Exception {
        ClientPrestashop client = new ClientPrestashop();
        PrestashopItens clss = new PrestashopItens();
        PrestashopItens prestashop = (PrestashopItens) client.getPrestashopPackage("languages/1", clss.getClass());
        return prestashop.getLanguage();
    }

    @Test
    public void testPostItem(Language language) throws JAXBException, ParserConfigurationException, SAXException, IOException {
        ClientPrestashop client = new ClientPrestashop();
        language.setName("Portguês pt-BR");
        language.setId("1");
        
        client.putPrestashopPackage("languages", ServicesWeb.class, language);

    }

    private void mostrar(Object o) {
        System.out.println(o);
    }
}
