import java.util.Scanner;

import src.view.ConsoleView;
import src.view.JogoView;

public class Controladora {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao = 1;
        do {
            System.out.println("\n- - - Menu Escolhas - - -");
            System.out.println("[1] - Consoles");
            System.out.println("[2] - Jogos");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Informe um valor inteiro válido.");
                opcao = -1;
            }

            switch (opcao) {
                case 1: 
                    ConsoleView consoleview = new ConsoleView();
                    consoleview.menu();
                    break;

                case 2: 
                    JogoView jogoView = new JogoView();
                    jogoView.menu();
                    break;
            }
            
        }while(opcao != 0);
    }
}
