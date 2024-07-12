/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package orçamentoDeMarketing.UI;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import orçamentoDeMarketing.classes.abstracts.Video;
import orçamentoDeMarketing.classes.model.site.Institucional;
import orçamentoDeMarketing.classes.model.site.Loja;
import orçamentoDeMarketing.listas.ListaImagens;
import orçamentoDeMarketing.listas.ListaPSM;
import orçamentoDeMarketing.listas.ListaSites;
import orçamentoDeMarketing.listas.ListaTrafegoPago;
import orçamentoDeMarketing.listas.ListaVideos;

/**
 *
 * @author rodol
 */
public class CarrinhoUI extends javax.swing.JFrame {

    /**
     * Creates new form Carrinhoa
     */
    public CarrinhoUI() {
        initComponents();
        setLocationRelativeTo(null);
    }
    ListaImagens listaImagens = new ListaImagens();
    ListaVideos listaVideos = new ListaVideos();
    ListaSites listaSites = new ListaSites();
    ListaTrafegoPago listaTrafego = new ListaTrafegoPago();
    ListaPSM listaPacotes = new ListaPSM();

    private void inserirDadosNaTabela() {
        DefaultTableModel modeloTabela = (DefaultTableModel) tabelaItens.getModel();
        inserirImagens(modeloTabela);
        inserirVideos(modeloTabela);
        inserirSites(modeloTabela);
        inserirTrafegosPagos(modeloTabela);
        inserirPacotes(modeloTabela);
    }

    private void inserirImagens(DefaultTableModel modeloTabela) {
        for (int i = 0; i < listaImagens.imagens.size(); i++) {
            Object[] dados = {
                "Imagem",
                listaImagens.imagens.get(i).toString(),
                String.format("%.1f", (listaImagens.imagens.get(i).getTempoEstimadoServico() / 60)) + " horas",
                "R$" + String.format("%.2f", listaImagens.imagens.get(i).getPrecoFinal())};
            modeloTabela.addRow(dados);
        }
    }

    private void inserirVideos(DefaultTableModel modeloTabela) {
        for (int i = 0; i < listaVideos.videos.size(); i++) {
            Video video = listaVideos.videos.get(i);
            String[] dados = {"Vídeo",
                "Tipo: " + video.getTipo() + " / Duração: " + video.getDuracao(),
                String.format("%.1f", video.calcularTempoEstimadoServico()),
                "R$" + String.format("%.2f", video.calcularPreco())};

            modeloTabela.addRow(dados);
        }
    }

    private void inserirSites(DefaultTableModel modeloTabela) {
        for (int i = 0; i < listaSites.sites.size(); i++) {
            if (listaSites.sites.get(i).getTipo() == "loja") {
                Loja site = (Loja) listaSites.sites.get(i);
                String[] dados = {"Site",
                    "Tipo :" + site.getTipo() + " / Páginas: " + site.getPaginas() + " / Produtos: " + site.getQntdProdutos(),
                    String.valueOf(site.calcularTempoEstimadoServico()) + " dias",
                    "R$" + String.format("%.2f", site.calcularPreco())
                };
                modeloTabela.addRow(dados);

            } else if (listaSites.sites.get(i).getTipo() == "institucional") {
                Institucional site = (Institucional) listaSites.sites.get(i);
                String[] dados = {"Site",
                    "Tipo: " + site.getTipo() + " / Páginas: " + site.getPaginas(),
                    String.valueOf(site.calcularTempoEstimadoServico()) + " dias",
                    "R$" + String.format("%.2f", site.calcularPreco())
                };
                modeloTabela.addRow(dados);

            }
        }
    }

    private void inserirTrafegosPagos(DefaultTableModel modeloTabela) {
        for (int i = 0; i < listaTrafego.trafegos.size(); i++) {
            String[] dados = {
                "Trafego Pago",
                "Nicho: " + listaTrafego.trafegos.get(i).getNicho() + " / Investimento: R$" + String.format("%.2f", listaTrafego.trafegos.get(i).getValorInvestido()),
                "",
                "R$" + String.format("%.2f", listaTrafego.trafegos.get(i).getPrecoFinal())};
            modeloTabela.addRow(dados);
        }
    }

    private void inserirPacotes(DefaultTableModel modeloTabela) {
        for (int i = 0; i < listaPacotes.pacotes.size(); i++) {
            String[] dados = {
                "Pacote Social Media",
                "Tipo: " + listaPacotes.pacotes.get(i).getTipo(),
                "",
                "R$" + String.format("%.2f", listaPacotes.pacotes.get(i).getPreco())};
            modeloTabela.addRow(dados);
        }
    }

    private double somarValores() {
        double precoTotal = 0;

        precoTotal = listaImagens.calcularPrecoTotal() + listaVideos.calcularPrecoTotal() + listaSites.calcularPrecoTotal() + listaTrafego.calcularPrecoTotal() + listaPacotes.calcularPrecoTotal();

        return precoTotal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel2 = new javax.swing.JPanel();
        txtCarrinho = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItens = new javax.swing.JTable();
        buttonMostrarItens = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        buttonVoltarPagina = new javax.swing.JButton();
        txtPrecoTotal = new javax.swing.JTextField();
        bttnSomar = new javax.swing.JButton();
        buttonMostrarItens2 = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setToolTipText("");
        jPanel2.setMinimumSize(new java.awt.Dimension(720, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(850, 500));

        txtCarrinho.setFont(new java.awt.Font("Noto Serif", 1, 48)); // NOI18N
        txtCarrinho.setForeground(new java.awt.Color(237, 125, 49));
        txtCarrinho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtCarrinho.setText("CARRINHO");

        tabelaItens.setBackground(new java.awt.Color(255, 255, 255));
        tabelaItens.setFont(new java.awt.Font("Noto Sans", 0, 12)); // NOI18N
        tabelaItens.setForeground(new java.awt.Color(51, 51, 51));
        tabelaItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo", "Descrição", "Tempo de Serviço", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaItens.setToolTipText("");
        tabelaItens.setShowGrid(false);
        tabelaItens.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaItens);
        if (tabelaItens.getColumnModel().getColumnCount() > 0) {
            tabelaItens.getColumnModel().getColumn(0).setResizable(false);
            tabelaItens.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaItens.getColumnModel().getColumn(1).setResizable(false);
            tabelaItens.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabelaItens.getColumnModel().getColumn(2).setResizable(false);
            tabelaItens.getColumnModel().getColumn(2).setPreferredWidth(50);
            tabelaItens.getColumnModel().getColumn(3).setResizable(false);
            tabelaItens.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        buttonMostrarItens.setBackground(new java.awt.Color(237, 125, 49));
        buttonMostrarItens.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        buttonMostrarItens.setForeground(new java.awt.Color(255, 255, 255));
        buttonMostrarItens.setText("CARREGAR");
        buttonMostrarItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMostrarItensActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(237, 126, 49));
        jPanel4.setForeground(new java.awt.Color(237, 126, 49));

        buttonVoltarPagina.setBackground(new java.awt.Color(237, 125, 49));
        buttonVoltarPagina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/orçamentoDeMarketing/images/back-page-icon.png"))); // NOI18N
        buttonVoltarPagina.setBorder(null);
        buttonVoltarPagina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonVoltarPaginaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonVoltarPaginaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonVoltarPaginaMouseExited(evt);
            }
        });
        buttonVoltarPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarPaginaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(buttonVoltarPagina)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(buttonVoltarPagina)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPrecoTotal.setText("R$0.00");
        txtPrecoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecoTotalActionPerformed(evt);
            }
        });

        bttnSomar.setBackground(new java.awt.Color(237, 125, 49));
        bttnSomar.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        bttnSomar.setForeground(new java.awt.Color(255, 255, 255));
        bttnSomar.setText("Somar");
        bttnSomar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnSomarActionPerformed(evt);
            }
        });

        buttonMostrarItens2.setBackground(new java.awt.Color(237, 125, 49));
        buttonMostrarItens2.setFont(new java.awt.Font("Noto Sans", 1, 18)); // NOI18N
        buttonMostrarItens2.setForeground(new java.awt.Color(255, 255, 255));
        buttonMostrarItens2.setText("Finalizar");
        buttonMostrarItens2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMostrarItens2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCarrinho)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(buttonMostrarItens2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(bttnSomar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonMostrarItens, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCarrinho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonMostrarItens)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bttnSomar)
                            .addComponent(txtPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(buttonMostrarItens2)))
                .addGap(57, 108, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMostrarItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMostrarItensActionPerformed
        if (listaImagens.imagens.isEmpty() && listaVideos.videos.isEmpty() && listaSites.sites.isEmpty() && listaTrafego.trafegos.isEmpty() && listaPacotes.pacotes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum item adicionado ao carrinho.");
        } else {
            inserirDadosNaTabela();
            buttonMostrarItens.setEnabled(false);
        }
    }//GEN-LAST:event_buttonMostrarItensActionPerformed

    private void buttonVoltarPaginaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltarPaginaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonVoltarPaginaMouseClicked

    private void buttonVoltarPaginaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltarPaginaMouseEntered
        buttonVoltarPagina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/orçamentoDeMarketing/images/back-page-icon-entered.png")));
    }//GEN-LAST:event_buttonVoltarPaginaMouseEntered

    private void buttonVoltarPaginaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVoltarPaginaMouseExited
        buttonVoltarPagina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/orçamentoDeMarketing/images/back-page-icon.png")));
    }//GEN-LAST:event_buttonVoltarPaginaMouseExited

    private void buttonVoltarPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarPaginaActionPerformed
        PrincipalUI menu = new PrincipalUI();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonVoltarPaginaActionPerformed

    private void bttnSomarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnSomarActionPerformed
        txtPrecoTotal.setText("R$" + String.format("%.2f", somarValores()));
    }//GEN-LAST:event_bttnSomarActionPerformed

    private void txtPrecoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecoTotalActionPerformed

    private void buttonMostrarItens2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMostrarItens2ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Deseja finalizar sua compra?"
                + "\nValor total: R$" + String.format("%.2f", somarValores())) == 0) {
            JOptionPane.showMessageDialog(null, "Compra finalizada. Obrigado pela preferência!");
            PrincipalUI menu = new PrincipalUI();
            menu.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Compra cancelada.");
        }
    }//GEN-LAST:event_buttonMostrarItens2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void Carrinho(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarrinhoUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarrinhoUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarrinhoUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarrinhoUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarrinhoUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttnSomar;
    private javax.swing.JButton buttonMostrarItens;
    private javax.swing.JButton buttonMostrarItens2;
    private javax.swing.JButton buttonVoltarPagina;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaItens;
    private javax.swing.JLabel txtCarrinho;
    private javax.swing.JTextField txtPrecoTotal;
    // End of variables declaration//GEN-END:variables
}
