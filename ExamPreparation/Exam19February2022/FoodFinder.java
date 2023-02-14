package ExamPreparation.Exam19February2022;

import java.util.*;

public class FoodFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<String> vowels = new ArrayDeque<>();
        Deque<String> consonants = new ArrayDeque<>();

        Arrays.stream(scan.nextLine().split(" ")).forEach(vowels::offer);
        Arrays.stream(scan.nextLine().split(" ")).forEach(consonants::push);

        Map<String, Integer> letters = new HashMap<>();
        letters.put("p", 0);
        letters.put("e", 0);
        letters.put("a", 0);
        letters.put("r", 0);
        letters.put("f", 0);
        letters.put("l", 0);
        letters.put("o", 0);
        letters.put("u", 0);
        letters.put("k", 0);
        letters.put("i", 0);
        letters.put("v", 0);
        while (!consonants.isEmpty()) {
            String vowel = vowels.poll();
            String consonant = consonants.pop();

            if (letters.containsKey(vowel)) {
                letters.put(vowel, letters.get(vowel) + 1);
            }

            if (letters.containsKey(consonant)) {
                letters.put(consonant, letters.get(consonant) + 1);
            }
            vowels.offer(vowel);
        }

        int wordsFound = 0;
        String foundWords = "";
        if (letters.get("p") > 0 && letters.get("e") > 0 && letters.get("a") > 0 && letters.get("r") > 0) {
            wordsFound++;
            foundWords = System.lineSeparator() + "pear";
        }
        if (letters.get("f") > 0 && letters.get("l") > 0 && letters.get("o") > 0 && letters.get("u") > 0 && letters.get("r") > 0) {
            wordsFound++;
            foundWords = foundWords + System.lineSeparator() + "flour";
        }
        if (letters.get("p") > 0 && letters.get("o") > 0 && letters.get("r") > 0 && letters.get("k") > 0) {
            wordsFound++;
            foundWords = foundWords + System.lineSeparator() + "pork";
        }
        if (letters.get("o") > 0 && letters.get("l") > 0 && letters.get("i") > 0 && letters.get("v") > 0 && letters.get("e") > 0) {
            wordsFound++;
            foundWords = foundWords + System.lineSeparator() + "olive";
        }
        System.out.println("Words found: " + wordsFound + foundWords);
    }
}
