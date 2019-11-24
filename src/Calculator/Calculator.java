package Calculator;

import Calculator.BuisinessLogic.OutNumber;
import Calculator.BuisinessLogic.ValidationNumber;
import Calculator.Exception.ServiceException;

import java.util.Scanner;

public class Calculator {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ValidationNumber validationNumber = new ValidationNumber();
        System.out.println("Input: ");
        while (scanner.hasNext()) {
            String[] str = scanner.nextLine().split(" ");
            try {
                validationNumber.checkingCorrectData(str);
            } catch (ServiceException e) {
                e.printStackTrace();
                System.exit(1);
            }
            if (validationNumber.isDigital(str[0], str[2])) {
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[2]);
                try {
                    validationNumber.rangeOfNumber(a,b);
                } catch (ServiceException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
                OutNumber.func(a, b, str[1]);
            } else {
                try {
                    validationNumber.correctTypeOfNumbers(str[0],str[2]);
                } catch (ServiceException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
                OutNumber.func(str[0], str[2], str[1]);
            }
            System.out.println("Input: ");
        }
    }
}

