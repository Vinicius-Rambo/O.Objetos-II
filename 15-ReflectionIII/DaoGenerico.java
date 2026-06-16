import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoGenerico {
    private Connection conn;
    private Statement st;
    private final String TB_PREFIX = "tb_";
    private final String TB_SUFFIX = "s";

    private void conectar() {
        try {
            this.conn = GerenciadorConexao.pegarConexao();
            this.st = conn.createStatement();
        } catch (ClassNotFoundException e1) {
            System.out.println("Erro: " + e1.getMessage());
        } catch (SQLException e2) {
            System.out.println("Erro: " + e2.getMessage());
        }
    }

    private void desconectar() {
        try {
            st.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void inserir(Object o) {
        Class<?> c = o.getClass();
        Field fields[] = c.getDeclaredFields();
        try {
            String query = "INSERT INTO " + TB_PREFIX + c.getSimpleName().toLowerCase() + TB_SUFFIX;

            String campos = "(";
            String aliases = "VALUE(";
            boolean separar = false;
            for (Field f : fields) {
                if(separar){
                    campos += ", "; 
                    aliases += ", ";
                }
                campos += f.getName();
                aliases += "?";
                separar = true;
            }
            campos += ")";
            aliases += ");";
            query += campos + aliases;
            System.out.println("Query:  " + query);

            this.conectar();
            PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            int numParam = 0;

            for(Field f: fields){
                numParam++;
                f.setAccessible(true);
                //System.out.println("Tipo: " + f.getType());

                if(f.getType().isAssignableFrom(String.class)){
                    if(f.get(o) != null){
                        pst.setString(numParam, f.get(o).toString());
                    }else{
                        pst.setString(numParam, "");
                    }

                }else if(f.getType().isAssignableFrom(Integer.class) || f.getType().isAssignableFrom(Integer.TYPE)){
                    pst.setInt(numParam, Integer.parseInt(f.get(o).toString()));

                }else if(f.getType().isAssignableFrom(Float.class) || f.getType().isAssignableFrom(Float.TYPE)){
                    pst.setFloat(numParam, Float.parseFloat(f.get(o).toString()));

                }else if(f.getType().isAssignableFrom(LocalDate.class)){
                    if(f.get(o) != null){
                        pst.setDate(numParam, java.sql.Date.valueOf(f.get(o).toString()));
            
                    }else{
                        pst.setString(numParam, null);
                    }
                }
            }

            pst.executeUpdate();

        } catch (Exception e) {
            System.out.println("Erro ao inserir o registro: " + e.getMessage());

        } finally {
            this.desconectar();
        }
    }

    public <T> ArrayList<T> buscarTodos(Class<T> c){
        ArrayList<T> resultados = new ArrayList<>();
        Field fields[] = c.getDeclaredFields();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM " + TB_PREFIX + c.getSimpleName().toLowerCase() + TB_SUFFIX + ";");
            while (rs.next()){
                T objRet = c.getConstructor().newInstance();
                for(Field f: fields){
                    f.setAccessible(true);
                    if(f.getType().isAssignableFrom(String.class)){
                        f.set(objRet, rs.getString(f.getName().toString()));

                    }else if(f.getType().isAssignableFrom(Integer.class) || f.getType().isAssignableFrom(Integer.TYPE)){
                        f.set(objRet, rs.getInt(f.getName().toString()));
                        
                    }else if(f.getType().isAssignableFrom(Float.class) || f.getType().isAssignableFrom(Float.TYPE)){
                        f.set(objRet, rs.getFloat(f.getName().toString()));
                      
                    }else if(f.getType().isAssignableFrom(LocalDate.class)){
                        f.set(objRet, rs.getDate(f.getName().toString()).toLocalDate());
 
                    }
                }
                resultados.add(objRet);
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar os registro: " + e.getMessage());
        
        } finally{
            this.desconectar();
        }

        return resultados;
    }

    public <T> ArrayList<T> buscarTodosFiltro(Class<T> c,String campo ,String filtro){
        ArrayList<T> resultados = new ArrayList<>();
        Field fields[] = c.getDeclaredFields();
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM " + TB_PREFIX + c.getSimpleName().toLowerCase() + TB_SUFFIX + " WHERE " + campo + " LIKE '%" + filtro + "%';");
            while (rs.next()){
                T objRet = c.getConstructor().newInstance();
                for(Field f: fields){
                    f.setAccessible(true);
                    if(f.getType().isAssignableFrom(String.class)){
                        f.set(objRet, rs.getString(f.getName().toString()));

                    }else if(f.getType().isAssignableFrom(Integer.class) || f.getType().isAssignableFrom(Integer.TYPE)){
                        f.set(objRet, rs.getInt(f.getName().toString()));
                        
                    }else if(f.getType().isAssignableFrom(Float.class) || f.getType().isAssignableFrom(Float.TYPE)){
                        f.set(objRet, rs.getFloat(f.getName().toString()));
                      
                    }else if(f.getType().isAssignableFrom(LocalDate.class)){
                        f.set(objRet, rs.getDate(f.getName().toString()).toLocalDate());
 
                    }
                }
                resultados.add(objRet);
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar os registro: " + e.getMessage());
        
        } finally{
            this.desconectar();
        }

        return resultados;
    }

    public int excluir(Class<?> c, String chave, int valor){
        int qtde = 0;
        try{
            this.conectar();
            String comando = "DELETE FROM " + TB_PREFIX + c.getSimpleName().toLowerCase() + TB_SUFFIX + " WHERE " + chave + " = " + valor + ";";
            st.executeUpdate(comando);
            qtde = st.getUpdateCount();

        }catch (Exception e){
            System.out.println("Erro:" + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;

    }

    public <T> T consultar(Class<T> c,String campo ,String filtro){
        
        Field fields[] = c.getDeclaredFields();
        T objRet = null;
        try {
            this.conectar();
            ResultSet rs = st.executeQuery("SELECT * FROM " + TB_PREFIX + c.getSimpleName().toLowerCase() + TB_SUFFIX + " WHERE " + campo + " LIKE '%" + filtro + "%';");
            while (rs.next()){
                objRet = c.getConstructor().newInstance();
                for(Field f: fields){
                    f.setAccessible(true);
                    if(f.getType().isAssignableFrom(String.class)){
                        f.set(objRet, rs.getString(f.getName().toString()));

                    }else if(f.getType().isAssignableFrom(Integer.class) || f.getType().isAssignableFrom(Integer.TYPE)){
                        f.set(objRet, rs.getInt(f.getName().toString()));
                        
                    }else if(f.getType().isAssignableFrom(Float.class) || f.getType().isAssignableFrom(Float.TYPE)){
                        f.set(objRet, rs.getFloat(f.getName().toString()));
                      
                    }else if(f.getType().isAssignableFrom(LocalDate.class)){
                        f.set(objRet, rs.getDate(f.getName().toString()).toLocalDate());
 
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar os registro: " + e.getMessage());
        
        } finally{
            this.desconectar();
        }
        return objRet;
    }

    public int alterar(Object o, String chave, String id){
        Class<?> c = o.getClass();
        Field fields[] = c.getDeclaredFields();

        //monta a query para o pst
        String query = "UPDATE " + TB_PREFIX 
            + c.getSimpleName().toLowerCase() + TB_SUFFIX + " SET ";

        boolean separar = false;
        for (Field f : fields){
            if(!f.getName().equals(chave)){// não pode alterar a chave primária
                if(separar){
                    query += ", ";
                }
                separar = true;
                query += f.getName() + " = ?";
            }
        }
        query += " WHERE " + chave + " = " + id + ";";
        // System.out.println("query: " + query);
        // System.exit(9);

        //cria o pst
        int qtde = 0;
        try {
            this.conectar();
            PreparedStatement pst = conn.prepareStatement(
                query,Statement.RETURN_GENERATED_KEYS);
            
            //seta os valores dos params
            int numParam = 0;
            for (Field f : fields){
                if(!f.getName().equals(chave)){// não pode alterar a chave primária
                    numParam++;
                    f.setAccessible(true);
                    // System.out.println("Tipo: " + f.getType());
                    if(f.getType().isAssignableFrom(String.class)){
                        if(f.get(o) != null){
                            pst.setString(numParam, f.get(o).toString());
                        }else{
                            pst.setString(numParam, "");
                        }
                    }else if(f.getType().isAssignableFrom(Integer.class)
                        || f.getType().isAssignableFrom(Integer.TYPE)){
                        
                        pst.setInt(numParam,  Integer.parseInt(f.get(o).toString()));
                    }else if(f.getType().isAssignableFrom(Float.class)
                        || f.getType().isAssignableFrom(Float.TYPE)){
                        
                        pst.setFloat(numParam,  Float.parseFloat(f.get(o).toString()));
                    }else if(f.getType().isAssignableFrom(LocalDate.class)){
                        if(f.get(o) != null){
                            pst.setDate(numParam, 
                                java.sql.Date.valueOf(f.get(o).toString()));
                        }else{
                            pst.setString(numParam, null);
                        }     
                    }
                }
            }
            pst.executeUpdate();
            qtde = pst.getUpdateCount();
        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        }finally{
            this.desconectar();
        }
        return qtde;
      
    }
}
