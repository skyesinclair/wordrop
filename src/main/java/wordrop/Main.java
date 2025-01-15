package wordrop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    int width;
    int height;

    public static void main(String[] args) {
        boolean gameOver = false;

        Grid grid = new Grid(10, 8, 10);
        grid.printAllRows();
        processGrid(grid);
        while (!gameOver) {
            Tile newTile = new Tile(getRandomLetter(), 0, 0);
            int columnDrop = getUserInput(grid, newTile) - 1;
            grid.addNewTile(newTile, columnDrop);
            grid.printAllRows();
            processGrid(grid);
            gameOver = grid.isGameOver();
        }



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

    private static int getUserInput(Grid grid, Tile newTile) {
        int input = 0;
        Tile tile = newTile;
        for (int i = 0; i < grid.width; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        System.out.println("New tile: " + tile.getCharacter());
        while (input < 1 || input > grid.width) {
            System.out.println("Which column?");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();
        }

        return input;
    }

    private static Character getRandomLetter() {
        return (char) (Math.random() * 26 + 'a');
    }
}