/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.atsinformatica.ui;

import br.com.atsinformatica.midler.bean.ERPBean;
import br.com.atsinformatica.midler.bean.FileBean;
import br.com.atsinformatica.midler.jdbc.ConexaoATS;  
import br.com.atsinformatica.midler.properties.OrderedProperties;
import br.com.atsinformatica.midler.utils.Funcoes;
import br.com.atsinformatica.midler.properties.PropertiesManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jasypt.util.text.BasicTextEncryptor;
//import org.apache.log4j.Logger;

/**
 *
 * @author AlexsanderPimenta
 */
public class PanelConfiguracao extends javax.swing.JPanel {

    private PanelPrincipal principal = PanelPrincipal.getInstance();

    /**
     * Creates new form PanelConfiguracao
     */
    public PanelConfiguracao() {
        initComponents();
        jToolBar1.setFloatable(false);
        //iniciando painel de configurações
        //desabilita campos       
        Funcoes.habilitaDesabCampos(this, false);
        //carrega arquivo de configurações
        carregaArquivoConfig();
        //verifica se banco foi criado em diretorio especificado
        if (jBincluir.isEnabled()) {
            jBincluir.requestFocus();
        }
        if (jBalterar.isEnabled()) {
            jBalterar.requestFocus();
        }
        
        
    }

    /**
     * Carrega arquivo de configurações
     */
    private void carregaArquivoConfig() {
        File file = PropertiesManager.getFile();
        // ERPATSController controller = new ERPATSController();
        try {
            //verifica se arquivo existe
            if (file.exists()) {
                jBalterar.setEnabled(true);
                jBincluir.setEnabled(false);
               // jBfechar.setEnabled(true);
                Properties config = PropertiesManager.getConfig();
                //carrega arquivo de configurações
                jTMinCad1.setText(config.getProperty("minutoscadastro"));
                jTMinMov1.setText(config.getProperty("minutosmov"));
                jTdiretorioERP1.setText(config.getProperty("erp.diretorio"));
                jTUsuarioERP1.setText(config.getProperty("erp.usuario"));
                jTsenhaERP1.setText(config.getProperty("erp.senha"));
                jtQtdereg.setText(config.getProperty("qtderegistros"));
                jtQtdemant.setText(config.getProperty("qtdemantido"));
                jTURL.setText(config.getProperty("urlwsdl"));
              //  jRSim.setSelected(config.getProperty("ativasincronizazao").equals("Sim"));
              //  jRNao.setSelected(config.getProperty("ativasincronizazao").equals("Nao"));
                // logger.info("O arquivo de configurações foi carregado com sucesso!");
            }
        } catch (Exception e) {
            System.out.println("Erro : "+e);
            //logger.error("Erro ao carregar arquivo de configuração: " + e.getMessage());
        }

    }
    /*
     * Seta parametros do arquivo de configuração
     * Caso o arquivo de configuração não exista, cria novo
     * @param ecommBean - Bean do ecommerce
     * @param erpBean - Bean do ERP
     * @param minutosSinc - Quantidade de minutos sincronização;
     */

    private void setaArquivoConfiguracao(ERPBean erpBean) throws IOException {
        OrderedProperties config = new OrderedProperties();
        FileOutputStream fileos = new FileOutputStream("config.ini");
        try {
            //config.setProperty("minutoscadastro", Integer.toString(minutosSincCadastro));
            //config.setProperty("minutosmov", Integer.toString(minutosSincMov));
            config.setProperty("erp.diretorio", erpBean.getCaminho());
            config.setProperty("erp.usuario", erpBean.getUsuario());
            //Encripta senha
            BasicTextEncryptor bt = new BasicTextEncryptor();
            //seta codigo de segurança do encriptador
            bt.setPassword("senha001");
            config.setProperty("erp.senha", bt.encrypt(erpBean.getSenha()));
            
//            if (config.getProperty("erp.senha") != null) {
//                if (!config.getProperty("erp.senha").toString().equals(erpBean.getSenha())) {
//                    config.setProperty("erp.senha", erpBean.getSenha());
//                } else {
//                    config.setProperty("erp.senha", erpBean.getSenha());
//                }
//            } else {
//                config.setProperty("erp.senha", erpBean.getSenha());
//            }
            //config.setProperty("qtderegistros", Integer.toString(erpBean.getQtdeReg()));
            //config.setProperty("qtdemantido", Integer.toString(erpBean.getQtdeMant()));
            //config.setProperty("urlwsdl", erpBean.getUrlWSDL());
            //config.setProperty("ativasincronizazao", Funcoes.retornaStrBol(erpBean.isAtivSinc()));            
            
            //grava alterações
            config.store(fileos, "Arquivo de configurações do Midler");
            //fecha arquivo
            fileos.close();
            JOptionPane.showMessageDialog(null, "Configurações salva com sucesso!");
            //logger.info("Arquivo de configurações salvo com sucesso!");
        } catch (Exception e) {
            //logger.error("Erro ao criar arquivo de configurações :" + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jTUsuarioERP1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtQtdereg = new javax.swing.JTextField();
        jtQtdemant = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jBConexao = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jRSim2 = new javax.swing.JRadioButton();
        jRNao2 = new javax.swing.JRadioButton();
        jTsenhaERP1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jTdiretorioERP1 = new javax.swing.JTextField();
        jPIntervaloSinc1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTMinCad1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTMinMov1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jBTSelecionaDirErp1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTURL = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jButton1 = new javax.swing.JButton();
        jBfechar = new javax.swing.JButton();
        jBcancelar = new javax.swing.JButton();
        jBgravar = new javax.swing.JButton();
        jBalterar = new javax.swing.JButton();
        jBincluir = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel14.setText("Senha:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel13.setText("Usuário:");

        jToolBar1.setBorder(null);
        jToolBar1.setRollover(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("Qtde. registros:");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel12.setText("Informe o caminho completo do banco de dados: (exemplo: \"localhost/3050:C/Banco/ResulthERP.fdb\")");

        jBConexao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/atsinformatica/midler/assets/icons/connect.png"))); // NOI18N
        jBConexao.setText("Testar conexão");
        jBConexao.setEnabled(false);
        jBConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBConexaoActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Ativar sincronização:"));

        jRSim2.setText("Sim");
        jRSim2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRSim2jRSimActionPerformed(evt);
            }
        });

        jRNao2.setText("Não");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRSim2)
                    .addComponent(jRNao2))
                .addGap(0, 90, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jRSim2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRNao2))
        );

        jTsenhaERP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTsenhaERP1FocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Qtde. registros mantidos:");

        jTdiretorioERP1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTdiretorioERP1FocusLost(evt);
            }
        });

        jPIntervaloSinc1.setBorder(javax.swing.BorderFactory.createTitledBorder("Intervalo de sincronização:"));
        jPIntervaloSinc1.setEnabled(false);
        jPIntervaloSinc1.setFocusCycleRoot(true);
        jPIntervaloSinc1.setFocusable(false);

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setText("Cadastro:");

        jTMinCad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTMinCad1KeyTyped(evt);
            }
        });

        jLabel17.setText("minutos.");

        jLabel18.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel18.setText("Movimentações:");

        jTMinMov1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTMinMov1KeyTyped(evt);
            }
        });

        jLabel19.setText("minutos.");

        javax.swing.GroupLayout jPIntervaloSinc1Layout = new javax.swing.GroupLayout(jPIntervaloSinc1);
        jPIntervaloSinc1.setLayout(jPIntervaloSinc1Layout);
        jPIntervaloSinc1Layout.setHorizontalGroup(
            jPIntervaloSinc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPIntervaloSinc1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPIntervaloSinc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPIntervaloSinc1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTMinCad1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17))
                    .addGroup(jPIntervaloSinc1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTMinMov1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );
        jPIntervaloSinc1Layout.setVerticalGroup(
            jPIntervaloSinc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPIntervaloSinc1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPIntervaloSinc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTMinCad1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPIntervaloSinc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTMinMov1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(15, 15, 15))
        );

        jBTSelecionaDirErp1.setText("Selecionar");
        jBTSelecionaDirErp1.setEnabled(false);
        jBTSelecionaDirErp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTSelecionaDirErp1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPIntervaloSinc1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jtQtdereg, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jtQtdemant, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(342, 342, 342)
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jTUsuarioERP1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel14))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTsenhaERP1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBConexao))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTdiretorioERP1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBTSelecionaDirErp1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPIntervaloSinc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtQtdereg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtQtdemant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTdiretorioERP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBTSelecionaDirErp1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTUsuarioERP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBConexao)
                    .addComponent(jTsenhaERP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ERP", jPanel3);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Informe WSDL ou URL do WebService:");

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cod.", "URL/WSDL"
            }
        ));
        jScrollPane1.setViewportView(jXTable1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/atsinformatica/midler/assets/icons/arrow_down.png"))); // NOI18N
        jButton1.setText("Adcionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTURL, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("WebService", jPanel5);

        jBfechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/atsinformatica/midler/assets/icons/door_out.png"))); // NOI18N
        jBfechar.setText("Fechar");
        jBfechar.setToolTipText("Fechar");
        jBfechar.setFocusable(false);
        jBfechar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBfechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBfechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBfecharActionPerformed(evt);
            }
        });

        jBcancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/atsinformatica/midler/assets/icons/cancel.png"))); // NOI18N
        jBcancelar.setText("Cancelar");
        jBcancelar.setToolTipText("Cancelar");
        jBcancelar.setEnabled(false);
        jBcancelar.setFocusable(false);
        jBcancelar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBcancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarActionPerformed(evt);
            }
        });

        jBgravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/atsinformatica/midler/assets/icons/save.png"))); // NOI18N
        jBgravar.setText("Gravar");
        jBgravar.setToolTipText("Gravar");
        jBgravar.setEnabled(false);
        jBgravar.setFocusable(false);
        jBgravar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBgravar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBgravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBgravarActionPerformed(evt);
            }
        });

        jBalterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/atsinformatica/midler/assets/icons/pencil3 (2).png"))); // NOI18N
        jBalterar.setText("Alterar");
        jBalterar.setToolTipText("Alterar");
        jBalterar.setEnabled(false);
        jBalterar.setFocusable(false);
        jBalterar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBalterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBalterarActionPerformed(evt);
            }
        });

        jBincluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/atsinformatica/midler/assets/icons/add.png"))); // NOI18N
        jBincluir.setText("Incluir");
        jBincluir.setToolTipText("Incluir");
        jBincluir.setFocusable(false);
        jBincluir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jBincluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBincluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBincluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBincluir)
                        .addComponent(jBalterar)
                        .addComponent(jBgravar)
                        .addComponent(jBcancelar)
                        .addComponent(jBfechar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBincluir)
                    .addComponent(jBalterar)
                    .addComponent(jBgravar)
                    .addComponent(jBcancelar)
                    .addComponent(jBfechar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCbLFiliaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCbLFiliaisMouseClicked
    }//GEN-LAST:event_jCbLFiliaisMouseClicked

    private void jCbLFiliaisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCbLFiliaisMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbLFiliaisMousePressed

    private void jBincluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBincluirActionPerformed
        principal.setjOperacao("Inclusão");
        Funcoes.habilitaDesabCampos(this, true);
        Funcoes.limpaTela(jPanel3);

        jBcancelar.setEnabled(true);
        jBgravar.setEnabled(true);
        jBalterar.setEnabled(false);
        jBincluir.setEnabled(false);
        jTdiretorioERP1.requestFocus();
        jBTSelecionaDirErp1.setEnabled(true);
    }//GEN-LAST:event_jBincluirActionPerformed

    private void jBalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBalterarActionPerformed
        principal.setjOperacao("Alteração");
        Funcoes.habilitaDesabCampos(this, true);
        jBcancelar.setEnabled(true);
        jBgravar.setEnabled(true);
        jBalterar.setEnabled(false);
        jBincluir.setEnabled(false);

        jTdiretorioERP1.requestFocus();
        jBTSelecionaDirErp1.setEnabled(true);
    }//GEN-LAST:event_jBalterarActionPerformed

    private void jBgravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBgravarActionPerformed
        ERPBean erp = new ERPBean();
        try {
            erp.setCaminho(jTdiretorioERP1.getText());
            erp.setUsuario(jTUsuarioERP1.getText());
            erp.setSenha(String.copyValueOf(jTsenhaERP1.getPassword()));
            erp.setQtdeMant(Integer.parseInt(jtQtdemant.getText()));
            erp.setQtdeReg(Integer.parseInt(jtQtdereg.getText()));
            erp.setUrlWSDL(jTURL.getText());
            erp.setAtivSinc(jRSim.isSelected());
            setaArquivoConfiguracao(erp);
            Funcoes.habilitaDesabCampos(this, false);
            jBincluir.setEnabled(false);
            jBcancelar.setEnabled(false);
            jBgravar.setEnabled(false);
            //  logger.info("Gravado com sucesso!");
            //reestarta aplicação
            JOptionPane.showMessageDialog(null, "A aplicação será encerrada para que as configurações sejam efetivadas.");
            Funcoes.reiniciaAplicacao();

        } catch (Exception e) {
            // logger.error("Erro ao gravar: " + e);
            JOptionPane.showMessageDialog(null, "Erro ao gravar: " + e.getMessage());
            PropertiesManager.getConfig().clear();
        }
    }//GEN-LAST:event_jBgravarActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed

        //File file = new File("config.ini");
        int ok = JOptionPane.showConfirmDialog(null, "Deseja cancelar a operação", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (ok == JOptionPane.YES_OPTION) {
            principal.setjOperacao("");
            if (!PropertiesManager.getFile().exists()) {
                jBincluir.setEnabled(true);
                jBalterar.setEnabled(false);
                Funcoes.limpaTela(jPanel3);
            } else {
                carregaArquivoConfig();
                //jBalterar.setEnabled(true);
                //jBincluir.setEnabled(false);
            }
            Funcoes.habilitaDesabCampos(jPanel3, false);
            Funcoes.habilitaDesabCampos(jPanel5, false);
            jBConexao.setEnabled(false);
            jBcancelar.setEnabled(false);
            jBgravar.setEnabled(false);
            jBTSelecionaDirErp1.setEnabled(false);
            //jBalterar.setEnabled(true);
            jBfechar.setEnabled(true);
        }
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jBfecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBfecharActionPerformed
        principal.setjOperacao("");
        principal.setjStatus("");
          //fecha tudo
        this.removeAll();
        //atualiza ui
        this.updateUI(); 
        
        setBorder(null);
        
        
    }//GEN-LAST:event_jBfecharActionPerformed

    private void jBConexaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBConexaoActionPerformed

        File file = new File("config.ini");
        try {

            String senha = jTsenhaERP1.getText();
            if (file.exists()) {
                Properties config = getProperties();

                //se arquivo de configuração não esta vazio
                if (!config.isEmpty()) {
                    //se senha digitada é diferente da senha do arquivo de configurações, criptografa nova senha
                    if (!config.getProperty("erp.senha").equals(jTsenhaERP1.getText())) {
                        senha = jTsenhaERP1.getText();
                    }
                    JOptionPane.showMessageDialog(null, ConexaoATS.conectarERP(jTdiretorioERP1.getText(), jTUsuarioERP1.getText(), senha));
                    // carregaComboFiliais(jTdiretorioERP.getText(), jTUsuarioERP.getText(), senha);
                } else {
                    JOptionPane.showMessageDialog(null, ConexaoATS.conectarERP(jTdiretorioERP1.getText(), jTUsuarioERP1.getText(), senha));
                    //  carregaComboFiliais(jTdiretorioERP.getText(), jTUsuarioERP.getText(), senha);
                }
            } else {
                JOptionPane.showMessageDialog(null, ConexaoATS.conectarERP(jTdiretorioERP1.getText(), jTUsuarioERP1.getText(), senha));
                // carregaComboFiliais(jTdiretorioERP.getText(), jTUsuarioERP.getText(), senha);
            }

            ConexaoATS.fechaConexao();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jBConexaoActionPerformed

    private void jRSim2jRSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRSim2jRSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRSim2jRSimActionPerformed

    private void jTsenhaERP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTsenhaERP1FocusLost
        if (jTUsuarioERP1.getText() != "" && jTdiretorioERP1.getText() != "" && jTsenhaERP1.getPassword().toString() != "") {
            jBConexao.setEnabled(true);
        }
    }//GEN-LAST:event_jTsenhaERP1FocusLost

    private void jTdiretorioERP1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTdiretorioERP1FocusLost
        String str = Funcoes.removeEspacosEmBranco(jTdiretorioERP1.getText());
        jTdiretorioERP1.setText(str);
    }//GEN-LAST:event_jTdiretorioERP1FocusLost

    private void jTMinCad1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTMinCad1KeyTyped
        String caracteres = "0123456789";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTMinCad1KeyTyped

    private void jTMinMov1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTMinMov1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTMinMov1KeyTyped

    private void jBTSelecionaDirErp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTSelecionaDirErp1ActionPerformed
        JFileChooser chooser = new JFileChooser();

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            FileBean file = new FileBean();
            file.setCaminho(chooser.getSelectedFile().getAbsolutePath());
            file.setNomeArquivo(chooser.getSelectedFile().getName());
            jTdiretorioERP1.setText((String) file.getCaminho());
        }
    }//GEN-LAST:event_jBTSelecionaDirErp1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBConexao;
    private javax.swing.JButton jBTSelecionaDirErp1;
    private javax.swing.JButton jBalterar;
    private javax.swing.JButton jBcancelar;
    private javax.swing.JButton jBfechar;
    private javax.swing.JButton jBgravar;
    private javax.swing.JButton jBincluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPIntervaloSinc1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRNao;
    private javax.swing.JRadioButton jRNao1;
    private javax.swing.JRadioButton jRNao2;
    private javax.swing.JRadioButton jRSim;
    private javax.swing.JRadioButton jRSim1;
    private javax.swing.JRadioButton jRSim2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTMinCad1;
    private javax.swing.JTextField jTMinMov1;
    private javax.swing.JTextField jTURL;
    private javax.swing.JTextField jTUsuarioERP1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTdiretorioERP1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPasswordField jTsenhaERP1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private javax.swing.JTextField jtQtdemant;
    private javax.swing.JTextField jtQtdereg;
    // End of variables declaration//GEN-END:variables

    /**
     * Retorna arquivo de configuração
     *
     * @return arquivo de configuração
     */
    public Properties getProperties() throws IOException {

        Properties properties = new Properties();
        File file = new File("config.ini");
        FileInputStream fileis = new FileInputStream(file);
        if (file.exists()) {
            properties.load(fileis);
        }

        return properties;
    }
}
