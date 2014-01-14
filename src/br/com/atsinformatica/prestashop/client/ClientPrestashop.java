package br.com.atsinformatica.prestashop.client;

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

import com.prestashopService.api.AccessXMLAttribute;
import com.prestashopService.model.ProductSupplier;
import com.prestashopService.prestashop.PrestashopItens;
import com.prestashopService.sax.NamespaceFilter;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import java.io.IOException;


public class ClientPrestashop{	
	
	public static final Logger log = Logger.getLogger(ClientPrestashop.class.getCanonicalName());
	private final String pass = "W6AYITEGCXEFALUDYV0S952CPTAKNF8Q";
	private final String url="http://W6AYITEGCXEFALUDYV0S952CPTAKNF8Q@localhost/prestashop/api/";
	
	public Object getPrestashopPackage(String path, Class<?> classe) throws JAXBException, Exception{
		
		ClientConfig config= new DefaultClientConfig();
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
		XMLFilter filter = new NamespaceFilter("http://www.w3.org/1999/xlink",true);
		
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
	
	public void putPrestashopPackage(String path, PrestashopItens clss, Object requestEntity) throws JAXBException, ParserConfigurationException, SAXException, IOException{
		try {
			ProductSupplier suppliers = new ProductSupplier();
			suppliers.setIdProduct("1");
			suppliers.setIdProductAttribute("0");
			suppliers.setIdSupplier("1");
			suppliers.setIdCurrency("1");
			suppliers.setProductSupplierPriceTe("0.000");
			clss.setProductSupplier(suppliers);
		    javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(AccessXMLAttribute.class);
		    javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
		    marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
		    marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		    marshaller.marshal(clss.getProductSupplier(), System.out);
		} catch (javax.xml.bind.JAXBException ex) {
		    // XXXTODO Handle exception
		    java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
		}
	}
	
	private void mostrar(Object o){
		System.out.println(o);
	}
}
