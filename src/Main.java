import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static final String ANSWER_TO_START_GAME = "y";

    public static void main() {
        boolean again;
        String firstInput;
        ConsoleWriter.newGameQuestion();

        try (Scanner scanner = new Scanner(System.in)) {
            firstInput = scanner.nextLine();

            if (firstInput.equalsIgnoreCase(ANSWER_TO_START_GAME)) {
                do {
                    GameLoop.start(scanner);
                    ConsoleWriter.playAgainQuestion();
                    String input = scanner.nextLine();
                    again = input.equalsIgnoreCase(ANSWER_TO_START_GAME);

                } while (again);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to read user answer: ", e);
        }
        ConsoleWriter.gameOverMessage();

    }
}