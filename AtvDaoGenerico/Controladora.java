import java.util.Scanner;

import src.view.ConsoleView;
import src.view.JogoView;

public class Controladora {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int opcao = 1;

        do {
            limparTela();
            
            System.out.println("+---------------------------+");
            System.out.println("|  Controladora VideoGames  |");
            System.out.println("+---------------------------+");
            System.out.println("| [1] Gerenciar Consoles    |");
            System.out.println("| [2] Gerenciar Jogos       |");
            System.out.println("| [0] Encerrar Sistema      |");
            System.out.println("+---------------------------+");
            System.out.print("Escolha uma opção: ");

            try {

                opcao = Integer.parseInt(scanner.nextLine());

            } catch (Exception e) {

                System.out.println("\nERRO: Informe um número válido.");
                opcao = -1;
            }

            switch (opcao) {

                case 1:

                    ConsoleView consoleView = new ConsoleView();
                    consoleView.menu();
                    break;

                case 2:

                    JogoView jogoView = new JogoView();
                    jogoView.menu();
                    break;

                case 0:

                    System.out.println("Bye....");
                    break;

                default:

                    System.out.println();
                    System.out.println("ERRO: Opção inválida.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void limparTela() {
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor(); 
        } catch (Exception e) {
            for (int i = 0; i < 40; i++) {
                System.out.println();
            }
        }
    }
}