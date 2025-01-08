package wordrop;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Grid grid = new Grid(15, 15, 8);

        grid.printAllRows();


        List results = grid.getResults();
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }

    }


}