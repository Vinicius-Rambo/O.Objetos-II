import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ExReflection {
    public static void main(String[] args) {
        try{
            //se sei o nome da classe
            //Class c = class.forName("Veiculo");

            Veiculo v = new Veiculo();
            Class<?> c = v.getClass(); //Se recebo um objeto que não sei seu tipo.
            //<?> estou informando que vou receber um objeto só não sei qual classe

            System.out.println(c.getName()); //Retorna qual é o objeto.

            System.out.println("Atributos");
            Field fields[] = c.getDeclaredFields();
            for (Field f : fields) {
                System.out.println("Detalhado: " + f.toString());
                System.out.println("Somente nome: " + f.getName() + "- tipo: " + f.getType());
                
            }
                System.out.println("-----> Metodos");
                Method methods[] = c.getDeclaredMethods();
                
                for (Method m : methods) {
                    System.out.println("Detalhado: " + m.toString());
                    System.out.println("Detalhado: " + m.getName());
                    Parameter parameters[] = m.getParameters();

                    for (Parameter p : parameters) {
                        //Nome do param só é armazenado no .class se compilar com -parameters


                        System.out.println(p.getName()); //Nome do parametro
                        System.out.println(p.getParameterizedType());   
                    }
                    System.out.println("---------------------------------------------------------------");
                    System.out.println("\n");
                    if(m.getName().equals("setAno")){ //Caso ache o metodo "Set ano"
                        m.invoke(v, 2026);            //Adiciona no objeto V, o valor de 2026
                    }
                
                }
            

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
