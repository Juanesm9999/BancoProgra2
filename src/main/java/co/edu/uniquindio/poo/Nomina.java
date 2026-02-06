package co.edu.uniquindio.poo;

public class Nomina extends Cuenta{

    private double COMISION_SIN_SALARIO = 8000;
    private int mesesSinSalario;
    private boolean recibiSalarioEsteMes;

    public Nomina(String numCuenta, String titular, String fechaApertura, double saldoActual,double COMISION_SIN_SALARIO, int mesesSinSalario, boolean recibiSalarioEsteMes) {
        super(numCuenta, titular, fechaApertura, saldoActual);
        this.COMISION_SIN_SALARIO = COMISION_SIN_SALARIO;
        this.mesesSinSalario = mesesSinSalario;
        this.recibiSalarioEsteMes = recibiSalarioEsteMes;
    }

    // -------------------------------------------------- GETTERS Y SETTERS -----------------------------------------------

    public double getCOMISION_SIN_SALARIO() {
        return COMISION_SIN_SALARIO;
    }

    public void setCOMISION_SIN_SALARIO(double COMISION_SIN_SALARIO) {
        this.COMISION_SIN_SALARIO = COMISION_SIN_SALARIO;
    }

    public int getMesesSinSalario() {
        return mesesSinSalario;
    }

    public void setMesesSinSalario(int mesesSinSalario) {
        this.mesesSinSalario = mesesSinSalario;
    }

    public boolean isRecibiSalarioEsteMes() {
        return recibiSalarioEsteMes;
    }

    public void setRecibiSalarioEsteMes(boolean recibiSalarioEsteMes) {
        this.recibiSalarioEsteMes = recibiSalarioEsteMes;
    }

    @Override
    public String toString() {
        return "Nomina{" +
                "COMISION SIN SALARIO =" + COMISION_SIN_SALARIO +
                ", Meses sin salario =" + mesesSinSalario +
                ", Recibí Salario Este Mes =" + recibiSalarioEsteMes +
                ", Número de Cuenta ='" + numCuenta + '\'' +
                ", Titular ='" + titular + '\'' +
                ", Fecha de Apertura ='" + fechaApertura + '\'' +
                ", saldo Actual =" + saldoActual +
                '}';
    }


    // -------------------------------------------- MÉTODOS ---------------------------------------

    public double calcularComisionMensual() {
        return 0 ;
    }

    public void depositarSalario (double saldo){
    }

    public void procesarFinDeMes(){

    }

    public Corriente conventirACuentaCorriente (Corriente corriente){
        return corriente;
    }

    @Override
    public String mostrarInfo() {
        return toString();
    }
}
