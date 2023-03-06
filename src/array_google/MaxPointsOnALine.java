package array_google;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

    public static void main(String[] args) {
        int[][] points = {{1,1},{2,2},{3,3}};
        System.out.println(new MaxPointsOnALine().maxPoints(points));
    }

    public int maxPoints(int[][] points) {
        int n = points.length;

        if (n == 1) {
            return 1;
        }

        int max = 0;

        for (int i=0; i < n; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j=0; j < n; j++) {
                if(i != j) {
                    double slope = calculateSlope(points[i], points[j]);

                    map.put(slope, map.getOrDefault(slope, 0) + 1);

                    max = Math.max(max, map.get(slope));
                }
            }
        }

        return max + 1;
    }

    private double calculateSlope(int[] p1, int[] p2) {
        int x1 = p1[0], x2 = p2[0];
        int y1 = p1[1], y2 = p2[1];

        if (x1 == x2) return Double.MAX_VALUE;
        if (y1 == y2) return 0;
        return (double) (y2 - y1) / (double) (x2 - x1);
    }
}