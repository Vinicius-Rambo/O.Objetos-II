import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        Assistencia assistencia = new Assistencia();

        String opc;

        do {
            System.out.println("\n====== MENU ========");
            System.out.println("[1] - Cadastrar cliente");
            System.out.println("[2] - Listar clientes");
            System.out.println("[3] - Cadastrar orçamento");
            System.out.println("[4] - Listar orçamentos");
            System.out.println("[0] - Sair");
            System.out.print("Escolha sua opção: ");

            opc = teclado.readLine();

            switch (opc) {
                case "1": 
                    limparTela();
                    assistencia.cadastrarCliente(teclado); 
                    break;

                case "2": 
                    limparTela();
                    assistencia.listarClientes();
                    break;

                case "3": 
                    limparTela();
                    assistencia.cadastrarOrcamento(teclado); 
                    break;

                case "4": 
                    limparTela();
                    assistencia.listarOrcamentos(teclado); 
                    break;

                case "0": 
                    System.out.println("Encerrando..."); 
                    break;

                default: 
                    System.out.println("Opção inválida!");
            }
        } while (!opc.equals("0")); //Usuario digitou 0 para sair.
    }

    public static void limparTela() throws Exception {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
    }
}
