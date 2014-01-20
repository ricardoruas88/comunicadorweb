package br.com.atsinformatica.midler;

import br.com.atsinformatica.prestashop.model.Language;
import java.util.logging.Level;
import java.util.logging.Logger;

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
