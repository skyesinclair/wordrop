package wordrop;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        Grid grid = new Grid(10, 10);
//        grid.fillRowRandomly(7);
//        grid.fillRowRandomly(8);
//        grid.fillRowRandomly(9);
//        grid.printAllRows();

        String word = "abcdefgHijklmno";
        Result result = new Result(word, 8);
        System.out.println("checking string for words: " + word);
        System.out.println(Arrays.toString(result.getWords()));
        System.out.println(Arrays.toString(result.getToRemove()));
        System.out.println(result.getQueries());
    }
}