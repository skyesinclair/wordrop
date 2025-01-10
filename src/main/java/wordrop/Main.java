package wordrop;

import java.util.HashSet;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Grid grid = new Grid(12, 10, 5);

        grid.printAllRows();


        List<Result> results = grid.getAllResults();


while (!results.isEmpty()) {
    for (Result result : results) {
        System.out.println(result);
    }
    HashSet<Tile> toRemove = new HashSet<>();

    for (Result result : results) {
        toRemove.addAll(result.getToRemove());
    }

    for (Tile tile : toRemove) {
        tile.setMarkedForRemoval(true);
    }

    grid.removeMarkedTiles();

    grid.printAllRows();

    grid.dropTiles();
    System.out.println("++++++++++++++++++++++++++++");
    grid.printAllRows();
    results = grid.getAllResults();
}

    }


}