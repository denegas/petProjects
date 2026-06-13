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
        List<Integer> foundedIndexes = new ArrayList<>();
        boolean win = false;
        int tries = 0;

        ConsoleWriter.hiddenWordLength(hiddenWord);
        do {
            ConsoleWriter.writeLetter();
            String letter = scanner.nextLine().toLowerCase();

            if (!isValidLetter(letter)) {
                ConsoleWriter.errorAlphabet();
                continue;
            } else if (usedLetters.contains(letter.charAt(0))) {
                ConsoleWriter.alreadyUsedThisLetter(letter);
                continue;
            }
            addFoundedIndexes(hiddenWord, letter, foundedIndexes);
            String foundedWord = generateFoundedLettersInWord(hiddenWord, foundedIndexes);

            if (foundedWord.equals(hiddenWord)) {
                ConsoleWriter.successfulGuess(hiddenWord);
                win = true;
                break;
            }
            if (!hiddenWord.contains(letter)) {
                ConsoleWriter.drawGallows(tries);
                tries++;
            }
            usedLetters.add(letter.charAt(0));


            ConsoleWriter.showFoundedWord(foundedWord);
            ConsoleWriter.showUsedLetters(usedLetters);
            ConsoleWriter.availableTries(tries, MAX_TRIES);

        } while (tries < MAX_TRIES);
        if (!win) ConsoleWriter.showHiddenWord(hiddenWord);

    }


    private static String generateFoundedLettersInWord(String word, List<Integer> foundedIndexes) {
        String foundedWord = "\n";
        for (int i = 0; i < word.length(); i++) {
            if (foundedIndexes.contains(i)) {
                foundedWord += word.charAt(i);
            } else {
                foundedWord += "*";
            }
        }
        return foundedWord;
    }

    private static void addFoundedIndexes(String hiddenWord, String letter, List<Integer> foundedIndexes) {
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (String.valueOf(hiddenWord.charAt(i)).equals(letter)) {
                foundedIndexes.add(i);
            }
        }
    }

    public static boolean isValidLetter(String letter) {
        return letter.length() == 1 && RUSSIAN_ALPHABET_PATTERN.matcher(letter).matches();
    }
}
