package StreamsFilesAndDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\lyb4o\\OneDrive\\Desktop\\" +
                                                                          "04.Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> consonant = Set.of('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z');
        Set<Character> punctuation = Set.of('.', ',', '!', '?');
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Vowels", 0);
        map.put("Consonant", 0);
        map.put("Punctuation", 0);
        String line = bufferedReader.readLine();
        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (vowels.contains(c)) {
                    map.put("Vowels", map.get("Vowels") + 1);
                } else if (punctuation.contains(c)) {
                    map.put("Punctuation", map.get("Punctuation") + 1);
                } else if (!Character.isWhitespace(c)) {
                    map.put("Consonant", map.get("Consonant") + 1);
                }
            }
            line = bufferedReader.readLine();
        }
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
