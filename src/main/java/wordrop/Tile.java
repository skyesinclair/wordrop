package wordrop;

public class Tile {
    char character;
    int row;
    int col;
    boolean markedForRemoval = false;



    public Tile(char character, int row, int col) {
        this.character = character;
        this.row = row;
        this.col = col;
    }



    public boolean isMarkedForRemoval() {
        return markedForRemoval;
    }

    public void setMarkedForRemoval(boolean markedForRemoval) {
        this.markedForRemoval = markedForRemoval;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setCell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "character=" + character +
                ", row=" + row +
                ", col=" + col +
                '}';
    }
}
