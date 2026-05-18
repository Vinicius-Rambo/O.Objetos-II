public enum DiaSemanaEnum {
    SEG("Segunda-feira"),
    TER("Terça-feira"),
    QUA("Quarta-feira"),
    QUI("Quinta-feira"),
    SEX("Sexta-feira"),
    SAB("Sábado"),
    DOM("Domingo");

    private String dia;

    DiaSemanaEnum(String nomeDia){
        this.dia = nomeDia;
    }

    public String getDia(){
        return this.dia;
        
    }

}
