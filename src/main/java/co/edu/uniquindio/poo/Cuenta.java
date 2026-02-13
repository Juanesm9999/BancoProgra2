package co.edu.uniquindio.poo;

import java.time.LocalDate;

public abstract class Cuenta {
    protected String numCuenta, titular;
    protected LocalDate fechaApertura;
    protected double saldoActual;
    protected EstadoCuenta estado;

    public Cuenta(String numCuenta, String titular, String fechaApertura, double saldoActual) {
        this.numCuenta = numCuenta;
        this.titular = titular;
        this.fechaApertura = LocalDate.parse(fechaApertura);
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
        return String.valueOf(fechaApertura);
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = LocalDate.parse(fechaApertura);
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    //----------------------------------------- MÉTODOS COMUNES ------------------------------------------------

    public void depositar(double cantidad) throws CuentaInactivaException, MontoInvalidoException {
        if (estado != EstadoCuenta.ACTIVA) {
            throw new CuentaInactivaException(estado);
        }

        if (cantidad <= 0) {
            throw new MontoInvalidoException(cantidad);
        }

        this.saldoActual += cantidad;
        System.out.println("Depósito exitoso. Nuevo saldo: " + this.saldoActual);
    }

    public abstract void retirar(double cantidad) throws CuentaInactivaException, MontoInvalidoException,
            SaldoInsuficienteException, SaldoMinimoException,
            LimiteSobregiroExcedidoException;


    public void bloquear() {
        this.estado = EstadoCuenta.BLOQUEADA;
        System.out.println("La cuenta ha sido BLOQUEADA.");
    }

    public void desbloquear() {
        this.estado = EstadoCuenta.ACTIVA;
        System.out.println("La cuenta ha sido DESBLOQUEADA.");
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

    public static class SaldoInsuficienteException extends Exception {
        private double saldoActual;
        private double cantidadSolicitada;

        public SaldoInsuficienteException(double saldoActual, double cantidadSolicitada) {
            super("Saldo insuficiente. Saldo actual: $" + saldoActual +
                    ", cantidad solicitada: $" + cantidadSolicitada);
            this.saldoActual = saldoActual;
            this.cantidadSolicitada = cantidadSolicitada;
        }
    }


    public static class CuentaInactivaException extends Exception {
        private EstadoCuenta estadoActual;

        public CuentaInactivaException(EstadoCuenta estadoActual) {
            super("No se puede realizar la operación. La cuenta está " + estadoActual);
            this.estadoActual = estadoActual;
        }
    }


    public static class MontoInvalidoException extends Exception {
        private double monto;

        public MontoInvalidoException(double monto) {
            super("Monto inválido: $" + monto + ". El monto debe ser mayor que cero.");
            this.monto = monto;
        }
    }


    public static class LimiteSobregiroExcedidoException extends Exception {
        private double limiteSobregiro;
        private double sobregiroRequerido;

        public LimiteSobregiroExcedidoException(double limiteSobregiro, double sobregiroRequerido) {
            super("Se excede el límite de sobregiro. Límite: $" + limiteSobregiro +
                    ", sobregiro requerido: $" + Math.abs(sobregiroRequerido));
            this.limiteSobregiro = limiteSobregiro;
            this.sobregiroRequerido = sobregiroRequerido;
        }
    }


    public static class SaldoMinimoException extends Exception {
        private double saldoMinimo;
        private double saldoResultante;

        public SaldoMinimoException(double saldoMinimo, double saldoResultante) {
            super("No se puede realizar el retiro. Se viola el saldo mínimo de $" + saldoMinimo +
                    ". Saldo resultante sería: $" + saldoResultante);
            this.saldoMinimo = saldoMinimo;
            this.saldoResultante = saldoResultante;
        }
    }


    public static class CuentaDuplicadaException extends Exception {
        private String numeroCuenta;

        public CuentaDuplicadaException(String numeroCuenta) {
            super("Ya existe una cuenta con el número: " + numeroCuenta);
            this.numeroCuenta = numeroCuenta;
        }
    }


}

