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
        List<Character> foundedLetters = new ArrayList<>();
        boolean win = false;
        int tries = 0;
        char letter;
        ConsoleWriter.hiddenWordLength(hiddenWord);
        do {
            ConsoleWriter.writeLetter();

            try {
                letter = scanner.nextLine().toLowerCase().charAt(0);
            } catch (RuntimeException e){
                ConsoleWriter.errorAlphabet();
                continue;
            }
            if (!isValidLetter(letter)) {
                ConsoleWriter.errorAlphabet();
                continue;
            } else if (usedLetters.contains(letter)) {
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


    private static String generateFoundedLettersInWord(String word, List<Integer> foundedIndexes) {
        StringBuilder foundedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (foundedIndexes.contains(i)) {
                foundedWord.append(word.charAt(i));
            } else {
                foundedWord.append("*");
            }
        }
        return foundedWord.toString();
    }

    private static void addFoundedIndexes(String hiddenWord, char letter, List<Integer> foundedIndexes) {
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i)== letter) {
                foundedIndexes.add(i);
            }
        }
    }


    public static boolean isValidLetter(char letter) {
        return RUSSIAN_ALPHABET_PATTERN.matcher(String.valueOf(letter)).matches();
    }
}
