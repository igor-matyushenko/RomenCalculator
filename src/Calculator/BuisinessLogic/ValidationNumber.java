package Calculator.BuisinessLogic;

import Calculator.Exception.ServiceException;

import java.util.HashSet;
import java.util.Set;

public class ValidationNumber {
    private Set<String> correctRomeNumber = new HashSet<>();
    private Set<String> operation = new HashSet<>();

    public ValidationNumber(){
        addToOperation(operation);
        addToCorrectRomeNumber(correctRomeNumber);
    }
    public boolean isDigital(String s, String s1) {
        try {
            Integer.parseInt(s);
            Integer.parseInt(s1);
            return true;
           } catch (NumberFormatException e) {
            return false;
        }
    }

    private void addToOperation(Set<String> operation) {
        operation.add("+");
        operation.add("-");
        operation.add("*");
        operation.add("/");
    }

    /*
    этот метод добавлен ввиду дополнительной проверки
    коррекции ввода таких значений: IIII или VXIXIV
     */
    private void addToCorrectRomeNumber(Set<String> correctRomeNumber) {
        correctRomeNumber.add("I");
        correctRomeNumber.add("II");
        correctRomeNumber.add("III");
        correctRomeNumber.add("IV");
        correctRomeNumber.add("V");
        correctRomeNumber.add("VI");
        correctRomeNumber.add("VII");
        correctRomeNumber.add("VIII");
        correctRomeNumber.add("IX");
        correctRomeNumber.add("X");
    }

    public void rangeOfNumber(int a, int b) throws ServiceException {
        boolean flag = a>0 && a<=10 && b>0 && b<=10;
        if(!flag){
            throw new ServiceException(ServiceException.ERROR_OUT_BOUNDS);
        }
    }
    private void correctOperation(String op) throws ServiceException {
        if(!operation.contains(op)){
            throw new ServiceException(ServiceException.ERROR_OPERATION_FORMAT);
        }
    }

    private void correctLengthNumber(String[] str) throws ServiceException {
        if(str.length != 3){
            throw new ServiceException(ServiceException.ERROR_DATA_FORMAT);
        }
    }


    public void checkingCorrectData(String[] str) throws ServiceException {
        correctLengthNumber(str);
        correctOperation(str[1]);
    }

    public void correctTypeOfNumbers(String s, String s1) throws ServiceException {
        int a = 0;
        int b = 0;
        if(getCorrectRomeNumber().contains(s.toUpperCase()) && getCorrectRomeNumber().contains(s1.toUpperCase())){
            a = NumberConverter.romanToArabic(s);
            b = NumberConverter.romanToArabic(s1);
        } else {
            throw  new ServiceException(ServiceException.ERROR_NUMBER_TYPE_FORMAT);
        }
        rangeOfNumber(a,b);
    }

    private Set<String> getCorrectRomeNumber() {
        return correctRomeNumber;
    }
}
