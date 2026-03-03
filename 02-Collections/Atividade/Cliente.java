import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String cpf;
    private String email;
    private String fone;
    private ArrayList<Orcamento> orcamentos;

    public Cliente() {
        orcamentos = new ArrayList<>();
    }

    //Metodos para o Arraylist
    public void adicionarOrcamento(Orcamento o) { //Adicionar um orçamento ao cliente.
        orcamentos.add(o);
    }

    public ArrayList<Orcamento> getOrcamentos() { //Ver o orçamentos de um cliente.
        return orcamentos;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
}
