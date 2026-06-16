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

    public void menu() {

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
                System.out.println("Informe um valor inteiro");
                opcao = -1;
            }

            switch (opcao) {

                case 1:
                    cadastrar();
                    break;

                case 2:
                    consultar();
                    break;

                case 3:
                    alterar();
                    break;

                case 4:
                    excluir();
                    break;

                case 5:
                    listarTodos();
                    break;

                case 0:
                    System.out.println("Bye...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void cadastrar() {

        Console c = new Console();

        System.out.println("\n- - Cadastro de Console - -");

        System.out.print("ID: ");
        c.setId(Integer.parseInt(scanner.nextLine()));

        System.out.print("Nome: ");
        c.setNome(scanner.nextLine());

        System.out.print("Fabricante: ");
        c.setFabricante(scanner.nextLine());

        System.out.print("Ano de lançamento: ");
        c.setAnoLancamento(Integer.parseInt(scanner.nextLine()));

        System.out.print("Armazenamento (GB): ");
        c.setArmazenamento(Integer.parseInt(scanner.nextLine()));

        System.out.print("Portátil (1=Sim / 0=Não): ");
        c.setPortatil(Integer.parseInt(scanner.nextLine()));

        daoGenerico.inserir(c);
        System.out.println("Console cadastrado com sucesso!");
    }

    private void consultar() {

        try {

            System.out.println("\n- - Consulta de Console - -");

            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            Console c = daoGenerico.consultar(Console.class, "id", id);

            if (c != null) {

                System.out.println("\n[Dados do Console]");
                System.out.println("ID: " + c.getId());
                System.out.println("Nome: " + c.getNome());
                System.out.println("Fabricante: " + c.getFabricante());
                System.out.println("Ano: " + c.getAnoLancamento());
                System.out.println("Armazenamento: " + c.getArmazenamento() + " GB");
                System.out.println("Portátil: " + (c.getPortatil() == 1 ? "Sim" : "Não"));

            } else {
                System.out.println("Console não encontrado.");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void alterar() {

        try {

            System.out.println("\n- - Alteração de Console - -");

            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            Console c = daoGenerico.consultar(Console.class, "id", id);

            if (c != null) {

                System.out.println("\n[ID: " + c.getId() + "]");

                System.out.print("[Nome: " + c.getNome() + "] ");
                String nome = scanner.nextLine();
                if (!nome.isEmpty()) {
                    c.setNome(nome);
                }

                System.out.print("[Fabricante: " + c.getFabricante() + "] ");
                String fabricante = scanner.nextLine();
                if (!fabricante.isEmpty()) {
                    c.setFabricante(fabricante);
                }

                System.out.print("[Ano: " + c.getAnoLancamento() + "] ");
                String ano = scanner.nextLine();
                if (!ano.isEmpty()) {
                    c.setAnoLancamento(Integer.parseInt(ano));
                }

                System.out.print("[Armazenamento: " + c.getArmazenamento() + "] ");
                String armazenamento = scanner.nextLine();
                if (!armazenamento.isEmpty()) {
                    c.setArmazenamento(Integer.parseInt(armazenamento));
                }

                System.out.print("[Portátil (1=Sim / 0=Não): " + c.getPortatil() + "] ");
                String portatil = scanner.nextLine();
                if (!portatil.isEmpty()) {
                    c.setPortatil(Integer.parseInt(portatil));
                }

                int qtde = daoGenerico.alterar(c, "id", id);

                if (qtde > 0) {
                    System.out.println("Atualizado com sucesso.");
                } else {
                    System.out.println("Não foi possível atualizar.");
                }

            } else {
                System.out.println("Console não encontrado.");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void excluir() {

        System.out.println("\n- - Exclusão de Console - -");

        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        int qtde = daoGenerico.excluir(Console.class, "id", id);

        if (qtde > 0) {
            System.out.println("Excluído com sucesso!");
        } else {
            System.out.println("Erro ao excluir.");
        }
    }

    private void listarTodos() {

        ArrayList<Console> consoles =
                daoGenerico.buscarTodos(Console.class);

        System.out.println("\nConsoles cadastrados:");

        for (Console c : consoles) {

            System.out.printf(
                "ID: %-3d | Nome: %-20s | Fabricante: %-15s | Ano: %-4d | Armazenamento: %-4d GB | Portátil: %-3s%n",
                c.getId(),
                c.getNome(),
                c.getFabricante(),
                c.getAnoLancamento(),
                c.getArmazenamento(),
                c.getPortatil() == 1 ? "Sim" : "Não" //Metodo ternario pois o DaoGenerico não tem boolean.
            );
        }
    }
}