/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtos;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import principal.GerarCodigos;
public class FrmProdutos extends javax.swing.JInternalFrame {


    public FrmProdutos() {
        initComponents();
        tabela.getTableHeader().setDefaultRenderer(new principal.EstiloTabelaHeader());
        tabela.setDefaultRenderer(Object.class, new principal.EstiloTabelaRenderer());
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        limparCampos();
        
        //INICIALIZAÇÃO DOS COMPONENTES
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (tabela.getSelectedRow() != -1) {
                    atualizarDados();
                    //selecionarRegistro = true;
                }
            }
        });
        
        
        
    }
    
    
    
     void atualizarDados() {
        int linha = tabela.getSelectedRow();
        codigot.setText(tabela.getValueAt(linha, 0).toString());
        tipocC.setText(tabela.getValueAt(linha, 1).toString());
        tipo.setText(tabela.getValueAt(linha, 2).toString());
        valor.setText(tabela.getValueAt(linha, 3).toString());
    }
    
    
    void limparCampos() {
        if (tabela.getSelectedRow() > -1) {
            tabela.removeRowSelectionInterval(tabela.getSelectedRow(), tabela.getSelectedRow());
        }
        codigot.setText("");
        tipo.setText("");
       
        tipocC.setText("");
        
        
        valor.setText("");
        ProdutosSql.listar("");
        ProdutosSql.gerarId();
    }
    
    
    void selecionarLinha(String id) {
        for (int i = 0; i < tabela.getRowCount(); i++) {
            if (id.equals(tabela.getValueAt(i, 0))) {
                tabela.setRowSelectionInterval(i, i);
                break;
            }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        codigot = new javax.swing.JLabel();
        tipocC = new javax.swing.JTextField();
        tipo = new javax.swing.JTextField();
        valor = new javax.swing.JTextField();
        codigo = new javax.swing.JLabel();
        tipoC = new javax.swing.JLabel();
        tipoL = new javax.swing.JLabel();
        nomeL1 = new javax.swing.JLabel();
        nomeL2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        registrar = new javax.swing.JButton();
        atualizar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        excluirT = new javax.swing.JButton();
        limpar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        buscar = new javax.swing.JTextField();
        codigoL1 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(780, 520));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "REGISTRO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigot.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        codigot.setForeground(new java.awt.Color(153, 153, 153));
        codigot.setText("CÓDIGO");
        jPanel2.add(codigot, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, -1, 30));

        tipocC.setBackground(new java.awt.Color(42, 102, 142));
        tipocC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tipocC.setForeground(new java.awt.Color(204, 204, 204));
        tipocC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tipocC.setText("TIPO PRODUTO");
        tipocC.setBorder(null);
        jPanel2.add(tipocC, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 160, 30));

        tipo.setBackground(new java.awt.Color(42, 102, 142));
        tipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tipo.setForeground(new java.awt.Color(204, 204, 204));
        tipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tipo.setText("NOME PRODUTO");
        tipo.setBorder(null);
        jPanel2.add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 170, 30));

        valor.setBackground(new java.awt.Color(42, 102, 142));
        valor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valor.setForeground(new java.awt.Color(204, 204, 204));
        valor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        valor.setBorder(null);
        jPanel2.add(valor, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 170, 30));

        codigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/codigoL.png"))); // NOI18N
        jPanel2.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, 52));

        tipoC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/nomeL.png"))); // NOI18N
        jPanel2.add(tipoC, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, 52));

        tipoL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/tipopro.png"))); // NOI18N
        tipoL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(tipoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, -1, 52));

        nomeL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/precoL.png"))); // NOI18N
        jPanel2.add(nomeL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, 52));

        nomeL2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/nomeL.png"))); // NOI18N
        jPanel2.add(nomeL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, 52));

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "TIPO PRODUTO", "NOME DO PRODUTO", "PREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tabela);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "OPÇÕES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/regis1.png"))); // NOI18N
        registrar.setText("Registrar");
        registrar.setBorder(null);
        registrar.setBorderPainted(false);
        registrar.setContentAreaFilled(false);
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/regis2.png"))); // NOI18N
        registrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        atualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar.png"))); // NOI18N
        atualizar.setBorder(null);
        atualizar.setBorderPainted(false);
        atualizar.setContentAreaFilled(false);
        atualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        atualizar.setLabel("Atualizar");
        atualizar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar1.png"))); // NOI18N
        atualizar.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/editar1.png"))); // NOI18N
        atualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarActionPerformed(evt);
            }
        });

        excluir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagar.png"))); // NOI18N
        excluir.setBorder(null);
        excluir.setBorderPainted(false);
        excluir.setContentAreaFilled(false);
        excluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluir.setLabel("Excluir");
        excluir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagar1.png"))); // NOI18N
        excluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        excluirT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        excluirT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagarT.png"))); // NOI18N
        excluirT.setBorder(null);
        excluirT.setBorderPainted(false);
        excluirT.setContentAreaFilled(false);
        excluirT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        excluirT.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        excluirT.setLabel("Excluir Tudo");
        excluirT.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/apagarT1.png"))); // NOI18N
        excluirT.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        excluirT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirTActionPerformed(evt);
            }
        });

        limpar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/limpar.png"))); // NOI18N
        limpar.setBorder(null);
        limpar.setBorderPainted(false);
        limpar.setContentAreaFilled(false);
        limpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        limpar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        limpar.setLabel("Limpar Campos");
        limpar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/limpar1.png"))); // NOI18N
        limpar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(atualizar)
                .addGap(10, 10, 10)
                .addComponent(excluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(excluirT)
                .addGap(18, 18, 18)
                .addComponent(limpar)
                .addGap(4, 4, 4))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrar)
            .addComponent(atualizar)
            .addComponent(excluir)
            .addComponent(excluirT)
            .addComponent(limpar)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "BUSCAR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        jPanel4.add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, 30));

        codigoL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigoL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos/buscarL.png"))); // NOI18N
        jPanel4.add(codigoL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 250, 52));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyReleased
            tipo.setText(tipo.getText().toUpperCase());
    }//GEN-LAST:event_nomeKeyReleased

    private void nomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyTyped

    }//GEN-LAST:event_nomeKeyTyped

    private void valorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorKeyTyped

    }//GEN-LAST:event_valorKeyTyped

     boolean selecionarRegistro = false;
    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
          if (selecionarRegistro) {
            JOptionPane.showMessageDialog(this, "O código: " + this.codigot.getText() + "\n já está registrado.", "Inserir Registro", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        } else {
            
            if (codigot.getText().equals("") || tipo.getText().equals("") || tipocC.getText().equals("")
                     || valor.equals("")) {
                JOptionPane.showMessageDialog(this, "Todos os campos\nsão obrigatórios.", "Inserir Registro", 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
            } else {
                try {
                    GerarCodigos codProduto = new GerarCodigos();
                    int id = codProduto.gerarId("produtos");
                    produtos.Produtos us = new Produtos();
                    us.setPrimaryKey(id);
                    us.setTipo(tipocC.getText().toString());
                    us.setNome(tipo.getText());
                    
                    us.setValor(valor.getText());
                    int op = ProdutosSql.registrar(us);
                    if (op != 0) {
                        Object idLinha = id;
                        idLinha = idLinha.toString();
                        selecionarLinha((String) idLinha);
                        JOptionPane.showMessageDialog(this, "Inserido com Sucesso.", "Inserir Registro", 0,
                                new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                        
                        limparCampos();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FrmProdutos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }//GEN-LAST:event_registrarActionPerformed

    private void atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarActionPerformed
        if (tabela.getRowCount() > 0) {
            if (tabela.getSelectedRowCount() > 0) {
                
                if (codigot.getText().equals("") || tipo.getText().equals("") 
                        || tipocC.getText().equals("") || valor.equals("")) {
                    JOptionPane.showMessageDialog(this, "Preecha os campos.", "Editar", 0,
                            new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                } else if (JOptionPane.showConfirmDialog(this, "Deseja alterar o registro?", "Editar", JOptionPane.YES_NO_OPTION, 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png"))) == JOptionPane.YES_OPTION) {
                    produtos.Produtos us = new Produtos();
                    us.setPrimaryKey(Integer.parseInt(codigot.getText()));
                    us.setTipo(tipocC.getText().toString());
                    us.setNome(tipo.getText());
                    us.setValor(valor.getText());
                    int opc = ProdutosSql.atualizar(us);
                    if (opc != 0) {
                        String id = codigo.getText();
                        limparCampos();
                        selecionarLinha(id);
                        JOptionPane.showMessageDialog(this, "Registro Atualizado.", "Editar", 0,
                                new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um registro.", "Editar", 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
            }

        } else {
            JOptionPane.showMessageDialog(this, "Não há registro para alterar.", "Editar", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        }   
    }//GEN-LAST:event_atualizarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        if (tabela.getRowCount() > 0) {
            if (tabela.getSelectedRowCount() > 0) {
                if (JOptionPane.showConfirmDialog(this, "Deseja Excluir?", "Excluir", JOptionPane.YES_NO_OPTION, 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png"))) == JOptionPane.YES_OPTION) {
                    int linha = tabela.getSelectedRow();
                    String id = tabela.getValueAt(linha, 0).toString();
                    int elimina = ProdutosSql.eliminar(id);
                    if (elimina != 0) {
                        limparCampos();
                        JOptionPane.showMessageDialog(this, "Registro excluido.", "Excluir", 0,
                                new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um registro.", "Excluir", 0,
                        new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
            }

        } else {
            JOptionPane.showMessageDialog(this, "Não há registros para exclusão.", "Excluir", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        }
    }//GEN-LAST:event_excluirActionPerformed

    private void excluirTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirTActionPerformed
       if (tabela.getRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(this, "Deseja excluir todos os usuários?", "Excluir", JOptionPane.YES_NO_OPTION, 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png"))) == JOptionPane.YES_OPTION) {
                int eliminaT = ProdutosSql.eliminaTodos();
                if (eliminaT != 0) {
                    limparCampos();
                    JOptionPane.showMessageDialog(this, "Registros excluidos.", "Excluir", 0,
                            new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
                    
                    
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Não há registros para excluir.", "Excluir", 0,
                    new ImageIcon(getClass().getResource("/imagens/usuarios/info.png")));
        } 
    }//GEN-LAST:event_excluirTActionPerformed

    private void limparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparActionPerformed
            limparCampos();
    }//GEN-LAST:event_limparActionPerformed

    private void buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarMouseClicked

    }//GEN-LAST:event_buscarMouseClicked

    private void buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarKeyReleased
        buscar.setText(buscar.getText().toUpperCase());
        ProdutosSql.listar(buscar.getText());
    }//GEN-LAST:event_buscarKeyReleased

    private void tipoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tipoKeyReleased
        
    }//GEN-LAST:event_tipoKeyReleased

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atualizar;
    private javax.swing.JTextField buscar;
    private javax.swing.JLabel codigo;
    private javax.swing.JLabel codigoL1;
    public static javax.swing.JLabel codigot;
    private javax.swing.JButton excluir;
    private javax.swing.JButton excluirT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpar;
    private javax.swing.JLabel nomeL1;
    private javax.swing.JLabel nomeL2;
    private javax.swing.JButton registrar;
    public static javax.swing.JTable tabela;
    private javax.swing.JTextField tipo;
    private javax.swing.JLabel tipoC;
    private javax.swing.JLabel tipoL;
    private javax.swing.JTextField tipocC;
    private javax.swing.JTextField valor;
    // End of variables declaration//GEN-END:variables
}
