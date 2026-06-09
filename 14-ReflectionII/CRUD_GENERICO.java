import java.util.ArrayList;

public class CRUD_GENERICO {
    public static void main(String[] args) {
        DaoGenerico daoGen = new DaoGenerico();

        //teste inserir;
        //Veiculo v = new Veiculo();
        //v.setAno(2030);
        //v.setModelo("KA");
        //v.setMarca("Forde");
        //v.setChassi("123qwe");
        //daoGen.inserir(v);

        //ArrayList<Veiculo> itens = daoGen.buscarTodos(Veiculo.class);
        //for(Veiculo v : itens){
        //    System.err.println("Veiculo: " + v.getModelo());
        //}

        ArrayList<Veiculo> itens = daoGen.buscarTodosFiltro(Veiculo.class, "marca", "forde");
        for(Veiculo v : itens){
            System.err.println("Veiculo: " + v.getModelo());
        }

    }
}
