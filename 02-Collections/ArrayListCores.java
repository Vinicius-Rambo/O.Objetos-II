
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListCores {
    public static void main(String[] args) {
        String[] vetCores = {"Magenta", "Branco", "Verde", "Azul"};
        ArrayList <String> listaCores = new ArrayList <String>();

        //Vetor.
        System.out.println("\nPercorrer vetor com contador: ");
        for(int i = 0; i < vetCores.length; i++){
            System.out.println(vetCores[i]);
        }

        System.out.println("\nPercorrer vetor com Foreach: ");
        for(String cor : vetCores) {
            System.out.println(cor);
            listaCores.add(cor); //Adicionando as cores no arraylist.
        }

        //ArrayList
        System.out.println("\nPercorrer ArrayList com for"); //Equivalente ao primeiro, mas usando o ArrayList.
        for (int count = 0; count < listaCores.size(); count++){
            System.out.println(listaCores.get(count));
        }

        System.out.println("\nPercorrer ArrayList com iterator"); //Muito comum em codigos legados, mas hoje foreach é melhor
        Iterator <String> it = listaCores.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toUpperCase()); //Como ele retorna em forma de String é possivel usar metodos proprios.
        }

        System.out.println("\nPercorrer ArrayList com foreach"); // Implementando do zero é a melhor forma.
        for(String cor: listaCores){
            System.out.println(cor);
        }
    }
}
