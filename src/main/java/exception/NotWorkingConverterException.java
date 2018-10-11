package exception;

public class NotWorkingConverterException extends RuntimeException {
    public NotWorkingConverterException() {
        System.out.println("YOUR CONVERTER DOESNT WORK, TRY AGAIN");
    }
}
