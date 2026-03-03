import java.io.BufferedReader;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Assistencia {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    // Cadastrar Cliente
    public void cadastrarCliente(BufferedReader teclado) throws Exception {

        Cliente c = new Cliente();
        System.out.print("Nome: ");
        c.setNome(teclado.readLine());
        System.out.print("CPF: ");
        c.setCpf(teclado.readLine());
        System.out.print("Email: ");
        c.setEmail(teclado.readLine());
        System.out.print("Fone: ");
        c.setFone(teclado.readLine());

        clientes.add(c);

        System.out.println("Cliente cadastrado com sucesso!");
    }

    // Listar Clientes
    public void listarClientes() {

        if (clientes.isEmpty()) { //Verifica se tem algum Cliente
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (int i = 0; i < clientes.size(); i++) { //Mostra todos os clintes.
            System.out.println("[" + (i + 1) + "] " + clientes.get(i).getNome()); //i+1 para sempre começar no 1 em vez de 0.
        }
    }

    // Cadastrar Orçamento
    public void cadastrarOrcamento(BufferedReader teclado) throws Exception {

    if (clientes.isEmpty()) {
        System.out.println("Nenhum cliente cadastrado.");
        return;
    }

    listarClientes();

    System.out.print("Escolha o número do cliente: ");
    int indice = Integer.parseInt(teclado.readLine()) - 1;

    if (indice < 0 || indice >= clientes.size()) {
        System.out.println("Cliente inválido.");
        return;
    }

    Orcamento o = new Orcamento();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Formatação 

    System.out.print("ID do orçamento: ");
    o.setId(Integer.parseInt(teclado.readLine()));

    System.out.print("Valor total: ");
    o.setValorTotal(Double.parseDouble(teclado.readLine()));

    System.out.print("Data de criação (dd/MM/yyyy): ");
    LocalDate dataCriado = LocalDate.parse(teclado.readLine(), formatter);

    System.out.print("Data limite (dd/MM/yyyy): ");
    LocalDate dataLimite = LocalDate.parse(teclado.readLine(), formatter);

    if (dataLimite.isBefore(dataCriado)) { //Verificação se a data limite é maior que a de criação.
        System.out.println("Data limite não pode ser menor que a data de criação!");
        return;
    }

    o.setDataCriado(dataCriado.format(formatter));
    o.setDataLimite(dataLimite.format(formatter));

    // =================================

    o.setStatus(true);

    clientes.get(indice).adicionarOrcamento(o);

    System.out.println("Orçamento cadastrado com sucesso!");
}


    // Listar Orçamentos
    public void listarOrcamentos(BufferedReader teclado) throws Exception {

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        listarClientes();

        System.out.print("Escolha o número do cliente: ");
        int indice = Integer.parseInt(teclado.readLine()) - 1;

        if (indice < 0 || indice >= clientes.size()) {
            System.out.println("Cliente inválido.");
            return;
        }

        Cliente c = clientes.get(indice);

        if (c.getOrcamentos().isEmpty()) {
            System.out.println("Esse cliente não possui orçamentos.");
            return;
        }

        for (Orcamento o : c.getOrcamentos()) {
            System.out.println("\nID: " + o.getId());
            System.out.println("Valor: " + o.getValorTotal());
            System.out.println("Data criação: " + o.getDataCriado());
            System.out.println("Data limite: " + o.getDataLimite());
            System.out.println("Status: " + (o.isStatus() ? "Ativo" : "Finalizado"));
            System.out.println("---------------------------");
        }
    }
}
