package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.DaoProjetos;
import model.Projetos;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ProjetosView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ProjetosView.class.getName());
    
    Projetos projetos; // Objeto da classe Projetos
    DaoProjetos daoProjetos; // Objeto DAO responsável pelas operações no banco
    
    
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
        tfDatadeInicio.setText("");
        tfDatafinal.setText("");

        BotoesDeStatus.clearSelection();
        btExcluir.setEnabled(false);
    } 

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotoesDeStatus = new javax.swing.ButtonGroup();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfEmpresaResponsavel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfTipodeProjeto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfNomeDoProjeto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfDatadeInicio = new javax.swing.JFormattedTextField();
        tfDataFinal = new javax.swing.JLabel();
        tfDatafinal = new javax.swing.JFormattedTextField();
        tfStatus1 = new javax.swing.JLabel();
        rbNaoIniciado = new javax.swing.JRadioButton();
        rbEmAndamento = new javax.swing.JRadioButton();
        dbFinalizado = new javax.swing.JRadioButton();
        dbCancelado = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        Relatorio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProjetos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbFiltros = new javax.swing.JComboBox<>();
        tfFiltro = new javax.swing.JTextField();
        btFiltrar = new javax.swing.JButton();
        btMostrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel6.setText("Cadastro de Projetos.");

        jLabel2.setText("ID: ");

        tfID.setEditable(false);
        tfID.addActionListener(this::tfIDActionPerformed);

        jLabel3.setText("Empresa Responsavel: ");

        tfEmpresaResponsavel.addActionListener(this::tfEmpresaResponsavelActionPerformed);

        jLabel4.setText("Tipo de Projeto:");

        tfTipodeProjeto.addActionListener(this::tfTipodeProjetoActionPerformed);

        jLabel10.setText("Nome do projeto:");

        tfNomeDoProjeto.addActionListener(this::tfNomeDoProjetoActionPerformed);

        jLabel5.setText("Data de inicio");

        tfDatadeInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        tfDatadeInicio.addActionListener(this::tfDatadeInicioActionPerformed);

        tfDataFinal.setText("Data final");

        tfDatafinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        tfStatus1.setText("Status:");

        BotoesDeStatus.add(rbNaoIniciado);
        rbNaoIniciado.setText("Não Iniciado");
        rbNaoIniciado.addActionListener(this::rbNaoIniciadoActionPerformed);

        BotoesDeStatus.add(rbEmAndamento);
        rbEmAndamento.setText("Em andamento");

        BotoesDeStatus.add(dbFinalizado);
        dbFinalizado.setText("Finalizado");

        BotoesDeStatus.add(dbCancelado);
        dbCancelado.setText("Cancelado");
        dbCancelado.addActionListener(this::dbCanceladoActionPerformed);

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(this::btSalvarActionPerformed);

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(this::btExcluirActionPerformed);

        Relatorio.setText("Relatorio");
        Relatorio.addActionListener(this::RelatorioActionPerformed);

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

        tfFiltro.addActionListener(this::tfFiltroActionPerformed);

        btFiltrar.setText("Filtrar");
        btFiltrar.addActionListener(this::btFiltrarActionPerformed);

        btMostrar.setText("Mostrar tudo");
        btMostrar.addActionListener(this::btMostrarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btSalvar)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2)
                                .addGap(193, 193, 193))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfStatus1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbNaoIniciado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbEmAndamento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dbFinalizado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dbCancelado))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfEmpresaResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tfTipodeProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addComponent(Relatorio))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btFiltrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMostrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNomeDoProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDatadeInicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDataFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDatafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(304, 304, 304)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(434, 434, 434))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(tfDatadeInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDataFinal)
                    .addComponent(tfDatafinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfStatus1)
                    .addComponent(rbNaoIniciado)
                    .addComponent(rbEmAndamento)
                    .addComponent(dbFinalizado)
                    .addComponent(dbCancelado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSalvar)
                        .addComponent(btExcluir)
                        .addComponent(Relatorio)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btFiltrar)
                    .addComponent(btMostrar))
                .addContainerGap(202, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
              // Validação dos campos
        if (tfEmpresaResponsavel.getText().equals("")
                || tfTipodeProjeto.getText().equals("")
                || tfNomeDoProjeto.getText().equals("")
                || tfDatadeInicio.getText().equals("")
                || tfDatafinal.getText().equals("")) {

            JOptionPane.showMessageDialog(null,"Preencha todos os campos","AVISO",JOptionPane.WARNING_MESSAGE);
        } else {
            try {

                    // Formato brasileiro
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    // Converte texto para data
                    LocalDate dataInicio = LocalDate.parse(tfDatadeInicio.getText(), formato);
                    LocalDate dataFinal = LocalDate.parse(tfDatafinal.getText(), formato);

                    if (dataInicio.isAfter(dataFinal)) { // Verifica se data inicial é maior
                        JOptionPane.showMessageDialog(null,"A data de início não pode ser maior que a data final!");
                        return;
                    }

                    projetos = new Projetos();

                    projetos.setEmpresaResponsavel(tfEmpresaResponsavel.getText());
                    projetos.setTipoDeProjeto(tfTipodeProjeto.getText());
                    projetos.setNomeDoProjeto(tfNomeDoProjeto.getText());
                    projetos.setDataDeInicio(dataInicio.toString()); // Salva no formato SQL yyyy-MM-dd
                    projetos.setDataDeFinalizacao(dataFinal.toString()); //Também salva no formato SQL yyyy-MM-dd

                    // STATUS
                    if (rbNaoIniciado.isSelected()) {
                        projetos.setStatus("Não iniciado");
                    }

                    else if (rbEmAndamento.isSelected()) {
                        projetos.setStatus("Em andamento");
                    }

                    else if (dbFinalizado.isSelected()) {
                        projetos.setStatus("Finalizado");
                    }

                    else if (dbCancelado.isSelected()) {
                        projetos.setStatus("Cancelado");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Sem opções selecionadas");
                    }
                    
                    // INSERT OU UPDATE
                    if (tfID.getText().equals("")) { //Se ID vazio vai inserir
                        daoProjetos.inserir(projetos);

                    } else {

                        projetos.setId(Integer.parseInt(tfID.getText()));
                        daoProjetos.alterar(projetos);
                    }

                    limparCampos();
                    atualizarTabelaProjetos();
                    JOptionPane.showMessageDialog(null,"Projeto salvo com sucesso!");

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
    }

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
    }

    private void jTableProjetosMouseClicked(java.awt.event.MouseEvent evt) {//Caso o a tabela seja clicada.
        
        tfID.setText(jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(),0).toString());// Pega o ID
        tfEmpresaResponsavel.setText(jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(),1).toString()); // Empresa
        tfTipodeProjeto.setText(jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(),2).toString()); // Tipo
        tfNomeDoProjeto.setText(jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(),3).toString()); // Nome
        tfDatadeInicio.setText(jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(),4).toString()); // Data início
        tfDatafinal.setText(jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(),5).toString()); // Data final

        // Status
        String status = jTableProjetos.getValueAt(jTableProjetos.getSelectedRow(),6).toString();

        if (status.equals("Não iniciado")) {
            rbNaoIniciado.setSelected(true);
        }

        else if (status.equals("Em andamento")) {
            rbEmAndamento.setSelected(true);
        }

        else if (status.equals("Finalizado")) {
            dbFinalizado.setSelected(true);
        }

        else if (status.equals("Cancelado")) {
            dbCancelado.setSelected(true);
        }
        else {
            JOptionPane.showMessageDialog(null,"Opção invalida.");
        }
        
        
        btExcluir.setEnabled(true); //Possibilidade de excluir apenas se já tiver selecionado
    }

    private void btFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFiltrarActionPerformed
        String campo = "";

        // Descobre qual opção foi escolhida
        if (cbFiltros.getSelectedItem().equals("Empresa Responsavel")) {
            campo = "empresaResponsavel";

        }else if(cbFiltros.getSelectedItem().equals("Tipo de Projeto")) {
            campo = "tipoDeProjeto";
            
        } else if (cbFiltros.getSelectedItem().equals("Status")) {
            campo = "status";
            
        } else {
            JOptionPane.showMessageDialog(null,"Erro nos filtros.");
        }

        // Atualiza tabela com filtro
        jTableProjetos.setModel(new ProjetosTableModel(daoProjetos.buscarTodosFiltro(campo,tfFiltro.getText())));

    }

    private void btMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMostrarActionPerformed
        tfFiltro.setText("");
        atualizarTabelaProjetos();
    }

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ProjetosView().setVisible(true));
    }

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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableProjetos;
    private javax.swing.JRadioButton rbEmAndamento;
    private javax.swing.JRadioButton rbNaoIniciado;
    private javax.swing.JLabel tfDataFinal;
    private javax.swing.JFormattedTextField tfDatadeInicio;
    private javax.swing.JFormattedTextField tfDatafinal;
    private javax.swing.JTextField tfEmpresaResponsavel;
    private javax.swing.JTextField tfFiltro;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfNomeDoProjeto;
    private javax.swing.JLabel tfStatus1;
    private javax.swing.JTextField tfTipodeProjeto;
    // End of variables declaration//GEN-END:variables
}
