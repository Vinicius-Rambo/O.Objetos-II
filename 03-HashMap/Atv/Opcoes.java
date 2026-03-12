
import java.io.BufferedReader;
import java.util.HashMap;

public class Opcoes {
    HashMap<String, Aeroporto> aeroportos = new HashMap<String, Aeroporto>(); //Criação do HashMap Aeroportos.
    
    //Cadastrar Aeroportos
    public void cadastrarAeroportos(BufferedReader teclado) throws Exception{  
        Aeroporto a = new Aeroporto();
        System.out.println("- - - Cadastro de Aeroportos - - -");

        System.out.print("Digite o Nome do Aeroporto: ");
        a.setNome(teclado.readLine());

        System.out.print("Digite a cidade do Aeroporto: ");
        a.setCidade(teclado.readLine());

        System.out.print("Digite a altitude que o Aeroporto está: "); //Altitude do aeroporto em relação ao nivel do mar.
        a.setAltitude(teclado.readLine());

        System.out.print("Digite a sigla do Aeroporto: ");
        String sigla = teclado.readLine();

        aeroportos.put(sigla, a); //Inserção do Ojeto Aeroporto no Hashmap utilizando a sigla como chave.
    }

    public void listarAeroportos() throws Exception{ 

        if(aeroportos.isEmpty()){ //Metodo não apresentado em aula
            System.out.println("Sem aeroportos cadastrados!"); 
            return; //Retorna se não tiver nada no Hashmap.
        }

        for (String sigla : aeroportos.keySet()){  //Foreach com sigla e chave.

            Aeroporto a = aeroportos.get(sigla); //Objeto A do tipo Aeroporto é igual ao valor do objeto referente a chave "sigla"
            System.out.println("[" + sigla + "] - " + a.getNome()); //Para conseguir ter a Key e o Nome, alternativamente poderia usar entrySet()
        }
    }

    public void removerAeroportos(BufferedReader teclado) throws Exception {
        if(aeroportos.isEmpty()){ //Metodo não apresentado em aula
            System.out.println("Sem aeroportos cadastrados!"); 
            return; //Retorna se não tiver nada no Hashmap.
        }

        listarAeroportos(); //Chama o metodo anterior.

        System.out.print("Informe a sigla do aeroporto: ");
        String valor = teclado.readLine();

        if (aeroportos.containsKey(valor)) { //Se a chave for valida.
            aeroportos.remove(valor);        //Remove a chave
            System.out.println("Removido o aeroporto da sigla: " + valor);
        } else {
            System.out.println(valor + " não encontrado!!"); //Se a chave não for valida.
        }
    }


   public void consultarSigla(BufferedReader teclado) throws Exception {
        if(aeroportos.isEmpty()){ //Metodo não apresentado em aula
            System.out.println("Sem aeroportos cadastrados!"); 
            return; //Retorna se não tiver nada no Hashmap.
        }

        listarAeroportos();
        String valor;

        do {
            System.out.print("Informe a sigla do aeroporto ou digite [0] para sair: ");
            valor = teclado.readLine();

            if(valor.equals("0")) break;

            if(aeroportos.containsKey(valor)) {

                Aeroporto a = aeroportos.get(valor);

                System.out.println("\n- - Informações: - - ");
                System.out.println("Nome: " + a.getNome());
                System.out.println("Cidade: " + a.getCidade());
                System.out.println("Altitude: " + a.getAltitude());

            } else {
                System.out.println("Sigla inválida, tente novamente.");
            }

        }while (!aeroportos.containsKey(valor));
    }

 
}
