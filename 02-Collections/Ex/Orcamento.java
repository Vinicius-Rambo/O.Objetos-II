public class Orcamento {
    private int id;
    private double valorTotal;
    private boolean status;
    private String dataCriado;
    private String dataLimite;
    
    //ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Valor total
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    //Is status
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //Data Criado
    public String getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(String dataCriado) {
        this.dataCriado = dataCriado;
    }

    //Data limite
    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

}
