public class Division implements Calculos{
    @Override
    public double calcular(double a, double b){
        if (b == 0){
            throw new ArithmeticException("No se puede dividir por cero");
        } else {
            return a / b;
        }
    }
}
