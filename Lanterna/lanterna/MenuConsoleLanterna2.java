package src.lanterna;

import com.googlecode.lanterna.gui2.*;

import src.view.ConsoleView;

public class MenuConsoleLanterna2{

    public static void abrir(MultiWindowTextGUI gui) {

        BasicWindow window = new BasicWindow("CRUD Consoles");

        Panel panel = new Panel();
        panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
        panel.addComponent(new Label("Gerenciamento de Consoles"));

        ActionListBox menu = new ActionListBox();

        // Instancia a view uma única vez
        ConsoleView view = new ConsoleView();

        menu.addItem("Cadastrar Console", () -> {
            window.close();
            view.cadastrar();
        });

        menu.addItem("Consultar Console", () -> {
            window.close();
            view.consultar();
        });

        menu.addItem("Alterar Console", () -> {
            window.close();
            view.alterar();
        });

        menu.addItem("Excluir Console", () -> {
            window.close();
            view.excluir();
        });

        menu.addItem("Listar Consoles", () -> {
            window.close();
            view.listarTodos();
        });

        menu.addItem("Voltar", window::close);
        panel.addComponent(menu);
        window.setComponent(panel);

        gui.addWindowAndWait(window);
    }
}