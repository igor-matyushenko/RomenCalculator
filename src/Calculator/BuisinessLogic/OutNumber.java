package Calculator.BuisinessLogic;

import Calculator.Operation.Operation;
import Calculator.Operation.OperationImpl;

public class OutNumber {
    private static Operation operation = new OperationImpl();


    public static void func(int a, int b, String op) {
        String out = "Output: ";
        switch (op) {
            case "+":
                System.out.println(out + "\n" + operation.addition(a, b));
                break;
            case "-":
                System.out.println(out + "\n" + operation.subtraction(a, b));
                break;
            case "*":
                System.out.println(out + "\n" + operation.multiplay(a, b));
                break;
            case "/":
                System.out.println(out + "\n" + operation.division(a, b));
                break;
        }
    }

    public static void func(String s1, String s2, String op) {
        String out = "Output: ";
        int a = NumberConverter.romanToArabic(s1);
        int b = NumberConverter.romanToArabic(s2);
        switch (op) {
            case "+":
                System.out.println(out + "\n" + NumberConverter.arabicToRoman(operation.addition(a, b)));
                break;
            case "-":
                System.out.println(out + "\n" + NumberConverter.arabicToRoman(operation.subtraction(a, b)));
                break;
            case "*":
                System.out.println(out + "\n" + NumberConverter.arabicToRoman(operation.multiplay(a, b)));
                break;
            case "/":
                System.out.println(out + "\n" + NumberConverter.arabicToRoman((int) operation.division(a, b)));
                break;
        }
    }
}
