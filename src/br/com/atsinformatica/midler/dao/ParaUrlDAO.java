/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.dao;

import br.com.atsinformatica.midler.domainmodel.bean.ParaUrlWsdlBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;
import br.com.atsinformatica.midler.utils.Funcoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author AlexsanderPimenta
 */
public class ParaUrlDAO implements GenericDAO<ParaUrlWsdlBean> {
    
    
    private Connection conn;

    @Override
    public void gravar(ParaUrlWsdlBean object) throws SQLException {        
        PreparedStatement pstmt = null;      
        try {
            conn = ConexaoATS.conectaERP();            
            conn.setAutoCommit(false);
            String querie = "INSERT INTO PARAURL (CODPARAURL, URLWSDL) VALUES (?,?)";
            object.setCodParaUrlWsdl(ultimoRegistro());
            pstmt = conn.prepareStatement(querie);
            pstmt.setString(1, object.getCodParaUrlWsdl());
            pstmt.setString(2, object.getUrlWSDL());
            pstmt.executeUpdate();
            conn.commit();
            System.out.println("Url/wsdl salvo com sucesso");
        } catch (Exception e) {
            System.out.println("Erro ao salvar url/wsdl: "+e);            
            conn.rollback();
        } finally {
            pstmt.close();
            conn.close();            
        }
    }

    @Override
    public void alterar(ParaUrlWsdlBean object)  throws SQLException {
        PreparedStatement pstmt = null;
        try {
            conn = ConexaoATS.conectaERP();
            String querie = "UPDATE PARAURL set URLWSDL = ? "
                          + " WHERE CODPARAURL = ? ";
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(querie);
            pstmt.setString(1, object.getUrlWSDL());
            pstmt.setString(2, object.getCodParaUrlWsdl());
            pstmt.executeUpdate();
            conn.commit();
            System.out.println("Url/WSDL alterado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao alterar Url/WSDL: "+e);
            conn.rollback();
        } finally {
            conn.close();
            pstmt.close();
            
        }
    }

    @Override
    public void deletar(String id) throws SQLException {
        PreparedStatement pstmt = null;
        BasicTextEncryptor bt = new BasicTextEncryptor();
        try {
            conn = ConexaoATS.conectaERP();
            String querie = "DELETE FROM PARAURL WHERE CODPARAURL = ?";
            pstmt = conn.prepareStatement(querie);
            conn.setAutoCommit(false);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            conn.commit();
            System.out.println("URL/WSDL deletado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar URL/WSDL: "+e);
            conn.rollback();
        } finally {
            pstmt.close();
            conn.close();
        }
    }

    @Override
    public ParaUrlWsdlBean abrir(String  id) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = ConexaoATS.conectaERP();
            String querie = "Select * from PARAURL where CODPARAURL = ?";
            pstmt = conn.prepareStatement(querie);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            ParaUrlWsdlBean paraUrlBean = new ParaUrlWsdlBean();
            while(rs.next()){
                paraUrlBean.setCodParaUrlWsdl(rs.getString("CODPARAURL"));
                paraUrlBean.setUrlWSDL(rs.getString("URLWSDL"));
            }         
            System.out.println("Url/WSDl retornado com sucesso!");
            return paraUrlBean;
        } catch (Exception e) {
            System.out.println("Erro ao retornar url/wsdl: "+e);
            return null;
        } finally {
            rs.close();
            pstmt.close();
            conn.close();           
        }
        
    }

    @Override
    public List<ParaUrlWsdlBean> listaTodos() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;    
        try{
            List<ParaUrlWsdlBean> listaParaUrl = new ArrayList<>();
            String sql  = "Select * from PARAURL ";
            conn = ConexaoATS.conectaERP();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                ParaUrlWsdlBean paraUrl = new ParaUrlWsdlBean();
                paraUrl.setCodParaUrlWsdl(rs.getString("CODPARAURL"));
                paraUrl.setUrlWSDL(rs.getString("URLWSDL"));
                listaParaUrl.add(paraUrl);                      
            }           
            System.out.println("Lista de url retornada com sucesso.");
            return listaParaUrl;
        }catch(Exception e){
            System.out.println("Erro ao retornar lista de url: "+e);
            return null;
        }finally{
            rs.close();
            stmt.close();
            conn.close();
        }
       
    }

    @Override
    public String ultimoRegistro() throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "select max(CODPARAURL) cod from PARAURL";
            stmt = ConexaoATS.conectaERP().createStatement();
            rs = stmt.executeQuery(sql);
            int cod = 0;
            while (rs.next()) {
                if (rs.getString("cod") != null) {
                    cod = Integer.valueOf(rs.getString("cod")) + 1;
                }
            }
            return Funcoes.preencheCom(Integer.toString(cod), "0", 6, Funcoes.LEFT);
        } catch (Exception e) {
            return null;
        } finally {
            stmt.close();
            rs.close();
        }
    }
}
