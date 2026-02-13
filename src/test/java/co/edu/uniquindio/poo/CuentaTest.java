package co.edu.uniquindio.poo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    private Ahorro cuentaAhorro;
    private Corriente cuentaCorriente;
    private Nomina cuentaNomina;

    @BeforeEach
    void setUp() {
        cuentaAhorro = new Ahorro("001", "Juan Pérez", "2024-01-15", 200000);
        cuentaCorriente = new Corriente("002", "María López", "2024-01-20", 500000);
        cuentaNomina = new Nomina("003", "Carlos Gómez", "2024-02-01", 300000);
    }

    /**
     * Test 1: Verificar que el depósito funciona correctamente en una cuenta activa
     */
    @Test
    void testDepositoExitoso() throws Cuenta.CuentaInactivaException, Cuenta.MontoInvalidoException {
        // Arrange
        double saldoInicial = cuentaAhorro.getSaldoActual();
        double cantidadDepositar = 50000;
        double saldoEsperado = saldoInicial + cantidadDepositar;

        // Desbloquear cuenta para asegurar que está activa
        cuentaAhorro.desbloquear();

        // Act
        cuentaAhorro.depositar(cantidadDepositar);

        // Assert
        assertEquals(saldoEsperado, cuentaAhorro.getSaldoActual(),
                "El saldo después del depósito debe ser el saldo inicial más la cantidad depositada");
    }

    /**
     * Test 2: Verificar que no se puede depositar en una cuenta bloqueada
     */
    @Test
    void testDepositoEnCuentaBloqueada() {
        // Arrange
        cuentaCorriente.bloquear();
        double cantidadDepositar = 100000;

        // Act & Assert
        assertThrows(Cuenta.CuentaInactivaException.class,
                () -> cuentaCorriente.depositar(cantidadDepositar),
                "Debe lanzar CuentaInactivaException al intentar depositar en una cuenta bloqueada");
    }

    /**
     * Test 3: Verificar que no se pueden depositar montos negativos o cero
     */
    @Test
    void testDepositoMontoInvalido() {
        // Arrange
        cuentaNomina.desbloquear();
        double montoCero = 0;
        double montoNegativo = -5000;

        // Act & Assert - monto cero
        assertThrows(Cuenta.MontoInvalidoException.class,
                () -> cuentaNomina.depositar(montoCero),
                "Debe lanzar MontoInvalidoException al intentar depositar cero");

        // Act & Assert - monto negativo
        assertThrows(Cuenta.MontoInvalidoException.class,
                () -> cuentaNomina.depositar(montoNegativo),
                "Debe lanzar MontoInvalidoException al intentar depositar un monto negativo");
    }
}