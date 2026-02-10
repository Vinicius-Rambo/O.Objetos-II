import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Main m1 = new Main();

        System.out.println("Digite o nome de seu arquivo: ");        
        String res = m1.lerArquivo();

        System.out.println(res);
    }

    public String lerArquivo(){
        String retorno = "ok";

        try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            String nomeArq = teclado.readLine() + ".csv";
            
            BufferedReader reader = new BufferedReader(new FileReader(nomeArq));
            reader.readLine(); //Pular cabeçalho.

            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] col = linha.split(";"); 

                System.out.println("Nome: " + col[1]);
                System.out.println("Data: " + col[2]);
            }

        } catch (FileNotFoundException e1) {
            retorno = "Arquivo não encontrado";
        
        } catch (IOException e2) {
            retorno = "Ero na leitura do arquivo";
    
        } catch (Exception e3){
            retorno = "Erro inesperado";
            retorno += "Detalhes:  " + e3.getMessage();
        }

          return retorno;

    }
}
