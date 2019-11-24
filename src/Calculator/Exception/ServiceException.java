package Calculator.Exception;

public class ServiceException extends Exception {
    public static final String ERROR_DATA_FORMAT = "Некорректные данные";
    public static final String ERROR_OUT_BOUNDS = "Вне диапазона от 1 до 10";
    public static final String ERROR_OPERATION_FORMAT = "Неверный формат операции";
    public static final String ERROR_NUMBER_TYPE_FORMAT = "Неверный формат чисел";


    private String message;

    public ServiceException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
