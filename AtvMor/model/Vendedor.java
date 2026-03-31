package model;

public class Vendedor {
    private int codigo;
    private String nome;
    private String contato;
    private String email;
    private String cpf;
    private String numCracha;
    private int anoAdmissao;
    private Cargo cargo; //Enum

    //Codigo
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    //Nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Contato
    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    //Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //CPF
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    //Cracha
    public String getNumCracha() {
        return numCracha;
    }

    public void setNumCracha(String numCracha) {
        this.numCracha = numCracha;
    }

    //Ano Admissao
    public int getAnoAdmissao() {
        return anoAdmissao;
    }

    public void setAnoAdmissao(int anoAdmissao) {
        this.anoAdmissao = anoAdmissao;
    }

    //Cargo
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
