package homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    public List<String> readFile() {
        try {
            return Files.readAllLines(Paths.get("files/words.txt"));
        } catch (IOException e) {
            System.out.println("File cannot read");
        }
        return new ArrayList<>();
    }

    public Map<String, Integer> countWord(List<String> strings) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String words : strings) {
            String[] wordsArray = words.split(" ");
            for (String word : wordsArray) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        Comparator<String> valueComparator = (key1, key2) -> {
            int valueCompare = wordCount.get(key2).compareTo(wordCount.get(key1));
            if (valueCompare == 0) {
                return 1;
            }
            return valueCompare;
        };
        Map<String, Integer> result = new TreeMap<>(valueComparator);
        result.putAll(wordCount);
        return result;
    }

}
