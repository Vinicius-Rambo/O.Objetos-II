package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.DaoProjetos;
import model.Projetos;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProjetosView extends javax.swing.JPanel {

    Projetos projetos; // Objeto da classe Projetos
    DaoProjetos daoProjetos; // Objeto DAO responsável pelas operações no banco
    
    //Construtor da tela
    public ProjetosView() {
        
        daoProjetos = new DaoProjetos(); // Inicializa o DAO
        initComponents();
        atualizarTabelaProjetos(); //Para a tabela estar sempre atualizada
        btExcluir.setEnabled(false);
    }
    
    // Atualiza JTable
    public void atualizarTabelaProjetos() {
        jTableProjetos.setModel(new ProjetosTableModel(daoProjetos.buscarTodos()));
    }
    
    //Limpa os campos da tela
    public void limparCampos(){
       tfID.setText("");
        tfEmpresaResponsavel.setText("");
        tfTipodeProjeto.setText("");
        tfNomeDoProjeto.setText("");
        tfDatafinal.setText("");
        tfDatafinal.setText("");

        BotoesDeStatus.clearSelection();

        btExcluir.setEnabled(false);
    } 
    
    
    //Codigo do proprio JavaSwing criado pelo Netbeans
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotoesDeStatus = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfEmpresaResponsavel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfNomeDoProjeto = new javax.swing.JTextField();
        tfTipodeProjeto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfDataFinal = new javax.swing.JLabel();
        tfStatus = new javax.swing.JLabel();
        rbNaoIniciado = new javax.swing.JRadioButton();
        rbEmAndamento = new javax.swing.JRadioButton();
        dbFinalizado = new javax.swing.JRadioButton();
        dbCancelado = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        Relatorio = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProjetos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbFiltros = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        btFiltrar = new javax.swing.JButton();
        btMostrar = new javax.swing.JButton();
        tfDatafinal = new javax.swing.JFormattedTextField();
        tfDatadeInicio1 = new javax.swing.JFormattedTextField();

        jLabel2.setText("ID: ");

        tfID.setEditable(false);
        tfID.addActionListener(this::tfIDActionPerformed);

        jLabel3.setText("Empresa Responsavel: ");

        tfEmpresaResponsavel.addActionListener(this::tfEmpresaResponsavelActionPerformed);

        jLabel4.setText("Tipo de Projeto:");

        jLabel10.setText("Nome do projeto:");

        tfNomeDoProjeto.addActionListener(this::tfNomeDoProjetoActionPerformed);

        tfTipodeProjeto.addActionListener(this::tfTipodeProjetoActionPerformed);

        jLabel5.setText("Data de inicio");

        tfDataFinal.setText("Data final");

        tfStatus.setText("Status:");

        BotoesDeStatus.add(rbNaoIniciado);
        rbNaoIniciado.setText("Não Iniciado");
        rbNaoIniciado.addActionListener(this::rbNaoIniciadoActionPerformed);

        BotoesDeStatus.add(rbEmAndamento);
        rbEmAndamento.setText("Em andamento");

        BotoesDeStatus.add(dbFinalizado);
        dbFinalizado.setText("Finalizado");

        BotoesDeStatus.add(dbCancelado);
        dbCancelado.setText("Cancelado");

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(this::btSalvarActionPerformed);

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(this::btExcluirActionPerformed);

        Relatorio.setText("Relatorio");
        Relatorio.addActionListener(this::RelatorioActionPerformed);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setText("Cadastro de Projetos.");

        jTableProjetos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableProjetos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProjetosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProjetos);

        jLabel1.setText("Filtrar por: ");

        cbFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Empresa Responsavel", "Tipo de Projeto", "Status" }));
        cbFiltros.setToolTipText("");
        cbFiltros.addActionListener(this::cbFiltrosActionPerformed);

        btFiltrar.setText("Filtrar");
        btFiltrar.addActionListener(this::btFiltrarActionPerformed);

        btMostrar.setText("Mostrar tudo");
        btMostrar.addActionListener(this::btMostrarActionPerformed);

        tfDatafinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        tfDatadeInicio1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        tfDatadeInicio1.addActionListener(this::tfDatadeInicio1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfStatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbNaoIniciado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbEmAndamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dbFinalizado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dbCancelado))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfEmpresaResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfNomeDoProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfDatadeInicio1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfDataFinal)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTipodeProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDatafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Relatorio))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMostrar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(173, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addGap(172, 172, 172)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(tfEmpresaResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(tfTipodeProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfNomeDoProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(tfDataFinal)
                            .addComponent(tfDatafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDatadeInicio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfStatus)
                            .addComponent(rbNaoIniciado)
                            .addComponent(rbEmAndamento)
                            .addComponent(dbFinalizado)
                            .addComponent(dbCancelado))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btExcluir)
                    .addComponent(Relatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btFiltrar)
                        .addComponent(btMostrar)))
                .addContainerGap(194, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel6)
                    .addContainerGap(775, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIDActionPerformed

    private void tfEmpresaResponsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmpresaResponsavelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmpresaResponsavelActionPerformed

    private void tfNomeDoProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeDoProjetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeDoProjetoActionPerformed

    private void tfTipodeProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTipodeProjetoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTipodeProjetoActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {
          // Validação dos campos
    if (tfEmpresaResponsavel.getText().equals("")
            || tfTipodeProjeto.getText().equals("")
            || tfNomeDoProjeto.getText().equals("")
            || tfDatadeInicio.getText().equals("")
            || tfDatafinal.getText().equals("")) {

        JOptionPane.showMessageDialog(
                null,
                "Preencha todos os campos",
                "AVISO",
                JOptionPane.WARNING_MESSAGE
        );

    } else {

        try {

                // Formato brasileiro
                DateTimeFormatter formato =
                        DateTimeFormatter.ofPattern("dd/MM/yyyy");

                // Converte texto para data
                LocalDate dataInicio =
                        LocalDate.parse(tfDatadeInicio.getText(), formato);

                LocalDate dataFinal =
                        LocalDate.parse(tfDatafinal.getText(), formato);

                // Verifica se data inicial é maior
                if (dataInicio.isAfter(dataFinal)) {

                    JOptionPane.showMessageDialog(
                            null,
                            "A data de início não pode ser maior que a data final!"
                    );

                    return;
                }

                projetos = new Projetos();

                projetos.setEmpresaResponsavel(
                        tfEmpresaResponsavel.getText()
                );

                projetos.setTipoDeProjeto(
                        tfTipodeProjeto.getText()
                );

                projetos.setNomeDoProjeto(
                        tfNomeDoProjeto.getText()
                );

                // Salva no formato SQL yyyy-MM-dd
                projetos.setDataDeInicio(
                        dataInicio.toString()
                );

                projetos.setDataDeFinalizacao(
                        dataFinal.toString()
                );

                // STATUS
                if (rbNaoIniciado.isSelected()) {
                    projetos.setStatus("Não iniciado");
                }

                if (rbEmAndamento.isSelected()) {
                    projetos.setStatus("Em andamento");
                }

                if (dbFinalizado.isSelected()) {
                    projetos.setStatus("Finalizado");
                }

                if (dbCancelado.isSelected()) {
                    projetos.setStatus("Cancelado");
                }

                // INSERT OU UPDATE
                if (tfID.getText().equals("")) {

                    daoProjetos.inserir(projetos);

                } else {

                    projetos.setId(
                            Integer.parseInt(tfID.getText())
                    );

                    daoProjetos.alterar(projetos);
                }

                limparCampos();

                atualizarTabelaProjetos();

                JOptionPane.showMessageDialog(
                        null,
                        "Projeto salvo com sucesso!"
                );

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Data inválida! Use o formato dd/MM/yyyy");
            }
        }
    }

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja excluir este projeto?", "Excluir Projeto", JOptionPane.YES_NO_OPTION);

        if (confirma == 0) {

            daoProjetos.excluir(Integer.parseInt(tfID.getText()));

            limparCampos();

            atualizarTabelaProjetos();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void rbNaoIniciadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNaoIniciadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNaoIniciadoActionPerformed

    private void jTableProjetosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProjetosMouseClicked
        // Pega o ID
        tfID.setText(
                jTableProjetos.getValueAt(
                        jTableProjetos.getSelectedRow(),
                        0
                ).toString()
        );

        // Empresa
        tfEmpresaResponsavel.setText(
                jTableProjetos.getValueAt(
                        jTableProjetos.getSelectedRow(),
                        1
                ).toString()
        );

        // Tipo
        tfTipodeProjeto.setText(
                jTableProjetos.getValueAt(
                        jTableProjetos.getSelectedRow(),
                        2
                ).toString()
        );

        // Nome
        tfNomeDoProjeto.setText(
                jTableProjetos.getValueAt(
                        jTableProjetos.getSelectedRow(),
                        3
                ).toString()
        );

        // Data início
        tfDatafinal.setText(
                jTableProjetos.getValueAt(
                        jTableProjetos.getSelectedRow(),
                        4
                ).toString()
        );

        // Data final
        tfDatafinal.setText(
                jTableProjetos.getValueAt(
                        jTableProjetos.getSelectedRow(),
                        5
                ).toString()
        );

        // Status
        String status = jTableProjetos.getValueAt(
                jTableProjetos.getSelectedRow(),
                6
        ).toString();

        if (status.equals("Não iniciado")) {
            rbNaoIniciado.setSelected(true);
        }

        if (status.equals("Em andamento")) {
            rbEmAndamento.setSelected(true);
        }

        if (status.equals("Finalizado")) {
            dbFinalizado.setSelected(true);
        }

        if (status.equals("Cancelado")) {
            dbCancelado.setSelected(true);
        }

        btExcluir.setEnabled(true);
    }//GEN-LAST:event_jTableProjetosMouseClicked

    private void RelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioActionPerformed
        try {
            // Busca todos os projetos do banco
            ArrayList<Projetos> lista = daoProjetos.buscarTodos();

            // Cria arquivo CSV
            FileWriter arquivo = new FileWriter("relatorio_projetos.csv");
            PrintWriter escrever = new PrintWriter(arquivo);

            // Cabeçalho do CSV
            escrever.println("ID;EMPRESA;TIPO;NOME;DATA_INICIO;DATA_FINAL;STATUS");

            // Percorre todos os projetos
            for (Projetos p : lista) {
                escrever.println(
                        p.getId() + ";"
                        + p.getEmpresaResponsavel() + ";"
                        + p.getTipoDeProjeto() + ";"
                        + p.getNomeDoProjeto() + ";"
                        + p.getDataDeInicio() + ";"
                        + p.getDataDeFinalizacao() + ";"
                        + p.getStatus()
                );
            }
            
            escrever.close();
            JOptionPane.showMessageDialog(null,"Relatório CSV exportado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Erro ao gerar relatório: "+ e.getMessage());
        }
    }//GEN-LAST:event_RelatorioActionPerformed

    private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed
        String campo = "";

        // Descobre qual opção foi escolhida
        if (cbFiltros.getSelectedItem().equals("Empresa Responsavel")) {
            campo = "empresaResponsavel";
        }
        
        if (cbFiltros.getSelectedItem().equals("Tipo de Projeto")) {
            campo = "tipoDeProjeto";
        }
        
        if (cbFiltros.getSelectedItem().equals("Status")) {
            campo = "status";
        }

        // Atualiza tabela com filtro
        jTableProjetos.setModel(new ProjetosTableModel(daoProjetos.buscarTodosFiltro(campo,tfFiltro.getText())));
   
    }//GEN-LAST:event_btFiltrarActionPerformed

    private void btMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostrarActionPerformed
        tfFiltro.setText("");
        atualizarTabelaProjetos();
    }//GEN-LAST:event_btMostrarActionPerformed

    private void cbFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFiltrosActionPerformed

    private void tfDatadeInicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDatadeInicio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDatadeInicio1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BotoesDeStatus;
    private javax.swing.JButton Relatorio;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFiltrar;
    private javax.swing.JButton btMostrar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbFiltros;
    private javax.swing.JRadioButton dbCancelado;
    private javax.swing.JRadioButton dbFinalizado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTableProjetos;
    private javax.swing.JRadioButton rbEmAndamento;
    private javax.swing.JRadioButton rbNaoIniciado;
    private javax.swing.JLabel tfDataFinal;
    private javax.swing.JFormattedTextField tfDatadeInicio1;
    private javax.swing.JFormattedTextField tfDatafinal;
    private javax.swing.JTextField tfEmpresaResponsavel;
    private javax.swing.JTextField tfFiltro;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfNomeDoProjeto;
    private javax.swing.JLabel tfStatus;
    private javax.swing.JTextField tfTipodeProjeto;
    // End of variables declaration//GEN-END:variables
}
