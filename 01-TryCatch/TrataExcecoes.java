import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TrataExcecoes{
    public static void main(String[] args) {
        TrataExcecoes te = new TrataExcecoes();
        te.lerArquivos();
    }

    public void lerArquivos(){
        try {
            String arqEntrada = "arq.txt";    
            BufferedReader reader = new BufferedReader(new FileReader(arqEntrada));
            String linha;
            while((linha = reader.readLine()) != null){
                System.out.println(linha + "\n");
            }

        }catch (FileNotFoundException e1){
            System.out.println("Arquivo Não encontrado.");

        } catch (IOException e2) {
            System.out.println("Erro na leitura do arquivo.");
        
        } catch (Exception e3){
            System.out.println("Erro inesperado");
            System.out.println("Detalhes: " + e3.getMessage());
        
        }finally{
            System.out.println("Encerrado");
        }

    }
}