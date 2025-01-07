package wordrop;

import java.util.HashSet;

public class Result {

    // the string to search for words
    private String str;
    // the position of the new character in the string
    private int position;
    // list of words found in the string
    private HashSet<String> words;
    // list of positions of characters to remove
    private HashSet<Integer> toRemove;
    //cound of how many times it queried the dictionary
    private int queries = 0;
    //dictionary of words
    private Dictionary dictionary;

    public Result(String str, int position, Dictionary dictionary) {
        this.str = str;
        this.position = position;
        this.words = dictionary.getWordsInString(str);
        this.toRemove = new HashSet<>();
        this.dictionary = dictionary;
    }


    private void addIfWord(int beginning, int end) {
        if (isWord(str.substring(beginning, end))) {
            words.add(str.substring(beginning, end));
            //add the position of the characters to remove
            for (int j = beginning; j < end; j++) {
                toRemove.add(j);
            }
        }
    }

    private boolean isWord(String str) {
        queries++;
        //check if the string is a word
//todo: implement this method
        if (str.length() >= 3) {
            return Math.random() < 0.3;
        }
        return false;
    }

    private boolean wordContains(String str) {
        queries++;
        //check if the string is part of a word
//todo: implement this method
        return Math.random() < 0.3;
    }

    private boolean wordStartsWith(String str) {
        queries++;
        //check if the string is the start of a word
        //todo: implement this method
        return Math.random() < 0.3;
    }

    public String[] getWords() {
        return words.toArray(new String[0]);
    }

    public Object[] getToRemove() {
        return toRemove.toArray();
    }

    public int getQueries() {
        return queries;
    }
}
