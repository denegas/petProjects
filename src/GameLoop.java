import java.nio.file.Path;
import java.util.*;

public class GameLoop {
    private static final String RUSSIAN_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final Random random = new Random();
    private static final List<String> allWords = FileReader.getArrayFromPath(Path.of("resources.txt"));

    public static void start(Scanner scanner) {
        String hiddenWord = allWords.get(random.nextInt(allWords.size()));
        Set<Character> usedSymbols = new HashSet<>();
        List<Integer> foundedIndexes = new ArrayList<>();
        boolean win = false;
        int tries = 0;

        ConsoleWriter.hiddenWordLength(hiddenWord);
        do {
            ConsoleWriter.writeLetter();
            String nowTry = scanner.nextLine().toLowerCase();

            if (validateLetter(nowTry)) {
                ConsoleWriter.errorAlphabet();
                continue;
            } else if (usedSymbols.contains(nowTry.charAt(0))) {
                ConsoleWriter.alreadyUseThisLetter(nowTry);
                continue;
            }
            addFoundedIndexes(hiddenWord, nowTry, foundedIndexes);
            String foundedWord = generateGuessedWord(hiddenWord, foundedIndexes);

            if (foundedWord.equals(hiddenWord)) {
                ConsoleWriter.successfulGuess(hiddenWord);
                win = true;
                break;
            }
            if (!hiddenWord.contains(nowTry)) {
                ConsoleWriter.drawGallows(tries);
                tries++;
            }
            usedSymbols.add(nowTry.charAt(0));

            ConsoleWriter.showFoundedWord(foundedWord);
            ConsoleWriter.availableTries(tries);

        } while (tries < 6);
        if (!win) ConsoleWriter.showHiddenWord(hiddenWord);

    }


    private static String generateGuessedWord(String word, List<Integer> foundedIndexes) {
        String foundedWord = "";
        for (int i = 0; i < word.length(); i++) {
            if (foundedIndexes.contains(i)) {
                foundedWord += word.charAt(i);
            } else {
                foundedWord += "*";
            }
        }
        return foundedWord;
    }

    private static void addFoundedIndexes(String hiddenWord, String nowTry, List<Integer> foundedIndexes) {
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (String.valueOf(hiddenWord.charAt(i)).equals(nowTry)) {
                foundedIndexes.add(i);
            }
        }
    }

    public static boolean validateLetter(String nowTry) {
        return nowTry.length() != 1 || !RUSSIAN_ALPHABET.contains(nowTry);
    }
}
