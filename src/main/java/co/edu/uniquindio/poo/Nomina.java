package co.edu.uniquindio.poo;

public class Nomina extends Cuenta{

    private double COMISION_SIN_SALARIO = 8000;
    private int mesesSinSalario;
    private boolean recibiSalarioEsteMes;

    public Nomina(String numCuenta, String titular, String fechaApertura, double saldoActual) {
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

        if (recibiSalarioEsteMes) {
            return 0;
        }

        return COMISION_SIN_SALARIO;
    }

    public void depositarSalario(double cantidad) {

        if (estado != EstadoCuenta.ACTIVA) {
            System.out.println("La cuenta no está activa.");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("Cantidad inválida.");
            return;
        }

        saldoActual += cantidad;
        recibiSalarioEsteMes = true;
        mesesSinSalario = 0;

        System.out.println("Salario depositado correctamente.");
    }

    public void procesarFinDeMes() {

        if (!recibiSalarioEsteMes) {
            mesesSinSalario++;
            saldoActual -= COMISION_SIN_SALARIO;
            System.out.println("Se cobró comisión por no recibir salario.");
        }

        if (mesesSinSalario >= 3) {
            System.out.println("La cuenta debe convertirse a Cuenta Corriente.");
        }

        recibiSalarioEsteMes = false;
    }

    public Corriente convertirACuentaCorriente() {

        return new Corriente(
                getNumCuenta(),
                getTitular(),
                getFechaApertura(),
                saldoActual
        );
    }

    @Override
    public void retirar(double cantidad) {

        if (estado != EstadoCuenta.ACTIVA) {
            System.out.println("Cuenta no activa.");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("Cantidad inválida.");
            return;
        }

        saldoActual -= cantidad;
    }


    @Override
    public String mostrarInfo() {
        return toString();
    }
}
