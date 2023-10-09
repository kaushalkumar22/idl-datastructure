package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
        System.out.println(spiralOrder2(matrix));
    }

    public static List<Integer> spiralOrder2(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }



    public static List<Integer> spiralOrder(int[][] A) {
        List ans = new ArrayList();
        int row = A.length;
        int col = A[0].length;

        int startRow= 0 ,startCol=0,endCol= col-1,endRow=row-1;

        while(startRow<=endRow&&startCol<=endCol){

            for(int i=startCol;i<=endCol;i++){
                ans.add(A[startRow][i]);
            }
            startRow++;
            for(int i=startRow;i<=endRow;i++){
                ans.add(A[i][endCol]);
            }
            endCol--;
            for(int i=endCol;i>=startCol;i--){
                ans.add(A[endRow][i]);
            }
            endRow--;
            for(int i=endRow;i>=startRow;i--) {
                ans.add(A[i][startCol]);
            }
            startCol++;
        }
        return ans;
    }
}

