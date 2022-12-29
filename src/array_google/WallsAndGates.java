package array_google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * you are given a m x n 2D grid initialized with these three possible values.
 *
 *     -1 - A wall or an obstacle.
 *     0 - A gate.
 *     INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that
 *     the distance to a gate is less than 2147483647.
 *
 * Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate,
 * it should be filled with INF.
 *
 * Given the 2D grid:
 *
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 *   0  -1 INF INF
 *
 * After running your function, the 2D grid should be:
 *
 *   3  -1   0   1
 *   2   2   1  -1
 *   1  -1   2  -1
 *   0  -1   3   4
 */
public class WallsAndGates {
    private static final int INF = 2147483647;
    public static void main(String[] args) {
        int[][] rooms ={{INF,-1,0,INF},{INF,INF,INF,-1},{INF,-1,INF,-1},{0,-1,INF,INF}};
        new WallsAndGates().wallsAndGates(rooms);
        for(int i=0;i<rooms.length;i++){
             System.out.println(Arrays.toString(rooms[i]));
        }
        System.out.println();
    }
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> que = new LinkedList<>();
        for (int i =0;i<rooms.length;i++){
            for (int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0){
                    que.add(new int[]{i,j});
                }
            }
        }
        int[][] dirs ={{1,0},{-1,0},{0,1},{0,-1}};
        while(!que.isEmpty()){
            int n = que.size();
            for (int i=0;i<n;i++){
                int[] curr = que.poll();
                for(int[] dir :dirs){
                    int nextX = curr[0]+dir[0];
                    int nextY = curr[1]+dir[1];
                    if(!isValid(rooms,nextX,nextY)){
                        continue;
                    }
                    que.add(new int[]{nextX,nextY});
                    rooms[nextX][nextY]= 1+rooms[curr[0]][curr[1]];
                }
            }
        }
    }

    private boolean isValid(int[][] rooms, int x, int y) {
        if(x<0||x>=rooms.length||y<0||y>=rooms[0].length|| rooms[x][y]!=INF){
            return false;
        }
        return true;
    }
}
