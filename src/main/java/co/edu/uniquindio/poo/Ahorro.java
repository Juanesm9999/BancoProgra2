package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Ahorro extends Cuenta {
    private double SALDO_MINIMO =  100000;
    private double TASA_INTERES_ANUAL = 0.036;

    public  Ahorro(String numCuenta, String titular, String fechaApertura, double saldoActual) {
        super(numCuenta, titular, fechaApertura, saldoActual);
        this.SALDO_MINIMO = SALDO_MINIMO;
        this.TASA_INTERES_ANUAL = TASA_INTERES_ANUAL;
    }

    // ---------------------------- GETTERS Y SETTERS ------------------------------------

    public double getSALDO_MINIMO() {
        return SALDO_MINIMO;
    }

    public void setSALDO_MINIMO(double SALDO_MINIMO) {
        this.SALDO_MINIMO = SALDO_MINIMO;
    }

    public double getTAZAS_INTERES_ANUAL() {
        return TASA_INTERES_ANUAL;
    }

    public void setTAZAS_INTERES_ANUAL(double TAZAS_INTERES_ANUAL) {
        this.TASA_INTERES_ANUAL = TAZAS_INTERES_ANUAL;
    }

    @Override
    public String toString() {
        return "Ahorro{" +
                "Saldo Mínimo =" + SALDO_MINIMO +
                ", Tazas de interés anual =" + TASA_INTERES_ANUAL +
                ", Número de cuenta ='" + numCuenta + '\'' +
                ", Titular ='" + titular + '\'' +
                ", Fecha de Apertura ='" + fechaApertura + '\'' +
                ", Saldo Actual =" + saldoActual +
                '}';
    }

    // --------------------------------------- MÉTODOS -----------------------------------------

    @Override
    public void retirar(double cantidad) {

        if (estado != EstadoCuenta.ACTIVA) {
            System.out.println("La cuenta no está activa.");
            return;
        }

        if (cantidad <= 0) {
            System.out.println("Cantidad inválida.");
            return;
        }

        if ((saldoActual - cantidad) < SALDO_MINIMO) {
            System.out.println("No se puede retirar. Se viola el saldo mínimo.");
        } else {
            saldoActual -= cantidad;
            System.out.println("Retiro exitoso.");
        }
    }



    public double calcularComisionMensual() {
        return 0; // La cuenta de ahorros no cobra comisión mensual
    }

    public double calcularInteresesMensuales() {
        return saldoActual * (TASA_INTERES_ANUAL / 12);
    }


    public void aplicarInteres() {

        if (estado == EstadoCuenta.ACTIVA) {
            double interes = calcularInteresesMensuales();
            saldoActual += interes;
            System.out.println("Interés aplicado: " + interes);
        }
    }


    @Override
    public String mostrarInfo (){
        return toString();
    }
}
