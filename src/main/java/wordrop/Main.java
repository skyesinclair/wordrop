package wordrop;

import java.util.HashSet;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Grid grid = new Grid(20, 20, 15);

        grid.printAllRows();


        List<Result> results = grid.getAllResults();
        for (Result result : results) {
            System.out.println(result);
        }

        HashSet<Tile> toRemove = new HashSet<>();

        int index = 0;
        for (Result result : results) {
                toRemove.addAll(result.getToRemove());
                index++;
        }

        for (Tile tile : toRemove) {
            tile.setCharacter(Character.toUpperCase(tile.getCharacter()));
        }

        grid.printAllRows();


    }


}