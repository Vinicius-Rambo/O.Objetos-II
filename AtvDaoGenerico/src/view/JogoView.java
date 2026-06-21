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

    public void menu() throws Exception{
        int opcao = 1;
        do {
            limparTela();

            System.out.println("+---------------------------+");
            System.out.println("|        CRUD JOGOS         |");
            System.out.println("+---------------------------+");
            System.out.println("| [1] Cadastrar             |");
            System.out.println("| [2] Consultar             |");
            System.out.println("| [3] Alterar               |");
            System.out.println("| [4] Excluir               |");
            System.out.println("| [5] Listar Todos          |");
            System.out.println("| [0] Voltar                |");
            System.out.println("+---------------------------+");
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

    private void cadastrar() throws Exception{
        try{
            Jogo j = new Jogo();
            limparTela();

            System.out.println("+--------------------------------------+");
            System.out.println("|           CADASTRAR JOGO            |");
            System.out.println("+--------------------------------------+");

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

            Jogo existente = daoGenerico.consultar(Jogo.class, "id", j.getId()); //para o ID ser unico,

            if(existente != null){
                System.out.println("ERRO: Já existe um jogo com esse ID.");
                pausa();
                return;
            }

            daoGenerico.inserir(j);
            System.out.println("\nJogo cadastrado com sucesso!");
            pausa();

        }catch (NumberFormatException e){
            System.out.println("\nERRO: Digite apenas números válidos.");
            pausa();
        }        
    }

    private void consultar() {
        try{
            limparTela();

            System.out.println("+--------------------------------------+");
            System.out.println("|            CONSULTAR JOGO            |");
            System.out.println("+--------------------------------------+");
            System.out.print("ID: ");

            int id = Integer.parseInt(scanner.nextLine()); 

            Jogo j = daoGenerico.consultar(Jogo.class, "id", id);

            if(j != null){
                System.out.println();
                System.out.println("+--------------------------------------+");
                System.out.println("|            DADOS DO JOGO             |");
                System.out.println("+--------------------------------------+");
                System.out.println(" ID..............: " + j.getId());
                System.out.println(" Nome............: " + j.getNome());
                System.out.println(" Gênero..........: " + j.getGenero());
                System.out.println(" Desenvolvedora..: " + j.getDesenvolvedora());
                System.out.println(" Ano.............: " + j.getAnoLancamento());
                System.out.println(" Classificação...: " + j.getClassificacao());
                
                pausa();
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
            limparTela();
            System.out.println("+--------------------------------------+");
            System.out.println("|            ALTERAR JOGO              |");
            System.out.println("+--------------------------------------+");
            System.out.println("Deixe em branco para manter o valor.");
            System.out.println();

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
                    System.out.println("\nJogo atualizado com sucesso!");
                    pausa();

                } else {
                    System.out.println("Não foi possível atualizar.");
                }

            } else {
                System.out.println("\nJogo não encontrado.");
                pausa();

            }

        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada de número inválida ao alterar.");
        
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

   private void excluir() {
        try {
            limparTela();

            System.out.println("+--------------------------------------+");
            System.out.println("|            EXCLUIR JOGO              |");
            System.out.println("+--------------------------------------+");

            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            Jogo j = daoGenerico.consultar(Jogo.class, "id", id);

            if (j == null) {
                System.out.println("\nJogo não encontrado.");
                pausa();
                return;
            }

            System.out.println();
            System.out.println("Jogo encontrado:");
            System.out.println("Nome: " + j.getNome());
            System.out.println("Desenvolvedora: " + j.getDesenvolvedora());

            System.out.print("\nConfirmar exclusão (S/N): ");
            String resposta = scanner.nextLine();

            if (!resposta.equalsIgnoreCase("S")) {
                System.out.println("\nOperação cancelada.");
                pausa();
                return;
            }

            int qtde = daoGenerico.excluir(Jogo.class, "id", id);

            if (qtde > 0) {
                System.out.println("\nJogo excluído com sucesso!");
            } else {
                System.out.println("\nErro ao excluir o jogo.");
            }

            pausa();

        } catch (NumberFormatException e) {
            System.out.println("\nERRO: O ID deve ser um número inteiro.");
            pausa();
        } catch (Exception e) {
            System.out.println("\nERRO: " + e.getMessage());
            pausa();
        }
    }

    private void listarTodos() {
        ArrayList<Jogo> jogos = daoGenerico.buscarTodos(Jogo.class);
        System.out.println("\nJogos cadastrados:");

        if (jogos.isEmpty()) {
            System.out.println("Nenhum jogo encontrado.");
            return;
        }

        System.out.println();

        System.out.println("+------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-3s | %-20s | %-15s | %-20s | %-4s | %-15s |\n",
                "ID",
                "NOME",
                "GENERO",
                "DESENVOLVEDORA",
                "ANO",
                "CLASSIFICACAO");

        System.out.println("+------------------------------------------------------------------------------------------------------------------+");

        for (Jogo j : jogos) {

            System.out.printf("| %-3d | %-20s | %-15s | %-20s | %-4d | %-15s |\n",
                    j.getId(),
                    j.getNome(),
                    j.getGenero(),
                    j.getDesenvolvedora(),
                    j.getAnoLancamento(),
                    j.getClassificacao());
        }

        System.out.println("+------------------------------------------------------------------------------------------------------------------+");
        System.out.println("Total de registros: " + jogos.size());

        pausa();
    }

    private void limparTela() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor(); 
        } catch (Exception e) {
            for (int i = 0; i < 40; i++) {
                System.out.println();
            }
        }
    }

    private void pausa() {
        System.out.println();
        System.out.print("Pressione ENTER para continuar...");
        scanner.nextLine();
    }

}
