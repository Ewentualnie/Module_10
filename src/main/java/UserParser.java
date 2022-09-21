import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UserParser {
    public static void convertToJSON(String filename) {
        ArrayList<String> users = new ArrayList<>();
        Path path = Paths.get("user.json");
        try {
            File file = new File(filename);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            String[] title = line.split(" ");
            while ((line = reader.readLine()) != null) {
                String user = "{\"" + title[0] + "\":\"" + line.split(" ")[0] + "\",\""
                        + title[1] + "\":" + line.split(" ")[1] + "}";
                users.add(user);
            }
            reader.close();
            Files.writeString(path, users.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
