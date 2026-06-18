package src.view;

import java.util.ArrayList;
import java.util.Scanner;

import src.dao.DaoGenerico;
import src.model.Jogo;

public class JogoView {
    
    private Scanner scanner;
    private DaoGenerico daoGenerico;

    public JogoView(){
        scanner = new Scanner(System.in);
        daoGenerico = new DaoGenerico();
    }

    public void menu(){
        int opcao = 1;
        do {
            System.out.println("\n- - - MENU CONSOLES - - -");
            System.out.println("[1] - Cadastrar");
            System.out.println("[2] - Consultar");
            System.out.println("[3] - Alterar");
            System.out.println("[4] - Excluir");
            System.out.println("[5] - Listar Todos");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Informe um valor inteiro válido.");
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> cadastrar(); //Enhanced Switch implementado no Java 14, dispensa o break;
                case 2 -> consultar(); //Somente o metodo a frente vai ser executado.
                case 3 -> alterar();
                case 4 -> excluir();
                case 5 -> listarTodos();
                case 0 -> System.out.println("Bye...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void cadastrar(){
        try{
            Jogo j = new Jogo();
            System.out.println("\n- - Cadastro de Jogos - -");

            System.out.print("ID: ");
            j.setId(Integer.parseInt(scanner.nextLine()));

            System.out.print("Nome: ");
            j.setNome(scanner.nextLine());

            System.out.print("Gênero: ");
            j.setGenero(scanner.nextLine());
            
            System.out.print("Desenvolvedora: ");
            j.setDesenvolvedora(scanner.nextLine());

            System.out.print("Ano lançamento: ");
            j.setAnoLancamento(Integer.parseInt(scanner.nextLine()));

            System.out.print("Classificação: ");
            j.setClassificacao(scanner.nextLine());

            daoGenerico.inserir(j);
            System.out.println("Jogo cadastrado com sucesso!");

        }catch (NumberFormatException e){
            System.out.println("Erro: Digite apenas números válidos para ID e Ano lançamento ");
        }        
    }

    private void consultar() {
        try{
            System.out.println("\n- - Consulta de Jogos - -");
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine()); 

            Jogo j = daoGenerico.consultar(Jogo.class, "id", id);

            if(j != null){
                System.out.println("\n[Dados dos jogos");
                System.out.println("ID: " + j.getId());
                System.out.println("Nome: " + j.getNome());
                System.out.println("Gênero: " + j.getGenero());
                System.out.println("Desenvolvedor: " + j.getDesenvolvedora());
                System.out.println("Ano lançamento: " + j.getAnoLancamento());
                System.out.println("Classificação: " + j.getClassificacao());
                
            }else{
                System.out.println("Jogo não encontrado");
            }
        }catch(NumberFormatException e){
            System.out.println("Erro: O ID deve ser um número inteiro");
        
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void alterar() {
        try {
            System.out.println("\n- - Alteração de Jogos - -");
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            Jogo j = daoGenerico.consultar(Jogo.class, "id", id);

            if(j != null){
                System.out.print("[Nome: " + j.getNome() + "] ");
                String nome = scanner.nextLine();
                if (!nome.isEmpty()){ j.setNome(nome);}

                System.out.print("[Gênero: " + j.getGenero() + "] ");
                String genero = scanner.nextLine();
                if (!genero.isEmpty()){ j.setGenero(genero);}
     
                System.out.print("[Desenvolvedora: " + j.getDesenvolvedora() + "] ");
                String desenvolvedora = scanner.nextLine();
                if (!desenvolvedora.isEmpty()){ j.setDesenvolvedora(desenvolvedora);}
     
                System.out.print("[Classificacao: " + j.getClassificacao() + "] ");
                String classificacao = scanner.nextLine();
                if (!classificacao.isEmpty()){ j.setClassificacao(classificacao);}

                System.out.print("[Ano: " + j.getAnoLancamento() + "] ");
                String ano = scanner.nextLine();
                if (!ano.isEmpty()) j.setAnoLancamento(Integer.parseInt(ano));

                int qtde = daoGenerico.alterar(j, "id", id);
                if (qtde > 0) {
                    System.out.println("Atualizado com sucesso.");
                } else {
                    System.out.println("Não foi possível atualizar.");
                }

            } else {
                System.out.println("Jogo não encontrado.");

            }

        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada de número inválida ao alterar.");
        
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void excluir() {
        try {
            System.out.println("\n- - Exclusão de Jogo - -");
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            int qtde = daoGenerico.excluir(Jogo.class, "id", id);
            if (qtde > 0) {
                System.out.println("Excluído com sucesso!");
            } else {
                System.out.println("Erro ao excluir ou registro não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: O ID deve ser um número inteiro.");
        }
    }

    private void listarTodos() {
        ArrayList<Jogo> jogos = daoGenerico.buscarTodos(Jogo.class);
        System.out.println("\nJogos cadastrados:");

        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo encontrado.");
            return;
        }

        for (Jogo j : jogos) {
            System.out.printf("ID: %-3d | Nome: %-20s | Gênero: %-15s | Desenvolvedora: %-20s | Ano: %-4d | Classificação: %-10s\n",
                j.getId(),
                j.getNome(),
                j.getGenero(),
                j.getDesenvolvedora(),
                j.getAnoLancamento(),
                j.getClassificacao()
            );
        }
    }
}
