package wordrop;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.List;

public class Grid {
    private Tile[][] tiles;

    int width;
    int height;
    myDictionary dictionary;

    public Grid(int height, int width, int fillHeight) {
        this.width=width;
        this.height=height;
        this.dictionary = new myDictionary();
        tiles = new Tile[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[i][j] = new Tile(i,j);
            }
        }
        for (int i = 0; i <fillHeight; i++) {
            if(i<height) {
                fillRowRandomly(height-i-1);

            }
        }
    }

    public Tile getCell(int row, int col) {
        return tiles[row][col];
    }

    public void setCell(int row, int col, Tile tile) {
        tiles[row][col] = tile;
    }

    public void printAllRows() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                System.out.print(tiles[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }

//    todo: create method to remove all tiles marked for removal

    public List<String> getResults() {
        List<String> results = new ArrayList<>();
        List<List<Tile>> allLines = getAllLines();
        for (List<Tile> line : allLines) {
            StringBuilder sb = new StringBuilder();
            for (Tile tile : line) {
                sb.append(tile.getCharacter());
            }
            String lineString = sb.toString();
            for (String word : dictionary.getWordsInString(lineString)) {
                results.add(word);
            }
        }
        return results;
    }

    public List<List<Tile>> getAllLines() {
        List<List<Tile>> results = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            results.add(getLine(i, 0, Direction.ACROSS));
            results.add(getLine(i, 0, Direction.DIAGONALDOWN));
            results.add(getLine(i, width - 1, Direction.DIAGONALUP));
        }
        for (int i = 1; i < width; i++) {
            results.add(getLine(0, i, Direction.DOWN));
            results.add(getLine(height - 1, i, Direction.UP));
            results.add(getLine(0, i, Direction.DIAGONALDOWN));
            results.add(getLine(height - 1, i, Direction.DIAGONALUP));
        }
        return results;
    }

public List<Result> getAllResults() {
        List<Result> results = new ArrayList<>();
        List<List<Tile>> allLines = getAllLines();
        for (List<Tile> line : allLines) {
            StringBuilder sb = new StringBuilder();
            for (Tile tile : line) {
                sb.append(tile.getCharacter());
            }
            String lineString = sb.toString();
            Result result = dictionary.getResult(lineString, line.toArray(new Tile[0]));
            if(result.getWords().length>0) {
                results.add(result);
            }
        }
        return results;
}

    public List<Tile> getLine(int row, int col, Direction direction) {
        List<Tile> result = new ArrayList<>();
        while (row > 0 && row < height && col < width) {

            result.add(tiles[row][col]);
            switch (direction) {
                case ACROSS:
                    col++;
                    break;
                case DOWN:
                    row++;
                    break;
                case UP:
                    row--;
                    break;
                case DIAGONALDOWN:
                    row++;
                    col++;
                    break;
                case DIAGONALUP:
                    row--;
                    col++;
                    break;
            }
        }
        return result;
    }

private void fillRowRandomly(int row) {
    String vowels = "aeiou";
    String consonants = "bcdfghjklmnpqrstvwxyz";
    for (int i = 0; i < tiles[row].length; i++) {
        if (Math.random() < 0.3) { // 30% chance to pick a vowel
            tiles[row][i].setCharacter(vowels.charAt((int) (Math.random() * vowels.length())));
        } else { // 70% chance to pick a consonant
            tiles[row][i].setCharacter(consonants.charAt((int) (Math.random() * consonants.length())));
        }
    }
}
}

