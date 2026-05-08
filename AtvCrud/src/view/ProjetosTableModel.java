package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Projetos;

public class ProjetosTableModel extends AbstractTableModel {

    public static final int COL_CODIGO = 0;
    public static final int COL_EMPRESA = 1;
    public static final int COL_TIPO = 2;
    public static final int COL_NOME = 3;
    public static final int COL_DATAINICIO = 4;
    public static final int COL_DATAFINAL = 5;
    public static final int COL_STATUS = 6;

    public ArrayList<Projetos> listaProjetos;

    public ProjetosTableModel(ArrayList<Projetos> projetos) {

        this.listaProjetos = projetos;
    }

    @Override
    public int getColumnCount() {

        return 7;
    }

    @Override
    public int getRowCount() {

        return listaProjetos.size();
    }

    @Override
    public String getColumnName(int coluna) {

        String nome = "";

        if (coluna == COL_CODIGO) {
            nome = "Código";
        }

        if (coluna == COL_EMPRESA) {
            nome = "Empresa";
        }

        if (coluna == COL_TIPO) {
            nome = "Tipo";
        }

        if (coluna == COL_NOME) {
            nome = "Nome";
        }

        if (coluna == COL_DATAINICIO) {
            nome = "Data Início";
        }

        if (coluna == COL_DATAFINAL) {
            nome = "Data Final";
        }

        if (coluna == COL_STATUS) {
            nome = "Status";
        }

        return nome;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        Projetos p = listaProjetos.get(linha);

        Object conteudo = "";

        if (coluna == COL_CODIGO) {
            conteudo = p.getId();
        }

        if (coluna == COL_EMPRESA) {
            conteudo = p.getEmpresaResponsavel();
        }

        if (coluna == COL_TIPO) {
            conteudo = p.getTipoDeProjeto();
        }

        if (coluna == COL_NOME) {
            conteudo = p.getNomeDoProjeto();
        }

        if (coluna == COL_DATAINICIO) {
            conteudo = p.getDataDeInicio();
        }

        if (coluna == COL_DATAFINAL) {
            conteudo = p.getDataDeFinalizacao();
        }

        if (coluna == COL_STATUS) {
            conteudo = p.getStatus();
        }

        return conteudo;
    }
}