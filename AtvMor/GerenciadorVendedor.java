import java.util.Scanner;

public class GerenciadorVendedor{

    Scanner scanner;
    DaoVendedor DaoVendedor;

    public GerenciadorVendedor(){
        scanner = new Scanner(System.in);
        daoVendedor = new DaoVendedor();
    }

    public void menu(){
        int opcao = 1;
        do { 
            System.out.println("\n - - - Menu - - -");
            System.out.println("[1] - Cadastrar ");
            System.out.println("[2] - Consultar  ");
            System.out.println("[3] - Alterar ");
            System.out.println("[4] - Excluir ");
            System.out.println("[5] - Listar todos");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma das opcões: ");

            try{
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e){
                System.out.println("ERROR: informe um valor inteiro");
            }

            switch (opcao){
                case 1: 
                    this.cadastrar();
                    break;

                case 2: 
                    this.consultar();
                    break;

                case 3: 
                    this.alterar();
                    break;

                case 4: 
                    this.excluir();
                    break;

                case 5: 
                    this.listarTodos();
                    break;

                case 0: 
                    System.out.println("Bye ....");
                    break;

                default: 
                    System.out.println("ERRO: Resposta invalida");
                    break;
            }
        } while (opcao != 0);
    }

    private void cadastrar(){} 
    private void consultar(){} 
    private void alterar(){} 
    private void excluir(){} 
    private void listarTodos(){} 

}