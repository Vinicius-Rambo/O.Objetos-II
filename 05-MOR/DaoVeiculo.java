
import java.sql.Connection;
import java.sql.Statement;

public class DaoVeiculo {
    private Connection conn;
    private Statement st;

    private void conectar(){
        try {
            this.conn = GerenciadorConexao.pegarConexao(); //Puxa a conexão
            this.st = conn.createStatement(); //Statement: objeto que intermedia a conversa com o banco

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

    public boolean inserir(Veiculo v){
        boolean resultado = false;

        try {
            this.conectar();
            String comando = "INSERT INTO tbveiculos VALUES (" + "Null, '" + v.getMarca() +"', '" + v.getModelo() + "', '" + v.getChassi() + "', " + v.getAno() + ");";

            //System.out.println(comando);

            st.executeUpdate(comando);
            resultado = true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir registro: " + e.getMessage());
        
        } finally{
            this.desconectar();
        }


        return  resultado;
    }

}
