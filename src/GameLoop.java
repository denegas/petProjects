import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;

public class GameLoop {
    private static final Pattern RUSSIAN_ALPHABET_PATTERN = Pattern.compile("^[а-яА-ЯёЁ]+$");
    private static final Random random = new Random();
    private static final List<String> allWords = FileReader.getWordsArrayFromFile(Path.of("resources.txt"));
    private static final int MAX_TRIES = 6;

    public static void start(Scanner scanner) {
        String hiddenWord = allWords.get(random.nextInt(allWords.size()));
        Set<Character> usedLetters = new HashSet<>();
        Set<Character> foundedLetters = new HashSet<>();
        boolean win = false;
        int tries = 0;
        char letter;
        ConsoleWriter.hiddenWordLength(hiddenWord);
        do {
            ConsoleWriter.writeLetter();
            String input = scanner.nextLine().toLowerCase();

            if (!isValidInput(input)) {
                ConsoleWriter.errorAlphabet();
                continue;
            }

            letter = input.trim().charAt(0);
            if (usedLetters.contains(letter)) {
                ConsoleWriter.alreadyUsedThisLetter(letter);
                continue;
            }
            addRightLetters(hiddenWord, letter, foundedLetters);
            String foundedWord = generateRightLettersInWord(hiddenWord, foundedLetters);

            if (foundedWord.equals(hiddenWord)) {
                ConsoleWriter.successfulGuess(hiddenWord);
                win = true;
                break;
            }
            if (!hiddenWord.contains(String.valueOf(letter))) {
                ConsoleWriter.drawGallows(tries);
                tries++;
            }

            usedLetters.add(letter);
            ConsoleWriter.showFoundedWord(foundedWord);
            ConsoleWriter.showUsedLetters(usedLetters);
            ConsoleWriter.availableTries(tries, MAX_TRIES);

        } while (tries < MAX_TRIES);
        if (!win) ConsoleWriter.showHiddenWord(hiddenWord);

    }


    private static String generateRightLettersInWord(String word, Set<Character> foundedLetters) {
        StringBuilder foundedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (foundedLetters.contains(word.charAt(i))) {
                foundedWord.append(word.charAt(i));
            } else {
                foundedWord.append("*");
            }
        }
        return foundedWord.toString();
    }

    private static void addRightLetters(String hiddenWord, char letter, Set<Character> foundedLetters) {
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == letter) {
                foundedLetters.add(letter);
            }
        }
    }

    public static boolean isValidInput(String input) {
        return input.trim().length() == 1 && RUSSIAN_ALPHABET_PATTERN.matcher(input.trim()).matches();
    }
}
