public class ConsoleOutput {
    private String word;
    public ConsoleOutput(String word){
        this.word = word;
    }
    public void drawStickMan(int triesCount){
        switch (triesCount){
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
    public void HiddenWordLength(){
        System.out.println("Загаданное слово состоит из " + word.length() + " букв");
    }
    public void writeLetter(){
        System.out.println("Введите букву");
    }
    public void errorAlphabet (){
        System.out.println("Введите 1 букву из кириллицы!");
    }
    public void alreadyUseThisLetter (String letter){
        System.out.println("вы уже использовали букву: " + letter.toUpperCase());
    }
    public void successfulGuess(){
        System.out.println("Вы угадали слово: " + word.toUpperCase());
    }
    public void availableTries(int tries){
        System.out.println("\nОсталось попыток: " + (6 - tries));
    }
    public void showHiddenWord(){
        System.out.println("Загаданное слово " + word.toUpperCase());
    }
}
