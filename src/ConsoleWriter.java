public final class ConsoleWriter {

    public static void drawGallows(int triesCount) {
        switch (triesCount) {
            case 0:
                System.out.println(
                        "  +---+\n" +
                                "  |   |\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "=========");
                break;
            case 1:
                System.out.println(
                        "  +---+\n" +
                                "  |   |\n" +
                                "  0   |\n" +
                                "      |\n" +
                                "      |\n" +
                                "      |\n" +
                                "=========");
                break;
            case 2:
                System.out.println(
                        "  +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                " /|   |\n" +
                                "      |\n" +
                                "      |\n" +
                                "=========");
                break;
            case 3:
                System.out.println(
                        "  +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                " /|\\  |\n" +
                                "      |\n" +
                                "      |\n" +
                                "=========");
                break;
            case 4:
                System.out.println(
                        "  +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                " /|\\  |\n" +
                                " /    |\n" +
                                "      |\n" +
                                "=========");
                break;
            case 5:
                System.out.println(
                        "  +---+\n" +
                                "  |   |\n" +
                                "  O   |\n" +
                                " /|\\  |\n" +
                                " / \\  |\n" +
                                "      |\n" +
                                "=========");
                break;
            default:
                System.out.println("Error with count");
        }
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

    public static void alreadyUseThisLetter(String letter) {
        System.out.println("вы уже использовали букву: " + letter.toUpperCase());
    }

    public static void successfulGuess(String word) {
        System.out.println("Вы угадали слово: " + word.toUpperCase());
    }

    public static void availableTries(int tries) {
        System.out.println("\nОсталось попыток: " + (6 - tries));
    }

    public static void showHiddenWord(String word) {
        System.out.println("Загаданное слово " + word.toUpperCase());
    }

    public static void showFoundedWord(String foundedWord) {
        System.out.println(foundedWord.toUpperCase());
    }
    public static void newGameQuestion(){
        System.out.println("Начать новую игру? (Y/N)");
    }
    public static void playAgainQuestion(){
        System.out.println("Сыграть снова? (Y/N)");
    }
    public static void gameOverMessage(){
        System.out.println("Конец игры");
    }
}
