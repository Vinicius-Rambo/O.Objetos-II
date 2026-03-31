
import java.sql.Connection;
import java.sql.Statement;


public class DaoVendedor {
    private Connection conn;
    private Statement st;

    private void conectar(){
        try {
            this.conn = GerenciadorConexao.pegarConexao();
            this.st = conn.createStatement();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void desconectar(){
        try{
            this.st.close();
            this.conn.close();
        } catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public boolean inserir(Veiculo v){
        boolean resultado = false;

        try {
            
        } catch (Exception e) {
        
        }finally{
            this.desconectar();
        }
    }

}
