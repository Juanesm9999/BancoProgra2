package co.edu.uniquindio.poo;

public class Ahorro extends Cuenta {
    private double SALDO_MINIMO =  100000;
    private double TAZAS_INTERES_ANUAL = 0.036;

    public  Ahorro(String numCuenta, String titular, String fechaApertura, double saldoActual, double SALDO_MINIMO, double TAZAS_INTERES_ANUAL) {
        super(numCuenta, titular, fechaApertura, saldoActual);
        this.SALDO_MINIMO = SALDO_MINIMO;
        this.TAZAS_INTERES_ANUAL = TAZAS_INTERES_ANUAL;
    }

    // ---------------------------- GETTERS YU SETTERS ------------------------------------

    public double getSALDO_MINIMO() {
        return SALDO_MINIMO;
    }

    public void setSALDO_MINIMO(double SALDO_MINIMO) {
        this.SALDO_MINIMO = SALDO_MINIMO;
    }

    public double getTAZAS_INTERES_ANUAL() {
        return TAZAS_INTERES_ANUAL;
    }

    public void setTAZAS_INTERES_ANUAL(double TAZAS_INTERES_ANUAL) {
        this.TAZAS_INTERES_ANUAL = TAZAS_INTERES_ANUAL;
    }

    @Override
    public String toString() {
        return "Ahorro{" +
                "Saldo Mínimo =" + SALDO_MINIMO +
                ", Tazas de interés anual =" + TAZAS_INTERES_ANUAL +
                ", Número de cuenta ='" + numCuenta + '\'' +
                ", Titular ='" + titular + '\'' +
                ", Fecha de Apertura ='" + fechaApertura + '\'' +
                ", Saldo Actual =" + saldoActual +
                '}';
    }

    // --------------------------------------- MÉTODOS -----------------------------------------

    public double calcularComisionMensual (){
        return SALDO_MINIMO + TAZAS_INTERES_ANUAL;
    }

    public double calcularInteresesMensuales (){
        return SALDO_MINIMO - TAZAS_INTERES_ANUAL;
    }

    public void aplicarInteres (){

    }

    @Override
    public String mostrarInfo (){
        return toString();
    }
}
