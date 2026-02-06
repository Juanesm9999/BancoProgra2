package co.edu.uniquindio.poo;

import java.util.List;

public class Banco {
    private String nombre, nit;
    private List<Cuenta> listCuentas;

    public Banco (String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
    }

    // ---------------------------------------- GETTERS Y SETTERS -------------------------------------

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
    }
}
