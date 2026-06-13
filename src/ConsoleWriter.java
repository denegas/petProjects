import java.util.Set;

public final class ConsoleWriter {
 private static final String[] gallowsStages = {
         "  +---+\n  |   |\n      |\n      |\n      |\n      |\n=========",
         "  +---+\n  |   |\n  0   |\n      |\n      |\n      |\n=========",
         "  +---+\n  |   |\n  O   |\n /|   |\n      |\n      |\n=========",
         "  +---+\n  |   |\n  O   |\n /|\\  |\n      |\n      |\n=========",
         "  +---+\n  |   |\n  O   |\n /|\\  |\n /    |\n      |\n=========",
         "  +---+\n  |   |\n  O   |\n /|\\  |\n / \\  |\n      |\n========="
 };
    public static void drawGallows(int triesCount) {
        System.out.println(gallowsStages[triesCount]);
    }

    public static void hiddenWordLength(String word) {
        System.out.println("Загаданное слово состоит из " + word.length() + " букв");
    }

    public static void writeLetter() {
        System.out.println("Введите букву");
    }

    public static void errorAlphabet() {
        System.out.println("Введите 1 букву из кириллицы!");
    }

    public static void alreadyUsedThisLetter(String letter) {
        System.out.println("вы уже использовали букву: " + letter.toUpperCase());
    }

    public static void successfulGuess(String word) {
        System.out.println("Вы угадали слово: " + word.toUpperCase());
    }

    public static void availableTries(int tries, int MAX_TRIES) {
        System.out.println("Осталось попыток: " + (MAX_TRIES - tries) + "\n");
    }

    public static void showHiddenWord(String word) {
        System.out.println("Загаданное слово " + word.toUpperCase());
    }

    public static void showFoundedWord(String foundedWord) {
        System.out.println(foundedWord.toUpperCase());
    }

    public static void newGameQuestion() {
        System.out.println("Начать новую игру? (Y/N)");
    }

    public static void playAgainQuestion() {
        System.out.println("Сыграть снова? (Y/N)");
    }

    public static void gameOverMessage() {
        System.out.println("Конец игры");
    }

    public static void showUsedLetters(Set<Character> set) {
        System.out.println("Использованные буквы: " + set.toString().replaceAll("([\\[\\]])", " ").toUpperCase());
    }
}
