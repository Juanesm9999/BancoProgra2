package co.edu.uniquindio.poo;

public class Corriente extends Cuenta {

    private double LIMITE_SOBREGIRO = 500000;
    private double COMISION_MENSUAL_FIJA = 15000;
    private double TASA_INTERES_SOBREGIRO = 0.02;

    public Corriente(String numCuenta, String titular, String fechaApertura, double saldoActual, double LIMITE_SOBREGIRO, double COMISION_MENSUAL_FIJA, double TASA_INTERES_SOBREGIRO) {
        super(numCuenta, titular, fechaApertura, saldoActual);
        this.LIMITE_SOBREGIRO = LIMITE_SOBREGIRO;
        this.COMISION_MENSUAL_FIJA = COMISION_MENSUAL_FIJA;
        this.TASA_INTERES_SOBREGIRO = TASA_INTERES_SOBREGIRO;
    }

    //-------------------------------------------- GETTERS Y SETTERS ------------------------------------------------


    public double getLIMITE_SOBREGIRO() {
        return LIMITE_SOBREGIRO;
    }

    public void setLIMITE_SOBREGIRO(double LIMITE_SOBREGIRO) {
        this.LIMITE_SOBREGIRO = LIMITE_SOBREGIRO;
    }

    public double getCOMISION_MENSUAL_FIJA() {
        return COMISION_MENSUAL_FIJA;
    }

    public void setCOMISION_MENSUAL_FIJA(double COMISION_MENSUAL_FIJA) {
        this.COMISION_MENSUAL_FIJA = COMISION_MENSUAL_FIJA;
    }

    public double getTASA_INTERES_SOBREGIRO() {
        return TASA_INTERES_SOBREGIRO;
    }

    public void setTASA_INTERES_SOBREGIRO(double TASA_INTERES_SOBREGIRO) {
        this.TASA_INTERES_SOBREGIRO = TASA_INTERES_SOBREGIRO;
    }

    @Override
    public String toString() {
        return "Corriente{" +
                "LIMITE SOBREGIRO =" + LIMITE_SOBREGIRO +
                ", COMISION MENSUAL FIJA =" + COMISION_MENSUAL_FIJA +
                ", TASA INTERES SOBREGIRO =" + TASA_INTERES_SOBREGIRO +
                ", Número de Cuenta ='" + numCuenta + '\'' +
                ", Titular ='" + titular + '\'' +
                ", Fecha de Apertura ='" + fechaApertura + '\'' +
                ", Saldo Actual =" + saldoActual +
                '}';
    }



    //------------------------------------- MÉTODOS -------------------------------------------

    public double calcularComisionMensual() {
        return 0 ;
    }

    public boolean estEnSobregiro(){
        return false;
    }

    public double calcularInteresesMensuales (){
        return 0;
    }

    public void aplicarComisionMensual(){

    }

    @Override
    public String mostrarInfo() {
        return toString();
    }
}
