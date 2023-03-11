import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import interfaces.InterfazSelector;
import programa.ConversorMonedas;
import programa.ConversorTemperaturas;
import programa.ListaMonedas;
import programa.ListaTemperaturas;
import programa.Moneda;
import programa.Temperatura;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
    	
    	SwingUtilities.invokeLater(InterfazSelector::new);
    	
        boolean salir = false;

        while (!salir) {

            System.out.println("¿Qué quieres hacer?");
            System.out.println("1. Convertir monedas");
            System.out.println("2. Convertir temperaturas");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    convertirMonedas();
                    break;
                case 2:
                    convertirTemperaturas();
                    break;
                case 3:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }

        }
        
        scanner.close();
    }

    private static void convertirMonedas() {
        try {
            ConversorMonedas conversorMonedas = new ConversorMonedas();
            DecimalFormat formatoDecimal = new DecimalFormat("#.0000");

            List<Moneda> listaMonedas = ListaMonedas.getListaMonedas();
            System.out.println("Monedas disponibles:");
            for (int i = 0; i < listaMonedas.size(); i++) {
                Moneda moneda = listaMonedas.get(i);
                System.out.println((i + 1) + ". " + moneda);
            }

            System.out.print("Elija una moneda origen (ingrese número de la lista): ");
            int indiceOrigen = scanner.nextInt() - 1;
            Moneda monedaOrigen = listaMonedas.get(indiceOrigen);

            System.out.print("Elija una moneda destino (ingrese número de la lista): ");
            int indiceDestino = scanner.nextInt() - 1;
            Moneda monedaDestino = listaMonedas.get(indiceDestino);

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();

            double resultado = conversorMonedas.convertir(cantidad, monedaOrigen.getCodigo(), monedaDestino.getCodigo());

            System.out.println(formatoDecimal.format(cantidad) + " " + monedaOrigen.getNombre() + " equivale a " +
                    formatoDecimal.format(resultado) + " " + monedaDestino.getNombre());

        } catch (InputMismatchException e) {
            System.out.println("Error: entrada inválida");
            scanner.nextLine();
        }
    }

    private static void convertirTemperaturas() {
        try {
        	ConversorTemperaturas conversorTemperaturas = new ConversorTemperaturas();
            DecimalFormat formatoDecimal = new DecimalFormat("#.00");

            List<Temperatura> listaTemperaturas = ListaTemperaturas.getListaTemperaturas();
            System.out.println("Temperaturas disponibles:");
            for (int i = 0; i < listaTemperaturas.size(); i++) {
                Temperatura temperatura = listaTemperaturas.get(i);
                System.out.println((i + 1) + ". " + temperatura);
            }

            System.out.print("Elija una temperatura de origen (ingrese número de la lista): ");
            int indiceOrigen = scanner.nextInt() - 1;
            Temperatura TemperaturaOrigen = listaTemperaturas.get(indiceOrigen);

            System.out.print("Elija una temperatura destino (ingrese número de la lista): ");
            int indiceDestino = scanner.nextInt() - 1;
            Temperatura TemperaturaDestino = listaTemperaturas.get(indiceDestino);

            System.out.print("Ingrese la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();
            
            double temperaturaConvertida = conversorTemperaturas.convertir(cantidad, TemperaturaOrigen.getNombre(), TemperaturaDestino.getNombre());

            System.out.println(cantidad + " " + TemperaturaOrigen.getSimbolo() + " = " + formatoDecimal.format(temperaturaConvertida) + " " + TemperaturaDestino.getSimbolo());


        } catch (InputMismatchException e) {
            System.out.println("Error: entrada inválida");
            scanner.nextLine();
        }
    }
}
