public enum Livros {
    DOM_CASMURRO("Dom Casmurro", 1899, "Romance"),
    DUNA("Duna", 1965, "Ficção Cientifica"),
    ILUMINADO("O iluminado", 1977, "Terror / Suspense"),
    SAPIENS("Sapiens Uma Breve História da Humanidade", 2011, "Historia");
    
    String nome, genero;
    int ano;

    Livros(String nome, int ano, String genero){
        this.nome = nome;
        this.ano = ano;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public int getAno() {
        return ano;
    }
}
