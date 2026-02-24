import task1.*;
import task2.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[][] numbs = new double[][]{
                {1.2,  1.3, 67,   9,   -2},
                {1.34, 1.2, 1.1,  1.58, 43,5,5,-99,5,2,4,6},
                {3,    4,   21,   6,    0}
        };
        System.out.println(Util2DArray.min(numbs));
        System.out.println(Arrays.toString(Util2DArray.minOfRow(numbs)));
        System.out.println(Arrays.toString(Util2DArray.minOfCol(numbs)));
    }
}