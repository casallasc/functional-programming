package basic;

import io.vavr.control.Try;

public class TryMapExample {

    public static void main(String[] args) throws MyException {

        TryMapExample example = new TryMapExample();

        Integer result = Try.of(() -> example.divide(45, -1))
                .onFailure(e -> System.out.println("Error: " + e.getMessage()))
                .recover(MyException.class, e -> 777 )
                //fold funciona como condicion de escape si algun recover no atrapa
                //la excepcion, ademas retorna el valor (sin el try, parece un get())
                .fold(e -> 999, r -> r);

        System.out.println("Result: " + result);

    }

    public Integer divide(Integer a, Integer b) throws Exception {
        if(b == 0) {
            throw new MyException("Division by zero");
        }

        if(a < 0 || b < 0) {
            throw new Exception("Negative numbers not allowed");
        }

        return a/b;
    }
}

class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
