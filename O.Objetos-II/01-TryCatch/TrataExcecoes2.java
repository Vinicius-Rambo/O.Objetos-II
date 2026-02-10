import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TrataExcecoes2{
    public static void main(String[] args) {
        TrataExcecoes2 te = new TrataExcecoes2();
        String res = te.lerArquivos("arq.txt");
    
        System.out.println(res);
    
    }

    public String lerArquivos(String nomeArq){
        String retorno = "OK";
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomeArq));
            String linha;
            while((linha = reader.readLine()) != null){
                System.out.println(linha + "\n");
            }

        }catch (FileNotFoundException e1){
            retorno = "Arquivo Não encontrado";

        } catch (IOException e2) {
            retorno = "Erro na leitura do arquivo.";
        
        } catch (Exception e3){
            retorno = "Erro inesperado";
            retorno += "Detalhes: " + e3.getMessage();
        
        }finally{
            retorno += " Encerrado";
        }

        return retorno;
    }
}