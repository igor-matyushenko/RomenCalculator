package Calculator.RomenNumber;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomenNumber {

    private static Map<String, Integer> numRome = new LinkedHashMap<>();
    static {
        numRome.put("C",100);
        numRome.put("XC",90);
        numRome.put("L", 50);
        numRome.put("XL", 40);
        numRome.put("X",10);
        numRome.put("IX", 9);
        numRome.put("V", 5);
        numRome.put("IV", 4);
        numRome.put("I", 1);
    }


    public static Map<String, Integer> getNumRome() {
        return numRome;
    }

}
