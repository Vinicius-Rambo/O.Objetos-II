package Classes;

import java.lang.reflect.Field;

public class GeradorJson {
    public static String serializar(Object obj) throws Exception{
        if(obj == null){
            return null;
        }

        Class<?> classe = obj.getClass();
        Field[] campos = classe.getDeclaredFields();
        String conteudo = "";

        for (Field campo : campos) {
            String nome = campo.getName();
            campo.setAccessible(true);
            Object valor = campo.get(obj);
            
            String valorFormatado;
            if(valor instanceof String){
                valorFormatado = "\"" + valor  +"\"";

            }else{
                valorFormatado = "\"" + String.valueOf(valor) + "\"";
            }
            if(conteudo != ""){
                conteudo +=", ";
            }

            conteudo += "\"" + nome + "\":" + valorFormatado;
        
        }

        return "{" + conteudo + "}";
    }


}
