package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//Imports por ter pastas
import model.Vendedor;
import model.Cargo;
import util.GerenciadorConexao;

public class DaoVendedor {
    private Connection conn;
    private Statement st;

    private void conectar(){
        try {
            this.conn = GerenciadorConexao.pegarConexao();
            this.st = conn.createStatement();
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void desconectar(){
        try {
            this.st.close();
            this.conn.close();
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public boolean inserir(Vendedor v){
        boolean resultado = false;

        try {
            this.conectar();

            String comando = "INSERT INTO tbvendedores VALUES ("
                    + "NULL, '"
                    + v.getNome() + "', '"
                    + v.getContato() + "', '"
                    + v.getEmail() + "', '"
                    + v.getCpf() + "', '"
                    + v.getNumCracha() + "', "
                    + v.getAnoAdmissao() + ", '"
                    + v.getCargo().name() + "');"; //Usamos o cargo como se fosse uma String normal.

            st.executeUpdate(comando);
            resultado = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return resultado;
    }

    public ArrayList<Vendedor> buscarTodos(){
        ArrayList<Vendedor> lista = new ArrayList<>();

        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tbvendedores ORDER BY codigo"); //Ordenado pelos ID`s

            while(rs.next()){
                Vendedor v = new Vendedor();

                v.setCodigo(rs.getInt("codigo"));
                v.setNome(rs.getString("nome"));
                v.setContato(rs.getString("contato"));
                v.setEmail(rs.getString("email"));
                v.setCpf(rs.getString("cpf"));
                v.setNumCracha(rs.getString("numCracha"));
                v.setAnoAdmissao(rs.getInt("anoAdmissao"));
                v.setCargo(Cargo.valueOf(rs.getString("cargo")));

                lista.add(v); //Adiciona a lista o objeto, com todos os valores. 
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return lista;
    }

    public Vendedor consultar(int cod){
        Vendedor v = null;

        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM tbvendedores WHERE codigo = " + cod);

            while(rs.next()){
                v = new Vendedor();

                v.setCodigo(rs.getInt("codigo"));
                v.setNome(rs.getString("nome"));
                v.setContato(rs.getString("contato"));
                v.setEmail(rs.getString("email"));
                v.setCpf(rs.getString("cpf"));
                v.setNumCracha(rs.getString("numCracha"));
                v.setAnoAdmissao(rs.getInt("anoAdmissao"));
                v.setCargo(Cargo.valueOf(rs.getString("cargo"))); 
            }

        } catch (Exception e) {
            System.out.println("Erro ao consultar: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return v;
    }

    public int alterar(Vendedor v){
        int qtde = 0;

        try {
            this.conectar();

            String comando = "UPDATE tbvendedores SET "
                    + "nome = '" + v.getNome() + "', "
                    + "contato = '" + v.getContato() + "', "
                    + "email = '" + v.getEmail() + "', "
                    + "cpf = '" + v.getCpf() + "', "
                    + "numCracha = '" + v.getNumCracha() + "', "
                    + "anoAdmissao = " + v.getAnoAdmissao() + ", "
                    + "cargo = '" + v.getCargo().name() + "' "
                    + "WHERE codigo = " + v.getCodigo() + ";";

            st.executeUpdate(comando);
            qtde = st.getUpdateCount();

        } catch (Exception e) {
            System.out.println("Erro ao alterar: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return qtde;
    }

    public int excluir(int cod){
        int qtde = 0;

        try {
            this.conectar();

            String comando = "DELETE FROM tbvendedores WHERE codigo = " + cod;

            qtde = st.executeUpdate(comando);

        } catch (Exception e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            this.desconectar();
        }

        return qtde;
    }
}
