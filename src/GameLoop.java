import java.nio.file.Path;
import java.util.*;

public class GameLoop {
    private static final String RUSSIAN_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final Random random = new Random();
    private static final List<String> allWords = FileReader.getArrayFromPath(Path.of("resources.txt"));
    public static void start(Scanner scanner) {
        String hiddenWord = allWords.get(random.nextInt(allWords.size()));
        ConsoleOutput consoleOutput = new ConsoleOutput(hiddenWord);
        Set<Character> usedSymbols = new HashSet<>();
        List<Integer> foundedIndexes = new ArrayList<>();
        boolean win = false;
        int tries = 0;

        consoleOutput.HiddenWordLength();
        do {
            consoleOutput.writeLetter();
            String nowTry = scanner.nextLine().toLowerCase();

            if (validateLetter(nowTry)) {
                consoleOutput.errorAlphabet();
                continue;
            } else if (usedSymbols.contains(nowTry.charAt(0))) {
                consoleOutput.alreadyUseThisLetter(nowTry);
                continue;
            }
            addFoundedIndexes(hiddenWord,nowTry,foundedIndexes);
            String foundedWord = generateGuessedWord(hiddenWord, foundedIndexes);

            if (foundedWord.equals(hiddenWord)) {
               consoleOutput.successfulGuess();
                win = true;
                break;
            }
            if (!hiddenWord.contains(nowTry)) {
                consoleOutput.drawStickMan(tries);
                tries++;
            }
            usedSymbols.add(nowTry.charAt(0));

           consoleOutput.showFoundedWord(foundedWord);
           consoleOutput.availableTries(tries);

        } while (tries < 6);
        if (!win) consoleOutput.showHiddenWord();

    }


    private static String generateGuessedWord(String word,List<Integer> foundedIndexes){
        String foundedWord = "";
        for(int i =0;i<word.length();i++){
                if(foundedIndexes.contains(i)){
                    foundedWord += word.charAt(i);
                } else{
                    foundedWord += "*";
                }
            }
        return foundedWord;
    }
    private static void addFoundedIndexes(String hiddenWord,String nowTry,List<Integer> foundedIndexes){
        for (int i = 0; i < hiddenWord.length(); i++) {
                if (String.valueOf(hiddenWord.charAt(i)).equals(nowTry)) {
                    foundedIndexes.add(i);
                }
            }
    }
    public static boolean validateLetter(String nowTry){
        return nowTry.length() != 1 || !RUSSIAN_ALPHABET.contains(nowTry);
    }
}
