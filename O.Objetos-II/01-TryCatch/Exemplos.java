public class Exemplos{
    public static void main(String args[]) throws Exception{
        Exemplos ee = new Exemplos();
        ee.calcular();
    }

    public void calcular(){
        try{
           OpMath opMath = new OpMath();
           float res = opMath.dividir(12, 3);
           System.out.println(res);
           res = opMath.dividir(12, 0);
           System.out.println(res);

        } catch(DivisaoPorZeroException e1 ) {
            System.out.println(e1.getMessage());

        }
    }
}