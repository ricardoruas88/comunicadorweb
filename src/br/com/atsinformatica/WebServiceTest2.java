/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica;

/**
 *
 * @author ricardosilva
 */
import br.com.atsinformatica.prestashop.model.Product;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

import java.net.URI;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBException;

public class WebServiceTest2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException {
        try {
            String pass = "W6AYITEGCXEFALUDYV0S952CPTAKNF8Q";
            String url = "http://localhost/prestashop/api/";

            ClientConfig config = new DefaultClientConfig();
            Client client = Client.create(config);
            client.addFilter(new HTTPBasicAuthFilter(pass, ""));
            WebResource service = client.resource(url);

            System.out.println(service.path("products")
                    .path("1")
                    .accept(MediaType.TEXT_XML)
                    .get(String.class));

            Product product;
            
            product = service.path("products")
                    .path("1")
                    .accept(MediaType.TEXT_XML)
                    .get(Product.class);
            
            System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkk:  ");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/api").build();
    }

}
