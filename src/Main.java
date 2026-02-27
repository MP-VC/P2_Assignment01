import task1.*;
import task2.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[][] numbs1 = new double[][]{
                {1.2,  1.3, 67,   9,   -2},
                {1.34, 1.2, 1.1,  1.58, 43,5,5,-99,5,2,4,6},
                {3,    4,   21,   6,    0}
        };
        double[][] numb2 = new double[][] {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Util2DArray.min(numbs1));
        System.out.println(Arrays.toString(Util2DArray.minOfRow(numbs1)));
        System.out.println(Arrays.toString(Util2DArray.minOfCol(numbs1)));
        System.out.println(Arrays.deepToString(Util2DArray.add(numbs1,numb2)));
        System.out.println(Arrays.deepToString(Util2DArray.appendArray(numbs1,numb2)));
        System.out.println(Arrays.deepToString(Util2DArray.expendArray(numbs1,numb2)));
        System.out.println(Arrays.deepToString(Util2DArray.transposeMatrix(numbs1)));
    }
}