public class Orcamento {

    private int id;
    private double valorTotal;
    private boolean status;
    private String dataCriado;
    private String dataLimite;

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(String dataCriado) {
        this.dataCriado = dataCriado;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }
}
