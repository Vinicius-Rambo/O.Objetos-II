public class Locadora {
    public static void main(String[] args) {
        DaoVeiculo daoVeiculo = new DaoVeiculo();
        Veiculo v = new Veiculo();
        
        v.setMarca("Ford");
        v.setModelo("Focus");
        v.setChassi("ABC123SDF");
        v.setAno(2017);
        boolean inserido = daoVeiculo.inserir(v);

        System.out.println("Inserido?" + inserido);


    }    
}
