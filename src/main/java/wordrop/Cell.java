package wordrop;

public class Cell {
    public int col;
    public int Row;
    private boolean special;
    private Tile tile;

    public Cell(int row, int col, boolean special, Tile tile) {
        this.col = col;
        this.Row = row;
        this.special = special;
        this.tile = tile;
    }

    public boolean isSpecial() {
        return special;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return Row;
    }
}
