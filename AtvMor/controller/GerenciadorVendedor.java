package controller;

import java.util.ArrayList;
import java.util.Scanner;

//Imports por ter pastas
import dao.DaoVendedor;
import model.Vendedor;
import model.Cargo;

public class GerenciadorVendedor {

    Scanner scanner;
    DaoVendedor dao;

    public GerenciadorVendedor(){ //Contrutor
        scanner = new Scanner(System.in);
        dao = new DaoVendedor();
    }

    public void menu(){
        int opcao = 1;

        do{
            System.out.println("\n - - - Menu Vendedor - - -");
            System.out.println("[1] - Cadastrar");
            System.out.println("[2] - Consultar");
            System.out.println("[3] - Alterar");
            System.out.println("[4] - Excluir");
            System.out.println("[5] - Listar todos");
            System.out.println("[0] - Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Valor inválido");
            }

            switch(opcao){
                case 1: 
                    limparTela(); //Apenas para fins esteticos.
                    cadastrar();
                    break;

                case 2: 
                    limparTela(); 
                    consultar();
                    break;

                case 3: 
                    limparTela(); 
                    alterar();
                    break;

                case 4: 
                    limparTela(); 
                    excluir();
                    break;

                case 5: 
                    limparTela(); 
                    listarTodos();
                    break;

            }

        }while(opcao != 0);
    }
    
    //Metodo de seguranca para escolher o cargo usando os ENUNS.
    private Cargo escolherCargo(){
        while(true){
            System.out.println("\nEscolha o Cargo:");
            System.out.println("[1] - JUNIOR");
            System.out.println("[2] - PLENO");
            System.out.println("[3] - SENIOR");
            System.out.println("[4] - GERENTE");
            System.out.print("Opção: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());

                switch(opcao){ //Evita erros como escrever: jr, ou coisas do tipo, e não identificar no Enum.
                    case 1: return Cargo.JUNIOR;
                    case 2: return Cargo.PLENO;
                    case 3: return Cargo.SENIOR;
                    case 4: return Cargo.GERENTE;
                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (Exception e){
                System.out.println("Digite um número válido!");
            }
        }
    }

    private void cadastrar(){
        Vendedor v = new Vendedor();

        System.out.println("\n- Cadastro de Vendedor -");

        System.out.print("Nome: ");
        v.setNome(scanner.nextLine());

        System.out.print("Contato: ");
        v.setContato(scanner.nextLine());

        System.out.print("Email: ");
        v.setEmail(scanner.nextLine());

        System.out.print("CPF: ");
        v.setCpf(scanner.nextLine());

        System.out.print("Cracha: ");
        v.setNumCracha(scanner.nextLine());

        System.out.print("Ano Admissão: ");
        v.setAnoAdmissao(Integer.parseInt(scanner.nextLine()));

        // Escolha segura anterior.
        v.setCargo(escolherCargo());

        String res = dao.inserir(v) ? "Inserido com sucesso" : "Erro ao inserir"; // Ternario
        System.out.println(res);
    }

    private void consultar(){
        ArrayList<Vendedor> lista = dao.buscarTodos(); //Recebe todos os valores, e guarda em uma lista
        
        if(lista.isEmpty()){ //Caso náo tiver cadastros
            System.out.println("Nenhum vendedor cadastrado.");
            return;
        }

        System.out.println("\n[Vendedores]");
        for(Vendedor v : lista){ //Vendedores na lista, retorna para ver o codigo e nome.
            System.out.println(v.getCodigo() + " - " + v.getNome()); //Apenas para mostrar o codigo e Nome.
        }

        System.out.print("\nDigite o código: ");
        int cod = Integer.parseInt(scanner.nextLine());

        Vendedor v = dao.consultar(cod); 

        if(v != null){ //Mostra todas as informacoes se não for null 
            System.out.println("\n[Dados]");
            System.out.println("Código: " + v.getCodigo());
            System.out.println("Nome: " + v.getNome());
            System.out.println("Contato: " + v.getContato());
            System.out.println("Email: " + v.getEmail());
            System.out.println("CPF: " + v.getCpf());
            System.out.println("Cracha: " + v.getNumCracha());
            System.out.println("Ano Admissão: " + v.getAnoAdmissao());
            System.out.println("Cargo: " + v.getCargo());
        } else {
            System.out.println("Não encontrado");
        }
    }


    private void alterar(){
        ArrayList<Vendedor> lista = dao.buscarTodos(); //Recebe todos os valores, e guarda em uma lista

        if(lista.isEmpty()){//Caso náo tiver cadastros
            System.out.println("Nenhum vendedor cadastrado.");
            return;
        }

        System.out.println("\n[Vendedores]");
        for(Vendedor v : lista){ //vendedores em lista
            System.out.printf("%-5d - %-20s%n", v.getCodigo(), v.getNome()); //Printf por questões de formatacao 
        }

        System.out.print("\nDigite o código: ");
        int cod = Integer.parseInt(scanner.nextLine());

        Vendedor v = dao.consultar(cod);

        if(v != null){

            System.out.print("Nome [" + v.getNome() + "]: ");
            String nome = scanner.nextLine();
            if(!nome.isEmpty()) v.setNome(nome); //Só muda se o usuario digitar algo, se não deixa como esta.

            System.out.print("Contato [" + v.getContato() + "]: ");
            String contato = scanner.nextLine();
            if(!contato.isEmpty()) v.setContato(contato);

            System.out.print("Email [" + v.getEmail() + "]: ");
            String email = scanner.nextLine();
            if(!email.isEmpty()) v.setEmail(email);

            System.out.print("CPF [" + v.getCpf() + "]: ");
            String cpf = scanner.nextLine();
            if(!cpf.isEmpty()) v.setCpf(cpf);

            System.out.print("Cracha [" + v.getNumCracha() + "]: ");
            String cracha = scanner.nextLine();
            if(!cracha.isEmpty()) v.setNumCracha(cracha);

            System.out.print("Ano Admissão [" + v.getAnoAdmissao() + "]: ");
            String ano = scanner.nextLine();
            if(!ano.isEmpty()) v.setAnoAdmissao(Integer.parseInt(ano));

            System.out.print("Deseja alterar o cargo? (s/n): "); //Somente se o usaurio quiser mudar o cargo.
            String resp = scanner.nextLine();

            if(resp.equalsIgnoreCase("s")){ //Se quiser mudar o cargo usando case-insensitive.
                v.setCargo(escolherCargo()); //Chama o metodo de antes, com o seus retornos.
            }

            int qtde = dao.alterar(v);

            System.out.println(qtde > 0 ? "Atualizado com sucesso" : "Erro ao atualizar");

        } else {
            System.out.println("Não encontrado");
        }
    }


    private void excluir(){
        ArrayList<Vendedor> lista = dao.buscarTodos(); //Recebe todos os valores, e guarda em uma lista

        if(lista.isEmpty()){
            System.out.println("Nenhum vendedor cadastrado.");
            return;
        }

        System.out.println("\n[Vendedores]");
        for(Vendedor v : lista){
            System.out.printf("%-5d - %-20s%n", v.getCodigo(), v.getNome()); //Mostra os vendedores cadastrados (Id - Nome)
        }

        System.out.print("\nDigite o código: "); 
        int cod = Integer.parseInt(scanner.nextLine());

        int qtde = dao.excluir(cod);

        System.out.println(qtde > 0 ? "Excluído com sucesso" : "Erro ao excluir"); //Ternario de retorno.
    }


   private void listarTodos(){
        ArrayList<Vendedor> lista = dao.buscarTodos();

        if(lista.isEmpty()){
            System.out.println("Nenhum vendedor cadastrado.");
            return;
        }

        System.out.println("\nLista de Vendedores:\n");

        // Cabeçalho
        System.out.printf("%-5s | %-20s | %-10s | %-15s%n", "ID", "NOME", "CARGO", "CONTATO");
        System.out.println("-------------------------------------------------------------");

        // Dados
        for(Vendedor v : lista){
            System.out.printf(
                "%-5d | %-20s | %-10s | %-15s%n",
                v.getCodigo(),
                v.getNome(),
                v.getCargo(),
                v.getContato()
            );
        }
    }


    private void limparTela(){
        try{
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }catch(Exception e){
            System.out.println("\n\n\n\n\n"); // caso de algum erro.
        }
    }
}
