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

    public Result(String str, int position) {
        this.str = str;
        this.position = position;
        this.words = new HashSet<>();
        this.toRemove = new HashSet<>();
        findWords(3);
        findWords(2);
        findWords(1);
    }

private void findWords(int start) {

    //check if there is a word that contains the 3 characters before the new character
if (position >= start && wordContains(str.substring(position - start, position))){
    //if so, continue checking to beginning of the string
    //loop through the string from the new character to the beginning
    for (int i = position-start; i > 0; i--) {
        //if a word starts with the characters from the current position to the new character
        if (wordStartsWith(str.substring(i, position))) {
            //check if the substring is a word and if so add to list
                addIfWord(i, position);
                //loop through the string from the new character to the end
                for (int j = position; j < str.length(); j++) {
                    //if a word starts with the characters from the new character to the current position
                    if (wordStartsWith(str.substring(i, j))) {
                        //check if the substring is a word and if so add to list
                        addIfWord(i, j);
                    }
                }

        }

    }
}



    //once it gets a negative, start checking from the last positive
    //position to see if a word starts with the characters to the new character
    //if so, continue to the right of the new character until negative reached.
    //for each positive, also check if it is a word, and if so, add it to the list.
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
        if(str.length() >= 3) {
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
