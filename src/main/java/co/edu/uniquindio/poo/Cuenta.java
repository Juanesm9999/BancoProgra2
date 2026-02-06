package co.edu.uniquindio.poo;

public abstract class Cuenta {
    protected String numCuenta, titular, fechaApertura;
    protected double saldoActual;

    public Cuenta(String numCuenta, String titular, String fechaApertura, double saldoActual) {
        this.numCuenta = numCuenta;
        this.titular = titular;
        this.fechaApertura = fechaApertura;
        this.saldoActual = saldoActual;
    }

    // -------------------------------------------------- GETTERS Y SETTERS -----------------------------------------------


    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    //----------------------------------------- MÉTODOS COMUNES ------------------------------------------------

    public void depositar (double saldo){
        this.saldoActual += saldo;
    }

    public void retirar (double saldo){
        this.saldoActual -= saldo;
    }

    public void bloquear (){

    }

    public void desbloquear() {

    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numCuenta='" + numCuenta + '\'' +
                ", titular='" + titular + '\'' +
                ", fechaApertura='" + fechaApertura + '\'' +
                ", saldoActual=" + saldoActual +
                '}';
    }

    public abstract String mostrarInfo();


}
