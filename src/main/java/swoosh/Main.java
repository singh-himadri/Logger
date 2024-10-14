package swoosh;

public class Main {
    public static void main(String[] args) {
        // Logger that logs messages in uppercase
        Logger upperCaseLogger = Logger.getUppercaseLogger();
        upperCaseLogger.logInUppercase("This is an uppercase message");

        // Default red logger
        Logger redLogger = Logger.getDefaultLogger();
        redLogger.log("This is a default logger message");
        redLogger.logWithPrefix("INFO", "This is a prefixed message");

        // Leet logger
        Logger leetLogger = Logger.getLeetLogger();
        leetLogger.logInLeetSpeak("Autobots Rollout!");

        // Caesar Cipher logger with shift 3
        Logger cipherLogger = Logger.getCaesarCipherLogger(3);
        cipherLogger.logWithCaesarCipher("attack at dawn", 3);

        // Reverse Logger
        redLogger.logInReverse("Reverse this message!");

        // Color Logger (Cyan text)
        redLogger.logInColor("This is a cyan colored message", "\u001B[36m");

        // Styled Logger (Green text, blue background, bold effect)
        Logger styledLogger = Logger.getStyledLogger("\u001B[32m", "\u001B[44m", "\u001B[1m");
        styledLogger.logWithStyle("This is a styled message", "\u001B[32m", "\u001B[44m", "\u001B[1m");

        // Logger without vowels
        redLogger.logWithoutVowels("Remove vowels from this message");

        // Logger that repeats the message 3 times
        redLogger.logWithRepeatedMessage("Repeat this message! ", 3);

        // Scrambled words logger
        redLogger.logScrambledWords("Scramble this message!");
    }
}