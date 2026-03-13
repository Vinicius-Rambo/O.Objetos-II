import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Aniversario{
        public static void main(String[] args) throws exception{
    
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in)); //Buffered Reader para digitar.
        Aniversario opcoes = new Aniversario(); 

        String opc;

        do { 
            System.out.println("\n====== MENU ========");
            System.err.println("[1] - Adicionar aniversario ");
            System.err.println("[2] - Listar datas ");
            System.err.println("[3] - Consultar datas  ");
            System.err.println("[0] - Sair");
            System.out.print("Escolha sua opção: ");

            opc = teclado.readLine();

            switch (opc){
                case "1":
                    limparTela();
                    opcoes.adicionarAniversario(teclado);
                    break;

                case "2": 
                    limparTela();
                    opcoes.listarDatas();
                    break;
                
                case "3":
                    limparTela();
                    opcoes.consultarDatas(teclado);
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


