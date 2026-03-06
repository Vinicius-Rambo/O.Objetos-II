
import java.io.BufferedReader;
import java.util.HashMap;

public class Opcoes {
    HashMap<String, Aeroporto> aeroportos = new HashMap<String, Aeroporto>();
    
    //Cadastrar Aeroportos
    public void cadastrarAeroportos(BufferedReader teclado) throws Exception {
        Aeroporto a = new Aeroporto();
        System.out.println("- - - Cadastro de Aeroportos - - -");

        System.out.print("Digite o Nome do Aeroporto: ");
        a.setNome(teclado.readLine());

        System.out.print("Digite a cidade do Aeroporto: ");
        a.setCidade(teclado.readLine());

        System.out.print("Digite a altitude que o Aeroporto trabalha: ");
        a.setAltitude(teclado.readLine());

        System.out.print("Digite a sigla do Aeroporto: ");
        String sigla = teclado.readLine();

        aeroportos.put(sigla, a);

    }

    public void listarAeroportos() throws Exception{ 
        for (String sigla : aeroportos.keySet()){ 
            Aeroporto a = aeroportos.get(sigla); //Para conseguir ter a Key e o Nome, alternativamente poderia usar entrySet()
            System.out.println("[" + sigla + "] - " + a.getNome());
        }
    }

    public void removerAeroportos(BufferedReader teclado) throws Exception {
        listarAeroportos();

        System.out.print("Informe a sigla do aeroporto: ");
        String valor = teclado.readLine();

        if (aeroportos.containsKey(valor)) {
            aeroportos.remove(valor);
            System.out.println("Removido o aeroporto da sigla: " + valor);
        } else {
            System.out.println(valor + " não encontrado!!");
        }
    }


    public void consultarSigla(BufferedReader teclado) throws Exception {
        listarAeroportos();
        String valor;

        do {
            System.out.print("Informe a sigla do aeroporto: ");
            valor = teclado.readLine();

            if(aeroportos.containsKey(valor)) {

                Aeroporto a = aeroportos.get(valor);

                System.out.println("Informações:");
                System.out.println("Nome: " + a.getNome());
                System.out.println("Cidade: " + a.getCidade());
                System.out.println("Altitude: " + a.getAltitude());

            } else {
                System.out.print("Sigla inválida, tente novamente: ");
            }

        } while (!aeroportos.containsKey(valor));
    }
 
}
