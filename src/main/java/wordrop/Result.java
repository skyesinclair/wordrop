package wordrop;

import java.util.HashSet;

public class Result {
//todo: change this so it is returned from a dictionary method instead of calling dictionary
    // the string to search for words
    private String str;
    // list of words found in the string
    private HashSet<String> words;
    // list of positions of characters to remove
    private HashSet<Integer> toRemove;
    //dictionary of words
    private myDictionary dictionary;

    public Result(String str, myDictionary dictionary) {
        this.str = str;
        this.words = dictionary.getWordsInString(str);
        this.toRemove = new HashSet<>();
        this.dictionary = dictionary;
    }




    public String[] getWords() {
        return words.toArray(new String[0]);
    }

    public Object[] getToRemove() {
        return toRemove.toArray();
    }

}
