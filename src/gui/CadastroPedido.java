/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.basica.Cliente;
import negocio.basica.Produto;
import negocio.basica.Vendedor;
import negocio.exception.ClienteException;
import negocio.exception.ConexaoException;
import negocio.exception.DAOException;
import negocio.exception.ProdutoException;
import negocio.exception.VendedorException;
import negocio.fachada.FachadaCliente;
import negocio.fachada.FachadaProduto;
import negocio.fachada.FachadaVendedor;
import java.text.DecimalFormat;

/**
 *
 * @author Gildo
 */
public class CadastroPedido extends javax.swing.JFrame {
    CadastroPagamento passavalor;
    /**
     * Creates new form CadastroPedido
     */
     public CadastroPedido() {
        initComponents();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boxVendedor = new javax.swing.JComboBox<>();
        boxCliente = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        boxProduto = new javax.swing.JComboBox<>();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTotalCompra = new javax.swing.JLabel();
        btnFinalizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jTextqtd = new javax.swing.JTextField();
        btnExcluirCompra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cadastro de Pedido");

        jLabel2.setText("Vendedor:");

        jLabel3.setText("Cliente:");

        boxVendedor.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                boxVendedorComponentShown(evt);
            }
        });
        boxVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxVendedorActionPerformed(evt);
            }
        });

        jLabel4.setText("Lista de Produtos:");

        btnAdicionar.setText("Adicionar ao Carrinho");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jTProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Preço Unitário", "Quantidade", "Total Produto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTProdutos);
        if (jTProdutos.getColumnModel().getColumnCount() > 0) {
            jTProdutos.getColumnModel().getColumn(0).setMinWidth(5);
            jTProdutos.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTProdutos.getColumnModel().getColumn(2).setMinWidth(20);
            jTProdutos.getColumnModel().getColumn(2).setPreferredWidth(20);
            jTProdutos.getColumnModel().getColumn(3).setMinWidth(5);
            jTProdutos.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Carrinho de Compras");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Total da Compra:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("R$");

        lblTotalCompra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTotalCompra.setText("0,00");

        btnFinalizar.setText("Finalizar Pedido");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar Campos");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jTextqtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextqtdActionPerformed(evt);
            }
        });

        btnExcluirCompra.setText("Excluir Compra");
        btnExcluirCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 10, Short.MAX_VALUE)
                                .addComponent(boxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextqtd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnExcluirCompra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                .addComponent(btnFinalizar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(boxVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(boxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar)
                    .addComponent(jTextqtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnListar)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(lblTotalCompra)
                    .addComponent(btnExcluirCompra))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar)
                    .addComponent(btnFinalizar))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        // TODO add your handling code here:
        FachadaProduto p = new FachadaProduto();
        String produtoNome;
        Produto produto;
        String total;
        try{       
        produtoNome = (boxProduto.getSelectedItem().toString());
        produto = p.consultar(produtoNome);
        DefaultTableModel dtmProdutos = (DefaultTableModel) jTProdutos.getModel();
        
        double quantidade = 0;
        quantidade = Double.parseDouble(jTextqtd.getText());
        
        Object[] dados = {produto.getProdutoCodigo(),
            boxProduto.getSelectedItem(),
            produto.getProdutoPreco(),
            jTextqtd.getText(),
            quantidade * produto.getProdutoPreco()        
        };
        dtmProdutos.addRow(dados);
        double count=0;
        for (int i=0; i<=jTProdutos.getRowCount()-1;i++) {
        count+=Double.parseDouble(jTProdutos.getValueAt(i, 4).toString());
        }
        DecimalFormat df = new DecimalFormat("0.##");
        lblTotalCompra.setText(String.valueOf(count));
        }catch (ProdutoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (ConexaoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } 
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        // TODO add your handling code here:
       /* CadastroPagamento cp = new CadastroPagamento();
        cp.setVisible(true);*/
        
        if (passavalor == null){
            passavalor = new CadastroPagamento();
            passavalor.setVisible(true);
            passavalor.recebendo(lblTotalCompra.getText());
        }else{
            passavalor.setVisible(true);
            passavalor.setState(CadastroPagamento.NORMAL);
        }
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void boxVendedorComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_boxVendedorComponentShown
        // TODO add your handling code here:
        /*FachadaVendedor f = new FachadaVendedor();
        List<Vendedor> vendedores = f.listarPorNome();*/
        
    }//GEN-LAST:event_boxVendedorComponentShown

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        // TODO add your handling code here:
        FachadaProduto fp = new FachadaProduto();
        try {
        boxProduto.removeAllItems();
        for(Produto p: fp.listarTodos()){
        boxProduto.addItem(p);
        }
        } catch (ProdutoException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (ConexaoException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (DAOException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        FachadaCliente fc = new FachadaCliente();
        try {
            boxCliente.removeAllItems();
            for(Cliente c: fc.listarTodos()){
                boxCliente.addItem(c);
            }   
        } catch (ClienteException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (ConexaoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
        FachadaVendedor fv = new FachadaVendedor();
        try {
            boxVendedor.removeAllItems();
            for(Vendedor v: fv.listarTodos()){
                boxVendedor.addItem(v);
            }   
        } catch (VendedorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (ConexaoException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (DAOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_btnListarActionPerformed

    private void boxVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxVendedorActionPerformed

    private void jTextqtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextqtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextqtdActionPerformed


    private void btnExcluirCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCompraActionPerformed
        // Ainda em desenvolvimento:
        DefaultTableModel dtmProdutos = (DefaultTableModel) jTProdutos.getModel();
        Double valord = 0.00;
        String valors = null;
        if (jTProdutos.getSelectedRow() >= 0){
            valord =  ((Double.parseDouble(lblTotalCompra.getText())-((Double) jTProdutos.getValueAt(jTProdutos.getSelectedRow(),4))));
            valors = valord.toString();
            dtmProdutos.removeRow(jTProdutos.getSelectedRow());
            jTProdutos.setModel(dtmProdutos);            
        }else{
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }
        lblTotalCompra.setText(valors);
    }//GEN-LAST:event_btnExcluirCompraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
     
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> boxCliente;
    private javax.swing.JComboBox<Object> boxProduto;
    private javax.swing.JComboBox<Object> boxVendedor;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluirCompra;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTProdutos;
    private javax.swing.JTextField jTextqtd;
    public javax.swing.JLabel lblTotalCompra;
    // End of variables declaration//GEN-END:variables
}
