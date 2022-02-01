package basic.optional;

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        // Uso imperativo de optional
        OptionalExample.optionalOfNullable_ImperativeUse(null);
        OptionalExample.optionalOfNullable_ImperativeUse("Karen");
    }

    public static void optionalOfNullable_ImperativeUse(String word) {
        Optional<String> optionalWord = Optional.<String>ofNullable(word);
        if (optionalWord.isPresent()) {
            System.out.println("You give me the word: " + optionalWord.get());
        } else {
            System.out.println("The word is null");
        }
    }

    public static void optionalOfImperativeUse(String word) {
        Optional<String> optionalWord = Optional.<String>ofNullable(word);
        if (optionalWord.isPresent()) {
            System.out.println("You give me the word: " + optionalWord.get());
        } else {
            System.out.println("The word is null");
        }
    }
}
