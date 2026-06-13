import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class FileReader {
    private FileReader() {
    }

    public static List<String> getWordsArrayFromFile(Path path) {
        List<String> arrayWords = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arrayWords.add(line.toLowerCase());
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file", e);
        }
        return arrayWords;
    }

}
