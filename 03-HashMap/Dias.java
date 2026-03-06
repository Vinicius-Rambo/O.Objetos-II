
import java.util.HashMap;

public class Dias {
    public static void main(String[] args) {
        HashMap<String, String> diasSemana = new HashMap<String, String>();

        diasSemana.put("DOM","Domingo"); //Put, Adiciona um HashMap
        diasSemana.put("SEG","Segunda-feira");
        diasSemana.put("TER","Terça-feira");
        diasSemana.put("QUA","Quarta-feira");
        diasSemana.put("QUI","Quinta-feira");
        diasSemana.put("SEX","Sexta-feira");
        diasSemana.put("SAB","Sábado");

        //Sobrescrevendo um item.

        diasSemana.put("SAB", "Sabadão!!!");

        System.out.println("Mostrando os pares armazenados"); //Pares Chave-Valor.
        System.out.println(diasSemana); //Mostra a Hashmap completo.

        System.out.println("Verificando se um dia Existe ");
        System.out.println("QUA Existe?: " + diasSemana.containsKey("Qua")); //ContainsKey, verica se existe algo pela chave
        System.out.println("QUA Existe?: " + diasSemana.containsKey("QUA")); //Case Sensitive

        System.out.println("Pegando um item a partir da chave: ");
        System.out.println("O valor da chave TER é: " + diasSemana.get("TER")); //get, retira o valor, usando a chave.

        System.out.println("Quantidade de pares chave-valor: " + diasSemana.size()); //Size retorna o tamanho do Hashmap.
        
        String itemRemover = "TER";
        System.out.println("Removendo um item do Hashmap");
        diasSemana.remove(itemRemover); //Remove 
        
        System.out.println("Quantidade de pares chave-valor: " + diasSemana.size()); //Size após remover um item do hash.

        System.out.println("Percorrendo as chaves: ");
        for(String item : diasSemana.keySet()){  //Foreach.
            System.out.println(item);
        }

        System.out.println("Percorrendo os valores: ");
        for(String item : diasSemana.values()){  //Foreach.
            System.out.println(item);
        }

        System.out.println("Removendo todos os pares.... ");
        diasSemana.clear();
        System.out.println("Quantidade de pares chave-valor: " + diasSemana.size());


    }    
}
