package wordrop;

import java.util.ArrayList;
import java.util.List;

//todo: maybe make cells a single array instead of 2d array with a row and column property?

//todo: remove the cells knowledge of tiles and just use the getTile method in grid

public class Grid {
    private List<Tile> tiles;
    private Cell[][] cells;

    int width;
    int height;
    Dictionary dictionary;

    public Grid(int height, int width, int fillHeight) {
        this.width=width;
        this.height=height;
        this.dictionary = new Dictionary();
        cells = new Cell[height][width];
        tiles = new ArrayList<Tile>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell(i, j, false, null);
            }
        }
        for (int i = 0; i <fillHeight; i++) {
            if(i<height) {
                fillRowRandomly(height-i-1);

            }
        }
    }


    public void printAllRows() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (getTile(i,j) == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(getTile(i,j).getCharacter() + " ");
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
        List<Tile> line = new ArrayList<>();
        while (row > 0 && row < height && col < width) {
            if (getTile(row,col) == null) {
                line.add(new Tile('!',row, col));
            }
            else {
                line.add(getTile(row,col));
            }
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
        return line;
    }

private void fillRowRandomly(int row) {
    String vowels = "aeiou";
    String consonants = "bcdfghjklmnpqrstvwxyz";
    for (int i = 0; i < cells[row].length; i++) {
        Tile tile;
        if (Math.random() < 0.3) { // 30% chance to pick a vowel
            tile = new Tile(vowels.charAt((int) (Math.random() * vowels.length())), row, i);
        } else { // 70% chance to pick a consonant
            tile = new Tile(consonants.charAt((int) (Math.random() * vowels.length())), row, i);
        }

        tile.setCell(row, i);
        tiles.add(tile);
        cells[row][i].setTile(tile);
    }
}

public void removeTiles(Tile[] tilesToRemove) {
    for (Tile tile : tilesToRemove) {
        int col = tile.getCol();
        int row = tile.getRow();
        cells[row][col].setTile(null);
        tiles.remove(tile);
    }
}



    public void removeMarkedTiles() {
        for (int i = 0; i < tiles.size(); i++) {
                if (tiles.get(i).isMarkedForRemoval()) {
                    Tile tile = tiles.get(i);
                    cells[tile.getRow()][tile.getCol()].setTile(null);
                    tiles.remove(tile);
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

    public void addNewTile(Tile newTile, int column) {
        for (int i = cells.length-1; i > 0; i--) {
            if (getTile(i,column) == null) {
                newTile.setCell(i, column);
                tiles.add(newTile);
                break;
            }
        }
    }

    public Tile getTile(int row, int col) {
        Tile tile = null;
        for (int i = 0; i < tiles.size(); i++) {
            if(tiles.get(i).getRow()==row&&tiles.get(i).getCol()==col) {
                tile = tiles.get(i);
            }
        }
        return tile;
    }

}

