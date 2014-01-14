package br.com.atsinformatica;

import br.com.atsinformatica.dao.PedidoERPDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PedidoERPDAO pedidoERPDAO = new PedidoERPDAO();
        try {
            pedidoERPDAO.listPedidoERP();
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
