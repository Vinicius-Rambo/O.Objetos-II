import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {

    static BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        try {
            System.out.print("Digite o nome do arquivo (.csv): ");
            String nomeArq = teclado.readLine() + ".csv";
            lerArquivo(nomeArq);

        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    //Metodos
    public static void lerArquivo(String arquivo) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("Dados/" + arquivo));

            br.readLine(); // pula cabeçalho

            String linha;
            boolean arquivoVazio = true;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Formatador em Dia/Mes/Ano
            while ((linha = br.readLine()) != null) { //Continua até a vazia.

                arquivoVazio = false;

                String[] col = linha.split(";");

                String nome = col[0];
                String dataTexto = col[1];

                try {
                    LocalDate dataPedido = LocalDate.parse(dataTexto, formatter);
                    LocalDate dataEntrega = dataPedido.plusDays(7);

                    System.out.println("Nome: " + nome);
                    System.out.println("Data do pedido: " + dataPedido.format(formatter));
                    System.out.println("Data limite de entrega: " + dataEntrega.format(formatter));
                    System.out.println("-----------------------------------");

                } catch (DateTimeParseException e) {
                    System.out.println("Data inválida para o cliente: " + nome);
                    System.out.println("-----------------------------------");

                }
            }

            if (arquivoVazio) {
                br.close();
                throw new VazioException();
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERRO: Arquivo não encontrado.");

        } catch (VazioException e) {
            System.out.println(e.getMessage());

        } catch (IOException e) {
            System.out.println("Erro na leitura do arquivo.");

        } catch (Exception e) {
            System.out.println("Erro inesperado.");
        }
    }
}
