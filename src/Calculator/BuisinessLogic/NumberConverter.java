package Calculator.BuisinessLogic;


import Calculator.RomenNumber.RomenNumber;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class NumberConverter {
    private static Map<String, Integer> numRome = RomenNumber.getNumRome();

    public static int romanToArabic(String input) {
        char[] romStr = input.toUpperCase().trim().toCharArray();
        int result = 0;
        if(romStr.length == 1){
            return numRome.get(String.valueOf(romStr[0]));
        }
        int a = numRome.get(String.valueOf(romStr[0]));
        for(int i=1; i < romStr.length; i++){
            int b = numRome.get(String.valueOf(romStr[i]));
            if(a>=b){
                result += a;
                a = b;
            } else {
                result -= a;
                a = b;
            }
            if(b == numRome.get(String.valueOf(romStr[romStr.length-1]))){
                result += b;
            }
        }
        return result;
    }

    public static String arabicToRoman(int number) {
        StringBuilder result = new StringBuilder();
        for(Map.Entry<String, Integer> entry : numRome.entrySet()){
            int match = number/entry.getValue();
            result.append(repeat(entry.getKey(), match));
            number = number % entry.getValue();
        }
        return result.toString();
    }
    private static String repeat(String s, int n) {
        if(s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static Map<String, Integer> getNumRome() {
        return numRome;
    }

    @Test
    public void testArabicToRoman(){
        Assert.assertEquals(NumberConverter.arabicToRoman(25),"XXV");
        Assert.assertEquals(NumberConverter.arabicToRoman(19),"XIX");
        Assert.assertEquals(NumberConverter.arabicToRoman(14),"XIV");
        Assert.assertEquals(NumberConverter.arabicToRoman(40),"XL");
        Assert.assertEquals(NumberConverter.arabicToRoman(99),"XCIX");
        Assert.assertEquals(NumberConverter.arabicToRoman(66),"LXVI");
    }

    @Test
    public void testRomanToArabic(){
        Assert.assertEquals(NumberConverter.romanToArabic("XXV"),25);
        Assert.assertEquals(NumberConverter.romanToArabic("XIX"),19);
        Assert.assertEquals(NumberConverter.romanToArabic("XIV"),14);
        Assert.assertEquals(NumberConverter.romanToArabic("IV"),4);
        Assert.assertEquals(NumberConverter.romanToArabic("iv"),4);
        Assert.assertEquals(NumberConverter.romanToArabic("V"),5);
    }



}
