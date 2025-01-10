package wordrop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Grid grid = new Grid(16, 12, 10);

        grid.printAllRows();
        processGrid(grid);


    }

    private static void processGrid(Grid grid) {
        List<Result> results = grid.getAllResults();


        while (!results.isEmpty()) {
            List<String> words = new ArrayList<>();
            for (Result result : results) {
                words.addAll(List.of(result.getWords()));
            }
            System.out.println(words);
            HashSet<Tile> toRemove = new HashSet<>();

            for (Result result : results) {
                toRemove.addAll(result.getToRemove());
            }


            grid.removeTiles(toRemove.toArray(new Tile[0]));



            grid.dropTiles();
grid.printAllRows();
            results = grid.getAllResults();
        }

    }
}