package wordrop;

public class Tile {
    char character;
    int row;
    int col;

//todo: make Tile objects aware of position in Grid

    public Tile(char character, int row, int col) {
        this.character = character;
        this.row = row;
        this.col = col;
    }

    public Tile(int row, int col) {
        this.character = '.';
        this.row = row;
        this.col = col;
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
}
