package basic;

import io.vavr.control.Either;

public class EitherExample {

    public static void main(String[] args) {
        Either<String, Object> result = division(10,0)
                .mapLeft(err -> {
                    System.out.println("execute mapLeft, must return some of left type...");
                    return "Error: " + err.toUpperCase();
                })
                .map(res -> {
                    System.out.println("execute map, must return some of right type...");
                    return res * 2;
                });

        System.out.println("Al ser left retorna el valor del else: " + result.getOrElse(777));
        System.out.println("Al ser left, al invocar el get() lanza una excepcion: ");
        result.get();
    }

    public static Either<String, Integer> division(Integer a, Integer b) {
        if(b.equals(0)) {
            return Either.left("Division by zero");
        } else {
            return Either.right(a/b);
        }
    }
}
