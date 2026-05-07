package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoProjetos {

    // Variáveis de conexão com o banco
    private Connection conn;
    private Statement st;

    
    private void conectar() {

        try {

       
            this.conn = GerenciadorConexao.pegarConexao();
            this.st = conn.createStatement();

        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }
    
    private void desconectar() {
        try {

            this.st.close();
            this.conn.close();

        } catch (Exception e) {

            System.out.println("Erro ao desconectar: " + e.getMessage());
        }
    }

    // INSERT -> Cadastra um novo projeto
    public boolean inserir(Projetos p) {

        boolean resultado = false;

        try {

            this.conectar();

            // Comando SQL INSERT.
            String comando = "INSERT INTO tbprojetos VALUES ("
                    + "null, '"
                    + p.getEmpresaResponsavel() + "', '"
                    + p.getTipoDeProjeto() + "', '"
                    + p.getNomeDoProjeto() + "', '"
                    + p.getDataDeInicio() + "', '"
                    + p.getDataDeFinalizacao() + "', '"
                    + p.getStatus() + "');";

            // Executa o INSERT
            st.executeUpdate(comando);

            resultado = true;

        } catch (Exception e) {

            System.out.println("Erro ao inserir projeto: " + e.getMessage());

        } finally {

            this.desconectar();
        }

        return resultado;
    }

    // SELECT
    public ArrayList<Projetos> buscarTodos() {
        ArrayList<Projetos> resultados = new ArrayList<>();        

        try {
            this.conectar();
            ResultSet rs = st.executeQuery(
                    "SELECT * FROM tbprojetos ORDER BY nomeDoProjeto"
            );


            while (rs.next()) {
                Projetos p = new Projetos();

                // Preenche os atributos com os dados do banco
                p.setId(rs.getInt("id"));
                p.setEmpresaResponsavel(rs.getString("empresaResponsavel"));
                p.setTipoDeProjeto(rs.getString("tipoDeProjeto"));
                p.setNomeDoProjeto(rs.getString("nomeDoProjeto"));
                p.setDataDeInicio(rs.getString("dataDeInicio"));
                p.setDataDeFinalizacao(rs.getString("dataDeFinalizacao"));
                p.setStatus(rs.getString("status"));

                resultados.add(p); // Adiciona no ArrayList
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar projetos: " + e.getMessage());

        } finally {
            this.desconectar();
        }
        
        return resultados;
    }

    // SELECT COM FILTRO
   public ArrayList<Projetos> buscarTodosFiltro(String campo, String filtro){

    ArrayList<Projetos> resultados = new ArrayList<>();

    try {

        conectar();
        String sql =
                "SELECT * FROM tbprojetos "
                + "WHERE " + campo
                + " LIKE '%" + filtro + "%'";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {

            Projetos p = new Projetos();

            p.setId(rs.getInt("id"));
            p.setEmpresaResponsavel(rs.getString("empresaResponsavel"));
            p.setTipoDeProjeto(rs.getString("tipoDeProjeto"));
            p.setNomeDoProjeto(rs.getString("nomeDoProjeto"));
            p.setDataDeInicio(rs.getString("dataDeInicio"));
            p.setDataDeFinalizacao(rs.getString("dataDeFinalizacao"));
            p.setStatus(rs.getString("status"));
            resultados.add(p);
        }

    } catch (Exception e) {

        System.out.println("Erro ao buscar filtro: "+ e.getMessage());

    } finally {
        desconectar();
    }

    return resultados;
}

    // DELETE no banco de dados
    public int excluir(int id) {

        int qtde = 0;

        try {

            this.conectar();
            String comando = "DELETE FROM tbprojetos WHERE id = " + id + ";";
            st.execute(comando);

            // Quantidade de linhas afetadas
            qtde = st.getUpdateCount();

        } catch (Exception e) {
            System.out.println("Erro ao excluir projeto: " + e.getMessage());

        } finally {
            this.desconectar();
        }

        return qtde;
    }

    // UPDATE no banco de dados
    public int alterar(Projetos p) {

        int qtde = 0;
        try {
            this.conectar();            
            String comando = "UPDATE tbprojetos SET "
                    + "empresaResponsavel = '" + p.getEmpresaResponsavel() + "', "
                    + "tipoDeProjeto = '" + p.getTipoDeProjeto() + "', "
                    + "nomeDoProjeto = '" + p.getNomeDoProjeto() + "', "
                    + "dataDeInicio = '" + p.getDataDeInicio() + "', "
                    + "dataDeFinalizacao = '" + p.getDataDeFinalizacao() + "', "
                    + "status = '" + p.getStatus() + "' "
                    + "WHERE id = " + p.getId() + ";";
            
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();

        } catch (Exception e) {
            System.out.println("Erro ao alterar projeto: " + e.getMessage());

        } finally {
            this.desconectar();
        }

        return qtde;
    }
}