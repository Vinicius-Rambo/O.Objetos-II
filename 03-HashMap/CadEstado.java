
import java.util.HashMap;

public class CadEstado {
    public static void main(String[] args) {
        HashMap<String, Estado> estados = new HashMap<String, Estado>();
        Estado e1 = new Estado();
        Estado e2 = new Estado();
        Estado e3 = new Estado();

        e1.setNome("Paraná");
        e1.setRegiao("Sul");
        estados.put("PR", e1);

        e2.setNome("Bahia");
        e2.setRegiao("nordeste");
        estados.put("BA", e2);
        
        e3.setNome("São Paulo");
        e3.setRegiao("Sudeste");
        estados.put("SP", e3);

        //System.out.println("Estados: " + estados); //Retorna uma String e Um objeto, não funciona.1

        System.out.println("Verificando se um estado existe no Hashmap: ");
        String pesquisando = "SP";

        if(estados.containsKey(pesquisando)){

            System.out.println(pesquisando + " existe no hashmap");
            System.out.println("Buscando a região do estado de " + pesquisando);
            System.out.println("Região: " + estados.get(pesquisando).getRegiao()); //Retorna a região de dentro do objeto

        }else{
            System.out.println("Não encontrado");
        }

        System.out.println("Percorrendo as chaves");
        for(String item : estados.keySet()){
            System.out.println(item);
        }

        System.out.println("Percorrendo os valores");
        for(Estado e : estados.values()){
            System.out.println(e.getNome() + " fica na região " + e.getRegiao());
        }


    }
}
