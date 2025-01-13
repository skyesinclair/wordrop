package wordrop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class Dictionary implements DictionaryInterface{
    private HashSet<String> words;

    public Dictionary() {
        words = new HashSet<>();
        words.addAll(getWordsFromFile("src/main/resources/american-english"));
        words.addAll(getWordsFromFile("src/main/resources/british-english"));
        words = normalizeWords(words);
    }

//    todo: make this return a new result object
    public HashSet<String> getWordsInString(String str) {
        HashSet<String> wordsInString = new HashSet<>();
        for (String word : words) {
            if (str.contains(word)) {
                wordsInString.add(word);
            }
        }
        return wordsInString;
    }

    public Result getResult(String str, Tile[] tiles) {
        HashSet<String> wordsInString = getWordsInString(str);
        HashSet<Tile> toRemove = new HashSet<>();
        for (String word : wordsInString) {
            int index = str.indexOf(word);
            while (index >= 0) {
                for (int i = index; i < index + word.length(); i++) {
                    toRemove.add(tiles[i]);
                }
                index = str.indexOf(word, index + 1);
            }
        }
        return new Result(str, wordsInString.toArray(new String[0]), toRemove);
    }

    private HashSet<String> getWordsFromFile(String filename) {
        HashSet<String> wordsFromFile = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordsFromFile.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading " + filename + " > "+ e.getMessage());
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

    //return a random character from a random word
    public Character getRandomCharacter() {
        Random random = new Random();
        String[] wordsArray = words.toArray(new String[0]);
        String randomWord = wordsArray[random.nextInt(wordsArray.length)];
            return randomWord.charAt(random.nextInt(randomWord.length()));
    }

}
