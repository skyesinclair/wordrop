package wordrop;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private Tile[][] tiles;
    private Cell[][] cells;

    int width;
    int height;
    Dictionary dictionary;

    public Grid(int height, int width, int fillHeight) {
        this.width=width;
        this.height=height;
        this.dictionary = new Dictionary();
        cells = new Cell[height][width];
        tiles = new Tile[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile = new Tile(i, j);
                tiles[i][j] = tile;
                cells[i][j] = new Cell(i, j, false, tile);
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
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].getTile() == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(cells[i][j].getTile().getCharacter() + " ");
                }
            }
                System.out.println();
            }
        }



    public List<String> getResults() {
        List<String> results = new ArrayList<>();
        List<List<Tile>> allLines = getAllLines();
        for (List<Tile> line : allLines) {
            StringBuilder sb = new StringBuilder();
            for (Tile tile : line) {
                sb.append(tile.getCharacter());
            }
            String lineString = sb.toString();
            results.addAll(dictionary.getWordsInString(lineString));
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
            if (cells[row][col].getTile() == null) {
                result.add(new Tile('.',row, col));
            }
            result.add(cells[row][col].getTile());
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

    public void removeMarkedTiles() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j].isMarkedForRemoval()) {
                    cells[i][j].setTile(null);
                    tiles[i][j] = null;
                }
            }
        }
    }

    public void dropTiles() {
        for (int i = cells.length - 1; i >= 0; i--) {
            for (Cell cell : cells[i]) {
                if(cell.getTile()==null&&i>0) {
                        Cell cellAbove = cells[cell.getRow() - 1][cell.getCol()];

                            while (cellAbove.getTile() == null && cellAbove.getRow() > 0) {
                                cellAbove = cells[cellAbove.getRow() - 1][cellAbove.getCol()];
                            }
                            if(cellAbove.getTile()!=null) {
                                cell.setTile(cellAbove.getTile());
                                cell.getTile().setRow(i);
                                cellAbove.setTile(null);
                        }


                }
            }
        }
    }
}

