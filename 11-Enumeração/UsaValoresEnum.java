public class UsaValoresEnum {
    
    public static void main(String[] args){
        System.out.println("Dia: " + DiaSemanaEnum.QUA);
        System.out.println("Dia: " + DiaSemanaEnum.QUA.getDia());

        System.out.println("Campus: " + CampiIfprEnum.FOZ.getNome() + " Inauguração: " + CampiIfprEnum.FOZ.getAnoCriacao());
        
        System.out.println("--------------------------------------------------");
        System.out.println("Nome: " + Livros.SAPIENS.getNome());
        System.out.println("Ano: " + Livros.SAPIENS.getAno());
        System.out.println("Genero: " + Livros.SAPIENS.getGenero());
    } 
}
