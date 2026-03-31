import java.util.Scanner;

public class Locadora {
    public static void main(String[] args) {
        Locadora loc = new Locadora();
        loc.menuPrincipal();
    }    

    private void menuPrincipal(){ 
        try(Scanner scanner = new Scanner(System.in)){ //try-with-resources: Fecha o Scanner ao final do processo;
                int opcao = 1;
            do{
                System.out.println("\n - - - Menu Principal - - -");
                System.out.println("[1] - Gerenciar Veiculos  ");
                System.out.println("[2] - Gerenciar Vendedor  ");
                System.out.println("[0] - Sair");
                System.out.print("Escolha uma das opcões: ");

                try {
                    opcao = Integer.parseInt(scanner.nextLine());

                } catch (Exception e) {
                    System.out.println("Informe um valor inteiro");
                }

                switch (opcao){
                   
                    case 1: 
                        GerenciadorVeiculo gv = new GerenciadorVeiculo();
                        gv.menu();
                        break;

                    case 2: 
                        GerenciadorVendedor gv = new GerenciadorVendedor();
                        gv.menu();
                        break;

                    case 0: 
                        System.out.println("Bye ....");
                        break;

                    default: 
                        System.out.println("ERRO: Resposta invalida");
                        break;
                }

            }while (opcao != 0);
        }
    }
}
