package wordrop;

public class Cell {
    private boolean special;
    private Tile tile;

    public Cell(boolean special, Tile tile) {
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
}
