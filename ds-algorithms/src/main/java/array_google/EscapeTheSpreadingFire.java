package array_google;

import java.util.LinkedList;
import java.util.Queue;

public class EscapeTheSpreadingFire {
    public static void main(String[] args) {
        int[][] grid = {
                {0,2,0,0,0,0,0},
                {0,0,0,2,2,1,0},
                {0,2,0,0,1,2,0},
                {0,0,2,2,2,0,2},
                {0,0,0,0,0,0,0}
        };
        EscapeTheSpreadingFire escape = new EscapeTheSpreadingFire();
        System.out.println(escape.maximumMinutes(grid));
    }
    public int maximumMinutes(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> safe = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();
        for(int i=0 ;i<r ;i++){
            for(int j=0;j<c; j++){
                if(grid[i][j] == 1){
                    fire.add(new int[]{i,j});
                }
            }
        }
        safe.add(new int[]{0,0});
        grid[0][0] = 3;
        int safeSteps = bfs(grid,safe,false);
        if(safeSteps == -1) return -1;
        int fireSteps = bfs(grid,fire,true);
        if(fireSteps==-1) return 109;
        return  fireSteps -safeSteps -1;
    }
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    private int bfs(int[][] grid,Queue<int[]> que, boolean isFire){
        int count = 0 ;
        while(!que.isEmpty()){
            int n = que.size();
            for(int i=0;i<n ;i++){
                int[] curr = que.poll();
                if(curr[0]==grid.length-1 && curr[1]==grid[0].length-1) return count -1;
                for(int[] dir : dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if(!isValid(grid,x,y,isFire)){
                        continue;
                    }
                    if(isFire){
                        grid[x][y] = 1;
                    }else{
                        grid[x][y] = 3;
                    }
                    que.add(new int[]{x,y});
                }
            }
            count++;
        }
        return -1;
    }
    private boolean isValid(int[][] grid ,int row,int col, boolean isFire){

        if(row<0 || row >=grid.length || col<0 || col>=grid[0].length) return false;
        if(!isFire && grid[row][col]!=0){
            return false;
        }else if(isFire&&grid[row][col]!=3){
            return false;
        }else {
            return true;
        }
    }
}

