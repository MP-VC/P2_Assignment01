package task1;

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
}
