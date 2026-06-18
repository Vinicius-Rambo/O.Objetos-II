package src.lanterna;

import com.googlecode.lanterna.gui2.*;
import src.view.JogoView;


public class MenuJogoLanterna {
    public static void abrir(MultiWindowTextGUI gui) {

        BasicWindow window = new BasicWindow("CRUD Jogos");
        Panel panel = new Panel();

        panel.setLayoutManager(new LinearLayout(Direction.VERTICAL)); //Organiza os componentes em coluna
        ActionListBox menu = new ActionListBox();

        menu.addItem("Abrir CRUD Jogos", () -> {

                    window.close(); // Fecha a janela atual
                    JogoView view = new JogoView(); // Cria a view de Jogos
                    view.menu(); // Executa o menu principal do CRUD, antes criado
                });

        menu.addItem("Voltar", window::close); // Fecha a janela e retorna ao menu anterior

        panel.addComponent(menu);
        window.setComponent(panel);
        gui.addWindowAndWait(window);
    }
}