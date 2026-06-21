package src.view;

import java.util.ArrayList;
import java.util.Scanner;
import src.dao.DaoGenerico;
import src.model.Console;

public class ConsoleView {

    private Scanner scanner;
    private DaoGenerico daoGenerico;

    public ConsoleView() {
        scanner = new Scanner(System.in);
        daoGenerico = new DaoGenerico();
    }

    public void menu() throws Exception {
        int opcao = 1;
        do {
            limparTela();

            System.out.println("+---------------------------+");
            System.out.println("|       CRUD CONSOLES       |");
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
                case 2 -> consultar();
                case 3 -> alterar();
                case 4 -> excluir();
                case 5 -> listarTodos();
                case 0 -> System.out.println("Bye...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public void cadastrar() throws Exception {
        try {
            Console c = new Console();
            limparTela();
            System.out.println("+--------------------------------------+");
            System.out.println("|          CADASTRAR CONSOLE           |");
            System.out.println("+--------------------------------------+");

            System.out.print("ID: ");
            c.setId(Integer.parseInt(scanner.nextLine()));

            System.out.print("Nome: ");
            c.setNome(scanner.nextLine());

            System.out.print("Fabricante: ");
            c.setFabricante(scanner.nextLine());

            System.out.print("Ano de lançamento: ");
            c.setAnoLancamento(Integer.parseInt(scanner.nextLine()));

            System.out.print("Armazenamento (GB): ");
            c.setArmazenamento(Float.parseFloat(scanner.nextLine()));

            String resposta;
            do {
                System.out.print("Portátil (S/N): ");
                resposta = scanner.nextLine().toLowerCase().trim();
            } while (!resposta.equals("sim") && !resposta.equals("nao") && !resposta.equals("s") && !resposta.equals("n") && !resposta.equals("não"));
            
            c.setPortatil(resposta);

            Console existente = daoGenerico.consultar(Console.class, "id", c.getId());

            if(existente != null){
                System.out.println("ERRO: Já existe um console com esse ID.");
                pausa();
                return;
            }

            daoGenerico.inserir(c);
            System.out.println("\nConsole cadastrado com sucesso!");
            pausa();


        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite apenas números válidos para ID, Ano e Armazenamento.");
            pausa();
        }
    }

    public void consultar() {
        try {
            System.out.println("\n- - Consulta de Console - -");
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            
            Console c = daoGenerico.consultar(Console.class, "id", id);

            if (c != null) {
                System.out.println();
                System.out.println("+--------------------------------------+");
                System.out.println("|          DADOS DO CONSOLE            |");
                System.out.println("+--------------------------------------+");
                System.out.println(" ID..............: " + c.getId());
                System.out.println(" Nome............: " + c.getNome());
                System.out.println(" Fabricante......: " + c.getFabricante());
                System.out.println(" Ano.............: " + c.getAnoLancamento());
                System.out.println(" Armazenamento...: " + c.getArmazenamento() + " GB");
                System.out.println(" Portátil........: " + c.getPortatil());
                System.out.println("+--------------------------------------+");
                pausa();
            } else {
                System.out.println("Console não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: O ID deve ser um número inteiro.");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void alterar() {
        try {
            limparTela();
            System.out.println("+--------------------------------------+");
            System.out.println("|           ALTERAR CONSOLE            |");
            System.out.println("+--------------------------------------+");
            System.out.println("Deixe em branco para manter o valor.");
            System.out.println();

            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            Console c = daoGenerico.consultar(Console.class, "id", id);

            if (c != null) {
                System.out.print("[Nome: " + c.getNome() + "] ");
                String nome = scanner.nextLine();
                if (!nome.isEmpty()) c.setNome(nome);

                System.out.print("[Fabricante: " + c.getFabricante() + "] ");
                String fabricante = scanner.nextLine();
                if (!fabricante.isEmpty()) c.setFabricante(fabricante);

                System.out.print("[Ano: " + c.getAnoLancamento() + "] ");
                String ano = scanner.nextLine();
                if (!ano.isEmpty()) c.setAnoLancamento(Integer.parseInt(ano));

                System.out.print("[Armazenamento: " + c.getArmazenamento() + "] ");
                String armazenamento = scanner.nextLine();
                if (!armazenamento.isEmpty()) c.setArmazenamento(Float.parseFloat(armazenamento));

                System.out.print("[Portátil: " + c.getPortatil() + "] ");
                String portatil = scanner.nextLine();
                if (!portatil.isEmpty()) c.setPortatil(portatil);

                int qtde = daoGenerico.alterar(c, "id", id);
                if (qtde > 0) {
                    System.out.println("\nConsole atualizado com sucesso!");
                    pausa();

                } else {
                    System.out.println("Não foi possível atualizar.");
                }
            } else {
                System.out.println("Console não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada de número inválida ao alterar.");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public void excluir() throws Exception {
        try {
            limparTela();
            System.out.println("+--------------------------------------+");
            System.out.println("|           EXCLUIR CONSOLE            |");
            System.out.println("+--------------------------------------+");

            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            Console c = daoGenerico.consultar(Console.class, "id", id);

            if (c != null) {

                System.out.println();
                System.out.println("Console encontrado:");
                System.out.println("Nome: " + c.getNome());
                System.out.println("Fabricante: " + c.getFabricante());

                System.out.print("\nConfirmar exclusão (S/N): ");
                String resposta = scanner.nextLine();

                if (!resposta.equalsIgnoreCase("S")) {
                    System.out.println("Operação cancelada.");
                    pausa();
                    return;
                }
            }

            int qtde = daoGenerico.excluir(Console.class, "id", id);
            if (qtde > 0) {
                System.out.println("Excluído com sucesso!");
            } else {
                System.out.println("Erro ao excluir ou registro não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: O ID deve ser um número inteiro.");
        }
    }

    public void listarTodos() {
        ArrayList<Console> consoles = daoGenerico.buscarTodos(Console.class);
        System.out.println("\nConsoles cadastrados:");

        if (consoles.isEmpty()) {
            System.out.println("Nenhum console encontrado.");
            return;
        }

        System.out.println();
        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.printf("| %-3s | %-20s | %-15s | %-4s | %-10s | %-10s |\n",
                "ID",
                "NOME",
                "FABRICANTE",
                "ANO",
                "ARMAZ.(GB)",
                "PORTATIL");
        System.out.println("+--------------------------------------------------------------------------------+");

        for (Console c : consoles) {
            System.out.printf("| %-3d | %-20s | %-15s | %-4d | %-10.2f | %-10s |\n",
                    c.getId(),
                    c.getNome(),
                    c.getFabricante(),
                    c.getAnoLancamento(),
                    c.getArmazenamento(),
                    c.getPortatil());
        }

        System.out.println("+--------------------------------------------------------------------------------+");
        System.out.println("Total de registros: " + consoles.size());
        pausa();
    }

    private void limparTela() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor(); //Limpa o terminal do linux
        } catch (Exception e) {
            for (int i = 0; i < 40; i++) { // Caso não funcione printa 40 espaços vazios.
                System.out.println();
            }
        }
    }

    private void pausa() { //Metodo auxiliar para evitar repetição.
        System.out.println();
        System.out.print("Pressione ENTER para continuar...");
        scanner.nextLine();
    }

}