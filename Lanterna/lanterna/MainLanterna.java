package src.lanterna;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;


public class MainLanterna {

    public static void main(String[] args) throws Exception {

        Screen screen = new DefaultTerminalFactory().createScreen(); //Cria a tela principal do lanterna
        screen.startScreen();

        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen); //Responsavel por gerenciar multiTelas
        BasicWindow window = new BasicWindow("Sistema de Consoles e Jogos"); //Tela inicial

        Panel panel = new Panel(); //Painel que organiza tudo

        panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
        panel.addComponent(new Label("CRUD utilizando DAO Generico"));
        panel.addComponent(new EmptySpace(new TerminalSize(1,1)));

        ActionListBox menu = new ActionListBox(); //Menu geral 

        menu.addItem( "Consoles", () -> MenuConsoleLanterna.abrir(gui));
        menu.addItem("Jogos", () -> MenuJogoLanterna.abrir(gui));
        menu.addItem("Sair",window::close);

        panel.addComponent(menu); // Adiciona o menu ao painel
        window.setComponent(panel); // Define o painel como conteúdo da janela
        gui.addWindowAndWait(window); // Exibe a janela e aguarda interação do usuário
        screen.stopScreen(); //após o uso fecha a janela.
    }
}