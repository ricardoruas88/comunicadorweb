package br.com.atsinformatica;

import br.com.atsinformatica.prestashop.model.Language;
import br.com.atsinformatica.prestashop.model.ProductSupplier;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        try {
            //new TestCase().testGetAllItens();
            Language l = new TestCase().testGetItem();
            new TestCase().testPostItem(l);
        } catch (Exception ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
