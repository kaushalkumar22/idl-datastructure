package array_google;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 * given three people living at (0,0), (0,4), and (2,2):
 *
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 *
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal.
 *
 * ----------------------------------------------------------------------------------------------
 * Brute Force
 *
 *     Try every point and calculate the 1's distance to this point
 *     The best distance can be found by using min function
 *     Time complexity O(m^2n^2)
 *     Space complexity O(mn)
 *
 * Optimization :
 *
 * Let the Best Meeting Point be P : (x, y)
 *
 * Distance of every point from P will be given by,
 *
 * D = |Gx - x| + |Gy - y| + |Hx - x| + |Hy - y| + |Jx - x| + |Jy - y| + |Kx - x| + |Ky - y|
 *
 * which can also be written as,
 *
 * D = Dx + Dy
 * where, Dx  =  |Gx - x|  + |Hx - x| + |Jx - x|  + |Kx - x|
 *   and, Dy = |Gy - y| + |Hy - y| + |Jy - y| + |Ky - y|
 *
 * To minimize D, we should minimize Dx and Dy.
 *
 * Dx will be minimum if x is the median of (Gx, Hx, Jx, Kx)
 * and Similarly, Dy will be minimum if y is the median of (Gy, Hy, Jy, Ky)
 *
 * Steps :
 *
 *     Store all horizontal and vertical positions of all group member.
 *     Now sort it to find minimum middle position, which will be the best meeting point.
 *     Find the distance of all members from best meeting point.
 *
 * For example in above diagram, horizontal positions are {0, 2, 0} and vertical positions are {0, 2, 4}.
 * After sorting both, we get {0, 0, 2} and {0, 2, 4}. Middle point is (0, 2).
 *
 * Note : Even no. of 1’s have two middle points, then also it works. Two middle points means it have two best
 * meeting points always. Both cases will give same distance. So we will consider only one best meeting point
 * to avoid the more overhead, Because our aim is to find the distance only.
 *
 *  Time complexity O(mn)
 *  Space complexity O(mn)
 */
public class BestMeetingPoint {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0, 1},
               {0, 0, 0, 0, 0},
               {0, 0, 1, 0, 0}};
        /*int[][] grid = {{1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0}};*/
        new BestMeetingPoint().minTotalDistance(grid);
    }
    public int minTotalDistance(int[][] grid) {

        List<Integer> xs = new ArrayList<>();
        List<Integer> ys = new ArrayList<>();
        int count =0;
        int xSum = 0;
        int ySum = 0;
        for (int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    xs.add(i);
                    ys.add(j);
                    xSum+=i;
                    ySum+=j;
                    count++;
                }
            }
        }
        System.out.println(xSum/count+" "+ySum/count );
        int xMedian = xs.stream().collect(Collectors.summingInt(Integer::intValue))/xs.size();
        int yMedian = ys.stream().collect(Collectors.summingInt(Integer::intValue))/ys.size();
        int dis=0;
        for(int i=0;i<xs.size();i++){
            dis += Math.abs(xs.get(i)-xMedian) + Math.abs(ys.get(i)-yMedian);
        }

        System.out.println(xMedian+" "+yMedian +" "+dis);
        return dis;
    }
}
