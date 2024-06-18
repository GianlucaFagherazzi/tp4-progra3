package Ej1;

import Excepciones.NegativeNumberException;
import Excepciones.NumberTooLargeException;

public class Ej1 {

    public int calculateFactorial(int number) throws NegativeNumberException, NumberTooLargeException {
        if (number < 0) {
            throw new NegativeNumberException("El número no puede ser negativo");
        }
        if (number > 12) {
            throw new NumberTooLargeException("El número no puede ser mayor a 12");
        }
        return factorial(number);
    }

    private int factorial(int number) {
        if (number == 0) {
            return 1;
        }
        System.out.println("el numero es " + number );
        return number * factorial(number - 1);
    }
}
