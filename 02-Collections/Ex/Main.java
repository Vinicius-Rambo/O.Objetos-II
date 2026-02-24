
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        String opc; 
        do { 
            System.out.println("\n====== Menu ========"); 
            System.out.println("[1] - Cadastrar cliente");
            System.out.println("[2] - Listar clientes"); 
            System.out.println("[3] - Listar orçamento para um cliente");
            System.out.println("[0] - Sair");
            System.out.print("Escolha sua opção: ");
            opc = teclado.readLine();

            switch (opc){
                case "1": cadastrarArquivo(); Break;
                case "2": listarClientes(); Break;
                case "3": listarOrcamento(); Break;
                case "0": System.out.println("Bye ....");
                default: System.out.println("Opção invalida!"); break;
            }

        } while (!opc.equals("0"));
    }
}
