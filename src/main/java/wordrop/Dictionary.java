package wordrop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {
    private HashSet<String> words;

    public Dictionary() {
        words = new HashSet<>();
        words.addAll(getWordsFromFile("src/main/resources/american-english"));
        words.addAll(getWordsFromFile("src/main/resources/british-english"));
        words = normalizeWords(words);
    }

    public HashSet<String> getWordsInString(String str) {
        HashSet<String> wordsInString = new HashSet<>();
        for (String word : words) {
            if (str.contains(word)) {
                wordsInString.add(word);
            }
        }
        return wordsInString;
    }


    private HashSet<String> getWordsFromFile(String filename) {
        HashSet<String> wordsFromFile = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordsFromFile.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }
        return wordsFromFile;
    }

    public HashSet<String> getWords() {
        return words;
    }

    private HashSet<String> normalizeWords(HashSet<String> words) {
        HashSet<String> normalizedWords = new HashSet<>();
        for (String word : words) {
            if (word.matches("[a-z]+")&& word.length() > 2) {
                normalizedWords.add(word);
            }
        }
        return normalizedWords;
    }

    public void printRandomWords(int number) {
        int count = 0;
        List<String> wordList = new ArrayList<>(words);
        Collections.shuffle(wordList);
        for (String word : words) {
            if (count >= number) {
                break;
            }
            System.out.println(word);
            count++;
        }
    }
}
