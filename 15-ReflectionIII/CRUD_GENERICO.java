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

        ArrayList<Veiculo> itens = daoGen.buscarTodos(Veiculo.class);
        for(Veiculo v : itens){
            System.err.println("Veiculo: " + v.getModelo());
        }

        //ArrayList<Veiculo> itens = daoGen.buscarTodosFiltro(Veiculo.class, "marca", "forde");
        //for(Veiculo v : itens){
        //    System.err.println("Veiculo: " + v.getModelo());
        //}


        //int qtde = daoGen.excluir(Veiculo.class, "codigo", 1);
        //System.out.println("Qtde excluida: " + qtde);
    
        
        //Veiculo v = daoGen.consultar(Veiculo.class, "codigo", "1");
        //if(v != null){
        //    System.out.println("O retorno é: " + v.getModelo());
        //}else{
        //    System.out.println("Não encontrado");
        //}

        Veiculo v = new Veiculo();
        v.setAno(2026);
        v.setModelo("ARGO!!!!");
        v.setMarca("fiat");
        v.setChassi("ajdjadjaj");

        daoGen.alterar(v, "codigo", "1");

    }
}
