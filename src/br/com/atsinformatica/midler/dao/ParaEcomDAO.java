/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AlexsanderPimenta
 */
public class ParaEcomDAO implements GenericDAO<ParaEcomDAO> {

    @Override
    public void gravar(ParaEcomDAO object) throws SQLException {
        try{
            
        }catch(Exception e){
            
        }finally{
            
        }
    }

    @Override
    public void alterar(ParaEcomDAO object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ParaEcomDAO abrir(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ParaEcomDAO> listaTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
    
    
    
    
    
}
