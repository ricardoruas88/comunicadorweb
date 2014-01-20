/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.midler.domainmodel.bean;

/**
 * Bean de configuração de lista de url/wsdl
 * @author AlexsanderPimenta
 */
public class ParaUrlWsdlBean {
    
    private int codParaUrlWsdl;
    private String urlWSDL;

    /**
     * @return the codParaUrlWsdl
     */
    public int getCodParaUrlWsdl() {
        return codParaUrlWsdl;
    }

    /**
     * @param codParaUrlWsdl the codParaUrlWsdl to set
     */
    public void setCodParaUrlWsdl(int codParaUrlWsdl) {
        this.codParaUrlWsdl = codParaUrlWsdl;
    }

    /**
     * @return the urlWSDL
     */
    public String getUrlWSDL() {
        return urlWSDL;
    }

    /**
     * @param urlWSDL the urlWSDL to set
     */
    public void setUrlWSDL(String urlWSDL) {
        this.urlWSDL = urlWSDL;
    }
    
}
