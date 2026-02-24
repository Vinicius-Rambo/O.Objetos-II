
import java.util.ArrayList;
import java.util.Iterator;

public class ListagemClientes {
    public static void main(String[] args) {

        ArrayList <Cliente> lista = new ArrayList<Cliente>();

        //Apenas para testes poderia ser um arquivo que alimenta.
        Cliente c1 = new Cliente();
        c1.setNome("Vinicius Rambo Padilha");
        c1.setEmail("Vncs.rambo@gmail.com");
        c1.setCpf("1213124");
        lista.add(c1);

        Cliente c2 = new Cliente();
        c2.setNome("Gabriel Santos");
        c2.setEmail("Gab.Santos@gmail.com");
        c2.setCpf("583853");
        lista.add(c2);
        
        Cliente c3 = new Cliente();
        c3.setNome("Breno Justus");
        c3.setEmail("Justos.rock@gmail.com");
        c3.setCpf("9124124");
        lista.add(c3);

        System.out.println("Percorrendo com Interator:");
        Iterator<Cliente> itCliente = lista.iterator(); //Interrator do tipo Cliente.
        
        while(itCliente.hasNext()){ //Enquanto tiver um proximo.
            Cliente c = itCliente.next(); //Criando um objeto com o valor do proximo.
            System.out.println("Nome: " + c.getNome() + " CPF: " + c.getCpf());
        }

        //Remover itens da lista.
        Cliente cliRemover = new Cliente();
        cliRemover.setCpf("9124124");

        Iterator <Cliente> itRemove = lista.iterator();
        while (itRemove.hasNext()) {
            if(itRemove.next().getCpf().equals(cliRemover.getCpf())){ //Sempre remove o objeto apontado pelo Iterator.
                System.out.println("\nRemovendo o cliente do CPF: " + cliRemover.getCpf());
                itRemove.remove();
            }
        }

        System.out.println("\nPercorrendo com foreach");
        for(Cliente c : lista){
            System.out.println("Nome: " + c.getNome() + " CPF: " + c.getCpf()); 
        }

        //Remover item da lista usando Foreach
        cliRemover.setCpf("583853");
        for (Cliente cli : lista){
            if(cli.getCpf().equals(cliRemover.getCpf()));
            System.out.println("Removendo o cliente de CPF: " + cliRemover.getCpf());
            itRemove.remove();
            //break; //Se o elemento a ser removido for o ultimo dá exceção, a menos que coloque break.
        } 

        
    }
    
}
