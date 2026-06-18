package src.lanterna;

import com.googlecode.lanterna.gui2.*;

import src.view.ConsoleView;

public class MenuConsoleLanterna {

    public static void abrir(MultiWindowTextGUI gui) {

        BasicWindow window = new BasicWindow("CRUD Consoles");
        Panel panel = new Panel();

        panel.setLayoutManager(new LinearLayout(Direction.VERTICAL)); //Organiza os componentes em coluna

        ActionListBox menu = new ActionListBox(); // Criação do menu

        menu.addItem( "Abrir CRUD Console", () -> {
                    window.close();
                    ConsoleView view = new ConsoleView(); //Chama o crud normal.
                    view.menu();
                });

        menu.addItem("Voltar", window::close); 

        panel.addComponent(menu);
        window.setComponent(panel);
        gui.addWindowAndWait(window);
    }
}