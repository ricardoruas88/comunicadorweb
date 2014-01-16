package br.com.atsinformatica.prestashop.client;

import br.com.atsinformatica.prestashop.api.AccessXMLAttribute;
import br.com.atsinformatica.prestashop.factory.Languages;
import br.com.atsinformatica.prestashop.model.Description;
import br.com.atsinformatica.prestashop.model.Id;
import br.com.atsinformatica.prestashop.model.Language;
import br.com.atsinformatica.prestashop.model.Name;
import br.com.atsinformatica.prestashop.model.Price;
import br.com.atsinformatica.prestashop.model.Product;
import br.com.atsinformatica.prestashop.model.ProductSupplier;
import br.com.atsinformatica.prestashop.model.Type;
import br.com.atsinformatica.prestashop.prestashop.PrestashopItens;
import br.com.atsinformatica.prestashop.sax.NamespaceFilter;
import java.util.logging.Logger;

import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLFilter;
import org.xml.sax.XMLReader;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.bind.Marshaller;

public class ClientPrestashop {

    public static final Logger log = Logger.getLogger(ClientPrestashop.class.getCanonicalName());
    private final String pass = "W6AYITEGCXEFALUDYV0S952CPTAKNF8Q";
    private final String url = "http://localhost/prestashop/api/";

    public Object getPrestashopPackage(String path, Class<?> classe) throws JAXBException, Exception {

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        client.addFilter(new HTTPBasicAuthFilter(pass, ""));

        WebResource webresource = client.resource(url + path);
        ClientResponse response = webresource.type(MediaType.APPLICATION_XML).get(ClientResponse.class);

        mostrar(response.getStatus());

        JAXBContext jaxbContext = JAXBContext.newInstance(classe);
        /*
         * @sin
         */
        //Crear XMLFilter
        XMLFilter filter = new NamespaceFilter("http://www.w3.org/1999/xlink", true);

        //El XMLReader ser� encapsulado en nuestro XMLFilter.
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser sp = spf.newSAXParser();
        XMLReader xr = sp.getXMLReader();
        filter.setParent(xr);

        //Modificar UnmarshalerHandler como ContentHandler en XMLFilter	
        Unmarshaller unmarshall = jaxbContext.createUnmarshaller();
        UnmarshallerHandler unmarshallerHandler = unmarshall.getUnmarshallerHandler();
        filter.setContentHandler(unmarshallerHandler);

        //Parse del XML
        InputSource sr = new InputSource(response.getEntityInputStream());
        filter.parse(sr);
        Object presta = unmarshallerHandler.getResult();

        return presta;
    }
    private static final String BOOKSTORE_XML = "./bookstore-jaxb.xml";
    
    public void putPrestashopPackage(String path, Class<?> classe, Language language) throws JAXBException, ParserConfigurationException, SAXException, IOException {
        // create JAXB context and instantiate marshaller

        PrestashopItens itens = new PrestashopItens();
        itens.setLanguage(language);
        
        
        
        JAXBContext context = JAXBContext.newInstance(PrestashopItens.class);
        
        XMLFilter filter = new NamespaceFilter("http://www.w3.org/1999/xlink", true);
        
        //Modificar UnmarshalerHandler como ContentHandler en XMLFilter	
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // Write to System.out
        m.marshal(itens, System.out);
        // Write to File
        m.marshal(itens, new File(BOOKSTORE_XML));

        // get variables from our xml file, created before
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller um = context.createUnmarshaller();
        
        PrestashopItens bookstore2 = (PrestashopItens) um.unmarshal(new FileReader(BOOKSTORE_XML));
        ProductSupplier list = bookstore2.getProductSupplier();
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        client.addFilter(new HTTPBasicAuthFilter(pass, ""));

        WebResource webresource = client.resource(url);
        ClientResponse response = webresource.path(path).type(MediaType.APPLICATION_XML).put(ClientResponse.class,itens);
        System.out.println(response.getStatus());
    }
    
    private void mostrar(Object o) {
        System.out.println(o);
    }
}
