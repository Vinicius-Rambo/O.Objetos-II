import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorVeiculo{

    Scanner scanner;
    DaoVeiculo daoVeiculo;

    public GerenciadorVeiculo(){
        scanner = new Scanner(System.in);
        daoVeiculo = new DaoVeiculo();
    }

    public void menu(){
        int opcao = 1;
        do{
            System.out.println("\n - - - Menu - - -");
            System.out.println("[1] - Cadastrar ");
            System.out.println("[2] - Consultar  ");
            System.out.println("[3] - Alterar ");
            System.out.println("[4] - Excluir ");
            System.out.println("[5] - Listar todos");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma das opcões: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

            } catch (Exception e) {
                System.out.println("Informe um valor inteiro");
            }

            switch (opcao){
                case 1: 
                    this.cadastrar();
                    break;

                case 2: 
                    //this.consultar();
                    break;

                case 3: 
                    //this.alterar();
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
        }while (opcao != 0);
    }

    private void cadastrar(){

        Veiculo v = new Veiculo(); //Instanciar o objeto
        
        //Popular
        System.out.println("- - Cadastro de Veiculos - -\n"); 
        System.out.print("marca: ");
        v.setMarca(scanner.nextLine());

        System.out.print("modelo: ");
        v.setModelo(scanner.nextLine());

        System.out.print("chassi: ");
        v.setChassi(scanner.nextLine());

        System.out.print("Ano: ");
        v.setAno(Integer.parseInt(scanner.nextLine()));

        //inserir no banco
        String resultado = daoVeiculo.inserir(v) ? "Inserido com sucesso": "Erro: Falaha ao inserir no banco"; //Usando metodo Ternario
        System.out.println(resultado);

    }

    private void excluir(){
        
        
        System.out.println("- - Exclusão de Veiculos - -\n"); 
        System.out.print("Código: ");
        int codigo = Integer.parseInt(scanner.nextLine());

        int qtde = daoVeiculo.excluir(codigo);

        if(qtde > 0){ 
            System.out.println("Excluido com sucesso!");
        }else{
            System.out.println("ERRO: Exclusão falha.");
        }

    }

    


    private void listarTodos(){
        ArrayList<Veiculo> veiculos = daoVeiculo.buscarTodos();
        System.out.println("Veiculos cadastrados: ");
        for(Veiculo v : veiculos){ //Foreach do java
            System.out.printf("Código: %-10s | Marca: %-15s | Modelo: %-15s | Chassi: %-20s | Ano: %-5d%n", //Printf pela formatação.
                v.getCodigo(),
                v.getMarca(),
                v.getModelo(),
                v.getChassi(),
                v.getAno()
            );
        }
    }



}
