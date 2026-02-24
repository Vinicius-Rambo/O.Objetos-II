
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String fone;
    private ArrayList <Orcamento> orcamentos; //Declaração.

    //Nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    //CPF
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //Fone
    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }        
    
    
}
