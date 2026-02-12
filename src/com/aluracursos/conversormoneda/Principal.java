package com.aluracursos.conversormoneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("*************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida:");
            System.out.println("*************************************************");

            try {
                opcion = lectura.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor ingrese solo números.");
                lectura.next();
                continue;
            }

            if (opcion == 7) {
                System.out.println("Finalizando el programa. ¡Gracias por usar nuestros servicios!");
                break;
            }

            String monedaBase = "";
            String monedaTarget = "";

            switch (opcion) {
                case 1:
                    monedaBase = "USD";
                    monedaTarget = "ARS";
                    break;
                case 2:
                    monedaBase = "ARS";
                    monedaTarget = "USD";
                    break;
                case 3:
                    monedaBase = "USD";
                    monedaTarget = "BRL";
                    break;
                case 4:
                    monedaBase = "BRL";
                    monedaTarget = "USD";
                    break;
                case 5:
                    monedaBase = "USD";
                    monedaTarget = "COP";
                    break;
                case 6:
                    monedaBase = "COP";
                    monedaTarget = "USD";
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue;
            }

            try {
                System.out.println("Ingrese el valor que desea convertir:");
                double cantidad = lectura.nextDouble();

                Moneda moneda = consulta.buscarMoneda(monedaBase, monedaTarget);

                double resultado = cantidad * moneda.conversion_rate();

                System.out.println("El valor " + cantidad + " [" + monedaBase + "] corresponde al valor final de =>>> "
                        + resultado + " [" + monedaTarget + "]");
            } catch (Exception e) {
                System.out.println("Ocurrió un error al obtener la tasa de cambio o al ingresar el valor.");
            }
        }
    }
}