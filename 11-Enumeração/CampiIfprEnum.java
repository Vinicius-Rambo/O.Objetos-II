public enum CampiIfprEnum {
    FOZ("IFPR Campus Foz do Iguaçu", 2009, "(45) 3422-5300"),
    CASCAVEL("IFPR Campus Cascavel", 2011, "(45) 3422-3444"),
    CURITIBA("IFPR Campus Curitiba", 2008, "(41) 3422-3400"),
    CAPANEMA("IFPR Campus Capanema", 2014, "(48) 3422-6500");

    String nome, fone;
    int anoCriacao;

    CampiIfprEnum(String nome, int ano, String fone){
        this.nome = nome;
        this.anoCriacao = ano;
        this.fone = fone;
    }

    public String getNome() {
        return nome;
    }

    public String getFone() {
        return fone;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    

}

