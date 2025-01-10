package wordrop;

import java.util.Arrays;
import java.util.HashSet;

public class Result {
//todo: make this return the positions of the letters to remove
    // the string to search for words
    private String str;
    // list of words found in the string
    private String[] words;
    // list of positions of characters to remove
    private HashSet<Tile> toRemove;

    public Result(String str, String[] words, HashSet<Tile> toRemove) {
        this.str = str;
        this.words = words;
        this.toRemove = toRemove;
    }


    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public HashSet<Tile> getToRemove() {
        return toRemove;
    }

    public void setToRemove(HashSet<Tile> toRemove) {
        this.toRemove = toRemove;
    }

    @Override
    public String toString() {
        return "Result{" +
                "str='" + str + '\'' +
                ", words=" + Arrays.toString(words) +
                ", toRemove=" + toRemove +
                '}';
    }
}
