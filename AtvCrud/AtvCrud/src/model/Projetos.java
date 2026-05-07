package model;

public class Projetos {

    private int id;
    private String empresaResponsavel;
    private String tipoDeProjeto;
    private String nomeDoProjeto;
    private String dataDeInicio;
    private String dataDeFinalizacao;
    private String status;

    // ID
    public int getId() {g
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Empresa Responsável
    public String getEmpresaResponsavel() {
        return empresaResponsavel;
    }

    public void setEmpresaResponsavel(String empresaResponsavel) {
        this.empresaResponsavel = empresaResponsavel;
    }

    // Tipo de Projetos
    public String getTipoDeProjeto() {
        return tipoDeProjeto;
    }

    public void setTipoDeProjeto(String tipoDeProjeto) {
        this.tipoDeProjeto = tipoDeProjeto;
    }

    // Nome do Projetos
    public String getNomeDoProjeto() {
        return nomeDoProjeto;
    }

    public void setNomeDoProjeto(String nomeDoProjeto) {
        this.nomeDoProjeto = nomeDoProjeto;
    }

    // Data de Início
    public String getDataDeInicio() {
        return dataDeInicio;
    }

    public void setDataDeInicio(String dataDeInicio) {
        this.dataDeInicio = dataDeInicio;
    }

    // Data de Finalização
    public String getDataDeFinalizacao() {
        return dataDeFinalizacao;
    }

    public void setDataDeFinalizacao(String dataDeFinalizacao) {
        this.dataDeFinalizacao = dataDeFinalizacao;
    }

    // Status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}