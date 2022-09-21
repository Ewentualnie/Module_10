import java.io.*;
import java.util.ArrayList;

public class PhoneValidator {
    public static ArrayList<String> validate(String filename) {
        ArrayList<String> phones = new ArrayList<>();

        try {
            File file = new File(filename);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.matches("(\\(\\d{3}\\)|\\d{3})(\\s|-)\\d{3}-\\d{4}")) {
                    phones.add(line);
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return phones;
    }
}
