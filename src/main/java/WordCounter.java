import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WordCounter {
    public static void count(String name) {
        HashMap<String, Integer> counter = new HashMap<>();
        for (String word : getWords(name)) {
            counter.merge(word, 1, Integer::sum);
        }
        counter.entrySet().stream()
                .sorted(HashMap.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }


    private static ArrayList<String> getWords(String filename) {
        ArrayList<String> words = new ArrayList<>();
        try {
            File file = new File(filename);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                words.addAll(Arrays.asList(
                        line.replaceAll("\\s{2,}", " ")
                                .split(" "))
                );
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return words;
    }
}
