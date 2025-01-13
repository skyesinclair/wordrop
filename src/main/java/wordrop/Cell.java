package wordrop;

public class Cell {
    public int col;
    public int Row;
    private boolean special;

    public Cell(int row, int col, boolean special, Tile tile) {
        this.col = col;
        this.Row = row;
        this.special = special;
    }

    public boolean isSpecial() {
        return special;
    }


    public int getCol() {
        return col;
    }

    public int getRow() {
        return Row;
    }
}
