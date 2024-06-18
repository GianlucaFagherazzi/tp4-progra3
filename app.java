import Ej1.Ej1;
import Ej3.Ej3;
import Excepciones.*;

import java.util.Scanner;
import java.util.List;

public static void main(String[] args) {
    // Pruebas para los métodos
    Scanner scanner = new Scanner(System.in);
    String opcion = "";
    boolean salir = false;
    while (salir == false) {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("ingrese el ejercicio a ejecutar");
        System.out.println("1. Calcular factorial de un numero");
        System.out.println("2. Determinar si una cadena de caracteres esta en una lista de cadenas");
        System.out.println("0. para salir");

        opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                System.out.println("-----------------------------------------------------------------");
                Ej1 calculator = new Ej1();
                try {
                    int number = 8; // Puedes cambiar este número para probar diferentes casos
                    int result = calculator.calculateFactorial(number);
                    System.out.println("El factorial de " + number + " es: " + result);
                } catch (NegativeNumberException | NumberTooLargeException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "2":
                System.out.println("-----------------------------------------------------------------");
                // 1. Determinar si una cadena de caracteres está presente en una lista de cadenas
                List<String> stringList = List.of("apple", "banana", "cherry", "date", "fig");
                String target = "cherry";
                Boolean isStringInList = Ej3.isStringInList(stringList, target, 0);
                System.out.println("¿Está 'cherry' en la lista? " + isStringInList);

                // 2. Contar la cantidad de números impares de una lista
                List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
                System.out.println("Cantidad de números impares: " + Ej3.countOddNumbers(intList, 0));

                // 3. Determinar si una lista de enteros es creciente
                List<Integer> increasingList = List.of(1, 2, 3, 4, 5);
                List<Integer> nonIncreasingList = List.of(1, 3, 2, 4, 5);
                System.out.println("¿La lista es creciente? " + Ej3.isListIncreasing(increasingList, 0));
                System.out.println("¿La lista es creciente? " + Ej3.isListIncreasing(nonIncreasingList, 0));

                // 4. Determinar el máximo de una lista de valores
                List<Integer> valuesList = List.of(10, 20, 5, 7, 25, 15);
                System.out.println("El máximo de la lista es: " + Ej3.findMax(valuesList, 0));
                break;
            case "0":
                System.out.println("gracias por usar este programa");
                salir = true;
            break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }   
    scanner.close();
}