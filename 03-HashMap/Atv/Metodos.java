
import java.io.BufferedReader;
import java.util.HashMap;

public class Metodos {
    HashMap<String, Aeroporto> aeroportos = new HashMap<String, Aeroporto>();
    
    //Cadastrar Aeroportos
    public void cadastrarAeroportos(BufferedReader teclado) throws Exception {
        Aeroporto a = new Aeroporto();
        System.out.println("- - - Cadastro de Aeroportos - - -");

        System.out.println("Digite o Nome do Aeroporto: ");
        a.setNome(teclado.readLine());

        System.out.println("Digite a cidade do Aeroporto: ");
        a.setCidade(teclado.readLine());

        System.out.println("Digite a altitude que o Aeroporto trabalha: ");
        a.setAltitude(teclado.readLine());

        System.out.println("Digite a sigla do Aeroporto: ");
        String sigla = teclado.readLine();

        aeroportos.put(sigla, a);

    }

    public void listarAeroportos() throws Exception{ //Fazer
    }
}
