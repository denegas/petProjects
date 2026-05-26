import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static List<String> getArrayFromPath(Path path){
        List<String> arrayWords = new ArrayList<>();
        try(BufferedReader bufferedReader = Files.newBufferedReader(path)){
            String line;
            while((line = bufferedReader.readLine()) !=null){
               arrayWords.add(line.toLowerCase());
            }
        }catch (IOException error){
            System.out.println("Error with: " + error.getMessage());
            return arrayWords;
        }
        return arrayWords;
    }

}
