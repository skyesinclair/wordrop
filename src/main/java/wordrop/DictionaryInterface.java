package wordrop;

import java.util.HashSet;

public interface DictionaryInterface {
    public HashSet<String> getWordsInString(String str);
    public Result getResult(String str, Tile[] tiles);
    public HashSet<String> getWords();
}
