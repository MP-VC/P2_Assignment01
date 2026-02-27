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


    public static double[][] add(double[][] numss1, double[][] numss2) {
        int maxRows = Math.max(numss1.length, numss2.length);
        int maxCols = 0;
        for (int i = 0; i < numss1.length; i++) {
            maxCols = Math.max(maxCols, numss1[i].length);
        }
        for (int i = 0; i < numss2.length; i++) {
            maxCols = Math.max(maxCols, numss2[i].length);
        }

        double[][] result = new double[maxRows][maxCols];

        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                double val1 = (i < numss1.length && j < numss1[i].length) ? numss1[i][j] : 0;
                double val2 = (i < numss2.length && j < numss2[i].length) ? numss2[i][j] : 0;
                result[i][j] = val1 + val2;
            }
        }
        return result;
    }

    public static double[][] deleteRow(double[][] numss, int idx) {    
        double[][] result = new double[numss.length - 1][];
        
        for (int i = 0, j = 0; i < numss.length; i++) {
            if (i != idx) {
                result[j++] = numss[i];
            }
        }
        
        return result;
    }

    public static double[][] appendArray(double[][] numss1, double[][] numss2) {
        double[][] result = new double[numss1.length + numss2.length][];
        
        for (int i = 0; i < numss1.length; i++) {
            result[i] = numss1[i];
        }
        
        for (int i = 0; i < numss2.length; i++) {
            result[numss1.length + i] = numss2[i];
        }
        
        return result;
    }

    public static double[][] expendArray(double[][] numss1, double[][] numss2) {
        int maxRows;
        if (numss1.length > numss2.length) {
            maxRows = numss1.length;
        } else {
            maxRows = numss2.length;
        }

        double[][] result = new double[maxRows][];

        for (int i = 0; i < maxRows; i++) {

            int len1 = 0;
            if (i < numss1.length) {
                len1 = numss1[i].length;
            }

            int len2 = 0;
            if (i < numss2.length) {
                len2 = numss2[i].length;
            }

            double[] combinedRow = new double[len1 + len2];

            if (i < numss1.length) {
                for (int j = 0; j < len1; j++) {
                    combinedRow[j] = numss1[i][j];
                }
            }

            if (i < numss2.length) {
                for (int j = 0; j < len2; j++) {
                    combinedRow[len1 + j] = numss2[i][j];
                }
            }

            result[i] = combinedRow;
        }

        return result;
    }
    public static double[][] transposeMatrix(double[][] numss) {
        int maxCols = 0;
        
        for (int i = 0; i < numss.length; i++) {
            maxCols = Math.max(maxCols, numss[i].length);
        }

        double[][] result = new double[maxCols][numss.length];

        for (int i = 0; i < numss.length; i++) {
            for (int j = 0; j < numss[i].length; j++) {
                result[j][i] = numss[i][j];
            }
        }
        
        return result;
    }
}