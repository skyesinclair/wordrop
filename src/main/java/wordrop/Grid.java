package wordrop;

public class Grid {
    private Cell[][] cells;

    public Grid(int rows, int cols) {
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(i,j);
            }
        }
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public void setCell(int row, int col, Cell cell) {
        cells[row][col] = cell;
    }

    public void printAllRows() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j].getCharacter() + " ");
            }
            System.out.println();
        }
    }

public void fillRowRandomly(int row) {
    String vowels = "aeiou";
    String consonants = "bcdfghjklmnpqrstvwxyz";
    for (int i = 0; i < cells[row].length; i++) {
        if (Math.random() < 0.3) { // 40% chance to pick a vowel
            cells[row][i].setCharacter(vowels.charAt((int) (Math.random() * vowels.length())));
        } else { // 60% chance to pick a consonant
            cells[row][i].setCharacter(consonants.charAt((int) (Math.random() * consonants.length())));
        }
    }
}
}

