import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        Opcoes opcoes = new Opcoes();

        String opc;

        do { 
            System.out.println("\n====== MENU ========");
            System.err.println("[1] - Cadastre aeroportos  ");
            System.err.println("[2] - Listar os aeroportos ");
            System.err.println("[3] - Remova um aeroporto  ");
            System.err.println("[4] - Relatorio por sigla  ");
            System.err.println("[0] - Sair");
            System.out.print("Escolha sua opção: ");

            opc = teclado.readLine();

            switch (opc){
                case "1":
                    limparTela();
                    opcoes.cadastrarAeroportos(teclado);
                    break;

                case "2": 
                    limparTela();
                    opcoes.listarAeroportos();
                    break;
                
                case "3":
                    limparTela();
                    opcoes.removerAeroportos(teclado);
                    break;
                
                case "4":
                    limparTela();
                    opcoes.consultarSigla(teclado);
                    break;
                
                case "0":
                    System.out.println("Encerrando...");
                    break;
                
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while (!opc.equals("0"));
    }

    public static void limparTela() throws Exception {
        new ProcessBuilder("clear").inheritIO().start().waitFor();
    }
}
