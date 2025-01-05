package wordrop;

public class Cell {
    char character;
    int row;
    int col;



    public Cell(char character, int row, int col) {
        this.character = character;
        this.row = row;
        this.col = col;
    }

    public Cell(int row, int col) {
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
