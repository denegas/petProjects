import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static final String ANSWER_TO_START_GAME = "y";

    public static void main() {
        boolean again = false;
        Scanner scanner = new Scanner(System.in);
        String firstInput;
        ConsoleWriter.newGameQuestion();
        try {
            firstInput = scanner.nextLine();
        } catch (RuntimeException e) {
            throw new RuntimeException("Failed to read user answer", e);
        }
        if (firstInput.equalsIgnoreCase(ANSWER_TO_START_GAME)) {
            do {
                GameLoop.start(scanner);
                ConsoleWriter.playAgainQuestion();

                try {
                    String input = scanner.nextLine();
                    again = input.equalsIgnoreCase(ANSWER_TO_START_GAME);
                } catch (NoSuchElementException err) {
                    System.out.println("err with: " + err.getMessage());
                }

            } while (again);
        }
        ConsoleWriter.gameOverMessage();
        scanner.close();

    }
}