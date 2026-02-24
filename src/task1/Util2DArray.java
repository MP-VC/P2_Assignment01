package task1;

import java.util.Arrays;

public class Util2DArray {
    public static double min(double[][] numbs) {
        double min = Double.POSITIVE_INFINITY;
        for(double[] d : numbs) {
            for(double e : d) {
                if (e < min) min = e;
            }
        }
        return min;
    }
    public static double[] minOfRow(double[][] numbs) {
        double[] dob = new double[numbs.length];
        double min = Double.POSITIVE_INFINITY;
        int i = 0;
        for(double[] d : numbs) {
            for(double e : d) {
                if (e <= min) min = e;
            }
            dob[i] = min;
            i++;
            min = Double.POSITIVE_INFINITY;
        }
        return dob;
    }
    public static double[] minOfCol(double[][] numbs) {
        int length = Integer.MIN_VALUE;
        for(double[] d : numbs) {
            if(d.length > length) length = d.length;
        }

        double[][] transpose = new double[length][length];

        for (double[] doubles : transpose) {
            Arrays.fill(doubles, Double.POSITIVE_INFINITY);
        }
        for(int x = 0; x < length; x++) {
            for(int y = 0; y < length; y++) {
                try { transpose[x][y] = numbs[y][x]; }
                catch(IndexOutOfBoundsException _) {}
            }
        }
        return minOfRow(transpose);
    }
}
