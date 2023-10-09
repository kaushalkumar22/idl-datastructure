package array_google;

/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e.,
 * there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels,
 *  return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 *
 * Example 1:
 *
 * Input：["0010","0110","0100"]，x=0，y=2
 * Output：6
 * Explanation：
 * The upper left coordinate of the matrix is (0,1), and the lower right coordinate is (2,2).
 *
 * Example 2:
 *
 * Input：["1110","1100","0000","0000"], x = 0, y = 1
 * Output：6
 * Explanation：
 * The upper left coordinate of the matrix is (0, 0), an
 */
public class SmallestRectangleEnclosingBlackPixels {
    public static void main(String[] args) {
       char[][] image = {{'1','1','1','0'},{'1','1','0','0'},{'0','0','0','0'},{'0','0','0','0'}};
       int x = 0, y = 1;
       System.out.println(minArea(image,  x,  y));
    }
    public static int minArea(char[][] image, int x, int y) {

        int m = image.length, n  = image[0].length;
        int left = y,right = y ,top =x,bottom = x;
        for (int i =0;i<m;i++){
            for(int j=0;j<n ;j++){
                if(image[i][j]=='1'){
                    top = Math.min(top,i);
                    bottom = Math.max(bottom,i);
                    left = Math.min(left,j);
                    right = Math.max(right,j);
                }
            }
        }
        return (bottom-top+1)*(right-left+1);
    }
}
