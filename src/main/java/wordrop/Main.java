package wordrop;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Grid grid = new Grid(20, 20, 15);

        grid.printAllRows();


        List<String> results = grid.getResults();
        for (Object result : results) {
            System.out.println(result);
        }

    }


}