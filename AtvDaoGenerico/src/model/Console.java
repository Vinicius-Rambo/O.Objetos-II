package src.model;

public class Console {

    private int id;
    private String nome;
    private String fabricante;
    private int anoLancamento;
    private float armazenamento;
    private String portatil;

    public Console() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public float getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(float armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getPortatil() {
        return portatil;
    }

    public void setPortatil(String portatil) {
        this.portatil = portatil;
    }
}