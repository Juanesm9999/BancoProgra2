package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre, nit;
    private List<Cuenta> listCuentas;

    public Banco (String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.listCuentas = new ArrayList<Cuenta>();
    }

    // ---------------------------------------- GETTERS Y SETTERS -------------------------------------

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    // ----------------------------------------- Métodos CRUD -------------------------------------------

    public boolean agregarCuenta(Cuenta cuenta) {

        if (buscarCuenta(cuenta.getNumCuenta()) != null) {
            System.out.println("Ya existe una cuenta con ese número.");
            return false;
        }

        listCuentas.add(cuenta);
        return true;
    }


    public Cuenta buscarCuenta(String numeroCuenta) {

        for (Cuenta cuenta : listCuentas) {
            if (cuenta.getNumCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }

        return null;
    }


    public boolean eliminarCuenta(String numeroCuenta) {

        Cuenta cuenta = buscarCuenta(numeroCuenta);

        if (cuenta != null) {
            listCuentas.remove(cuenta);
            return true;
        }

        return false;
    }


    public void mostrarCuentas() {

        if (listCuentas.isEmpty()) {
            System.out.println("No hay cuentas registradas.");
            return;
        }

        for (Cuenta cuenta : listCuentas) {
            System.out.println(cuenta.mostrarInfo());
            System.out.println("-----------------------------");
        }
    }


    public void procesarFinDeMes() {

        for (int i = 0; i < listCuentas.size(); i++) {

            Cuenta cuenta = listCuentas.get(i);

            if (cuenta instanceof Ahorro ahorro) {
                ahorro.aplicarInteres();
            }

            else if (cuenta instanceof Corriente corriente) {
                corriente.aplicarComisionMensual();
            }

            else if (cuenta instanceof Nomina nomina) {

                nomina.procesarFinDeMes();


                if (nomina.getMesesSinSalario() >= 3) {

                    Corriente nuevaCorriente = nomina.convertirACuentaCorriente();

                    listCuentas.set(i, nuevaCorriente);

                    System.out.println("Cuenta Nómina convertida a Corriente.");
                }
            }
        }
    }

}
