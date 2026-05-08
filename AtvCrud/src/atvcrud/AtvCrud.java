package atvcrud;

import java.util.ArrayList;
import model.DaoProjetos;
import model.Projetos;
import view.ProjetosView;

public class AtvCrud {
    public static void main(String[] args) {
        
        DaoProjetos daoProjetos = new DaoProjetos();
        ArrayList<Projetos> projetos = daoProjetos.buscarTodos();
        
        com.formdev.flatlaf.FlatDarkLaf.setup(); //Tema escuro para a janela.
        
        new ProjetosView().setVisible(true);
        
    }
    
}
  
