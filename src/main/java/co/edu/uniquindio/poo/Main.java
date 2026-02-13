package co.edu.uniquindio.poo;

import java.util.Scanner;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Banco banco = new Banco("Banco UniQuindío", "123456789");

        int opcion;

        do {
            System.out.println("\n===== MENÚ BANCO =====");
            System.out.println("1. Crear Cuenta Ahorro");
            System.out.println("2. Crear Cuenta Corriente");
            System.out.println("3. Crear Cuenta Nómina");
            System.out.println("4. Depositar");
            System.out.println("5. Retirar");
            System.out.println("6. Mostrar Cuentas");
            System.out.println("7. Procesar Fin de Mes");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1 -> {
                    System.out.print("Número de cuenta: ");
                    String num = sc.nextLine();

                    System.out.print("Titular: ");
                    String titular = sc.nextLine();

                    System.out.print("Fecha apertura: ");
                    String fecha = sc.nextLine();

                    System.out.print("Saldo inicial: ");
                    double saldo = sc.nextDouble();

                    Ahorro ahorro = new Ahorro(num, titular, fecha, saldo);
                    banco.agregarCuenta(ahorro);

                    System.out.println("Cuenta Ahorro creada.");
                }

                case 2 -> {
                    System.out.print("Número de cuenta: ");
                    String num = sc.nextLine();

                    System.out.print("Titular: ");
                    String titular = sc.nextLine();

                    System.out.print("Fecha apertura: ");
                    String fecha = sc.nextLine();

                    System.out.print("Saldo inicial: ");
                    double saldo = sc.nextDouble();

                    Corriente corriente = new Corriente(num, titular, fecha, saldo);
                    banco.agregarCuenta(corriente);

                    System.out.println("Cuenta Corriente creada.");
                }

                case 3 -> {
                    System.out.print("Número de cuenta: ");
                    String num = sc.nextLine();

                    System.out.print("Titular: ");
                    String titular = sc.nextLine();

                    System.out.print("Fecha apertura: ");
                    String fecha = sc.nextLine();

                    System.out.print("Saldo inicial: ");
                    double saldo = sc.nextDouble();

                    Nomina nomina = new Nomina(num, titular, fecha, saldo);
                    banco.agregarCuenta(nomina);

                    System.out.println("Cuenta Nómina creada.");
                }

                case 4 -> {
                    System.out.print("Número de cuenta: ");
                    String num = sc.nextLine();

                    Cuenta cuenta = banco.buscarCuenta(num);

                    if (cuenta != null) {
                        System.out.print("Cantidad a depositar: ");
                        double cantidad = sc.nextDouble();
                        cuenta.depositar(cantidad);
                        System.out.println("Depósito realizado.");
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                }

                case 5 -> {
                    System.out.print("Número de cuenta: ");
                    String num = sc.nextLine();

                    Cuenta cuenta = banco.buscarCuenta(num);

                    if (cuenta != null) {
                        System.out.print("Cantidad a retirar: ");
                        double cantidad = sc.nextDouble();
                        cuenta.retirar(cantidad);
                    } else {
                        System.out.println("Cuenta no encontrada.");
                    }
                }

                case 6 -> banco.mostrarCuentas();

                case 7 -> {
                    banco.procesarFinDeMes();
                    System.out.println("Fin de mes procesado.");
                }

                case 0 -> System.out.println("Saliendo del sistema...");

                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
