import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileReadTemplate {

    public static void main (String[] args) throws Exception {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            runChallenge(line);
        }
    }

    private static void runChallenge(String input) {
        // Run Challenge Here
    }
}
