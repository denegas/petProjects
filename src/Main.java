import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main() {
        boolean again = false;
        Scanner scanner = new Scanner(System.in);

        do {
            GameLoop.start(scanner);
            System.out.println("Сыграть снова? (Y/N)");

            try {
                String input = scanner.nextLine();
                System.out.println(input);
                again = input.equalsIgnoreCase("y");

            } catch (NoSuchElementException err) {
                System.out.println("err with: " + err.getMessage());
            }

        } while (again);

        System.out.println("Конец игры");
        scanner.close();
    }
}