package swoosh;

import java.util.function.Function;
import java.util.stream.Collectors;

@FunctionalInterface
public interface Logger {
    void log(String message);  // Single abstract method for basic logging

    // Default Methods
    default void logWithPrefix(String prefix, String message) {
        log(prefix + ": " + message);
    }

    default void logWithTransformation(Function<String, String> transform, String message) {
        log(transform.apply(message));
    }

    default void logInUppercase(String message) {
        log(message.toUpperCase());
    }

    default void logInLeetSpeak(String message) {
        String leetMessage = message
                .replace("e", "3")
                .replace("a", "4")
                .replace("o", "0")
                .replace("l", "1")
                .replace("t", "7");
        log(leetMessage);
    }

    default void logWithCaesarCipher(String message, int shift) {
        StringBuilder cipheredMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char shifted = (char) (c + shift);
                if ((Character.isLowerCase(c) && shifted > 'z') || (Character.isUpperCase(c) && shifted > 'Z')) {
                    shifted -= 26;
                }
                cipheredMessage.append(shifted);
            } else {
                cipheredMessage.append(c);
            }
        }
        log(cipheredMessage.toString());
    }

    default void logInReverse(String message) {
        log(new StringBuilder(message).reverse().toString());
    }

    default void logInColor(String message, String colorCode) {
        log(colorCode + message + ANSI_RESET);
    }

    default void logWithStyle(String message, String colorCode, String backgroundColor, String effect) {
        log(colorCode + backgroundColor + effect + message + ANSI_RESET);
    }

    default void logWithoutVowels(String message) {
        log(message.replaceAll("[AEIOUaeiou]", ""));
    }

    default void logWithRepeatedMessage(String message, int repeatCount) {
        String repeatedMessage = message.repeat(repeatCount);
        log(repeatedMessage);
    }

    default void logScrambledWords(String message) {
        String scrambledMessage = message.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList())
                .stream()
                .sorted((a, b) -> (int) (Math.random() * 2) - 1)
                .map(String::valueOf)
                .collect(Collectors.joining());
        log(scrambledMessage);
    }

    // ANSI Color Codes
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    // Static Methods to create different loggers
    static Logger getDefaultLogger() {
        return message -> System.out.println(ANSI_RED + message + ANSI_RESET);
    }

    static Logger getUppercaseLogger() {
        return message -> System.out.println(message.toUpperCase());
    }

    static Logger getLeetLogger() {
        return message -> System.out.println(message
                .replace("e", "3")
                .replace("a", "4")
                .replace("o", "0")
                .replace("l", "1")
                .replace("t", "7"));
    }

    static Logger getCaesarCipherLogger(int shift) {
        return message -> {
            StringBuilder cipheredMessage = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isLetter(c)) {
                    char shifted = (char) (c + shift);
                    if ((Character.isLowerCase(c) && shifted > 'z') || (Character.isUpperCase(c) && shifted > 'Z')) {
                        shifted -= 26;
                    }
                    cipheredMessage.append(shifted);
                } else {
                    cipheredMessage.append(c);
                }
            }
            System.out.println(cipheredMessage.toString());
        };
    }

    static Logger getStyledLogger(String colorCode, String backgroundColor, String effect) {
        return message -> System.out.println(colorCode + backgroundColor + effect + message + ANSI_RESET);
    }
}