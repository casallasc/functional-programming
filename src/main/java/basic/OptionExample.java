package basic;

import io.vavr.control.Option;

public class OptionExample {

    public static void main(String[] args) {

        Option<String> name = Option.<String>of(null);
        System.out.println(name);
       /* duplicar((new Random().nextInt(10)+1));
        //duplicar(null);

        String sayHello = Option.of("Carlos")
                .filter(OptionExample::isOneWord)
                .map(name -> "Hello " + name)
                .get();
        System.out.println(sayHello);*/
    }

    public static void duplicar(Integer number) {
        System.out.println("Numero a duplicar: " + number);
        Integer duplicatedNumber = Option.of(number)
                .map(num -> num * 2)
                .get();
        System.out.println("Numero duplicado: " + duplicatedNumber);
    }
    public static boolean isOneWord(String name) {
        return !name.contains(" ");
    }
}
