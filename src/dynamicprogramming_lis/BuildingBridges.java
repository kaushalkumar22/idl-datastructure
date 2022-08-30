package dynamicprogramming_lis;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Consider a 2-D map with a horizontal river passing through its center. There are n cities on the southern bank with x-coordinates a(1) … a(n) and n cities on the northern bank with x-coordinates b(1) … b(n). You want to connect as many north-south pairs of cities as possible with bridges such that no two bridges cross. When connecting cities, you can only connect city a(i) on the northern bank to city b(i) on the southern bank. Maximum number of bridges that can be built to connect north-south pairs with the aforementioned constraints.
 *
 *
 * The values in the upper bank can be considered as the northern x-coordinates of the cities and the values in the bottom bank can be considered as the corresponding southern x-coordinates of the cities to which the northern x-coordinate city can be connected.
 * Examples:
 *
 * Input : 6 4 2 1
 *         2 3 6 5
 * Output : Maximum number of bridges = 2
 * Explanation: Let the north-south x-coordinates be written in increasing order.
 * 1  2  3  4  5  6
 *   \  \
 *    \  \        For the north-south pairs
 *     \  \       (2, 6) and (1, 5)
 *      \  \      the bridges can be built.
 *       \  \     We can consider other pairs also,
 *        \  \    but then only one bridge can be built
 *         \  \   because more than one bridge built will
 *          \  \  then cross each other.
 *           \  \
 * 1  2  3  4  5  6
 * Input : 8 1 4 3 5 2 6 7
 *              1 2 3 4 5 6 7 8
 * Output : Maximum number of bridges = 5
 */
class Bridge{
	int x, y;
	Bridge(int x,int y){
		this.x=x;
		this.y=y;
	}
};
public class BuildingBridges  {

	static Comparator<Bridge> SORT_NORTH = new Comparator<Bridge>() {
		public int compare(Bridge a, Bridge b) {
			return a.x < b.x ?b.x:a.x;
		}

	};

	public static int bulidingBridges(Bridge a[], int n){

		Arrays.sort(a,SORT_NORTH); 

		int ans[] = new int[n];
		int result = 1;
		for (int i = 0; i < n; i++)
			ans[i] = 1;

		for (int i = 1; i < n; i++) {       // apply LIS on right bridges
			for (int j = 0; j < i; j++) {
				if(a[i].y > a[j].y && ans[i] < ans[j] + 1)
					ans[i] = ans[j] + 1;
			}
		}

		for (int i = 0; i < n; i++)
			result = Math.max(result, ans[i]);

		return result;
	}

	public static void main(String[] args) {

		/*1 2 3 4 5 6
	      3 4 5 6 1 2 */
		Bridge a[] = {new Bridge(1, 3), new Bridge(2, 4),new Bridge(3, 5),new Bridge(4, 6),new Bridge(5, 1),new Bridge(6, 2)};
		int n = a.length;

		System.out.println( "Maximum number of bridges " + bulidingBridges(a, n));
	}



}
