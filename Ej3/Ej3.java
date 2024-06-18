package Ej3;

import java.util.List;

public class Ej3 {
    // 1. Determinar si una cadena de caracteres está presente en una lista de cadenas
    public static boolean isStringInList(List<String> list, String target, int index) {
        if (index >= list.size()) {
            return false;
        }
        if (list.get(index).equals(target)) {
            return true;
        }
        return isStringInList(list, target, index + 1);
    }

    // 2. Contar la cantidad de números impares de una lista
    public static int countOddNumbers(List<Integer> list, int index) {
        if (index >= list.size()) {
            return 0;
        }
        int count = (list.get(index) % 2 != 0) ? 1 : 0;
        return count + countOddNumbers(list, index + 1);
    }

    // 3. Determinar si una lista de enteros es creciente
    public static boolean isListIncreasing(List<Integer> list, int index) {
        if (index >= list.size() - 1) {
            return true;
        }
        if (list.get(index) >= list.get(index + 1)) {
            return false;
        }
        return isListIncreasing(list, index + 1);
    }

    // 4. Determinar el máximo de una lista de valores
    public static int findMax(List<Integer> list, int index) {
        if (index >= list.size() - 1) {
            return list.get(index);
        }
        int maxInRest = findMax(list, index + 1);
        return Math.max(list.get(index), maxInRest);
    }
}

