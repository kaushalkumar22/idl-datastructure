package heap_pq;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * calculate the number of platform is done by determining the maximum number of
 * train at railway station any time.
 *
 */
public class MinimumPlatformsRequire {

	public static void main(String[] args) {
		
		int arv[] = { 900, 915, 1030, 1045 };
		int dep[] = { 930, 1100, 1145, 1300 };
		int[][] times ={{900,930},{915,1100},{1030,1045},{1045,1300}};

		// 910, 1100,1120 ,1130,1130 1200 1900 2000
		// 910 ,930, 1000 ,930 ,1100, 950,1500 1800
		int platfornNums = getMinPlatformsReq(arv, dep);
		System.out.println(platfornNums);
		System.out.println(getMinPlatformsReq(times));
	}
	private static int getMinPlatformsReq(int[][] times) {
		
		Arrays.sort(times,(a,b)->Integer.compare(a[0], b[0]));
		PriorityQueue<Integer> pq =new PriorityQueue<Integer>((a,b)->Integer.compare(a, b));
		pq.add(times[0][1]);
		int count = 1;
		for(int i=1;i<times.length;i++) {
			if(pq.peek()>=times[i][0]) {
				count++;
				pq.add(times[i][1]);
			}else {
				pq.add(Math.max(pq.poll(), times[i][1]));;
			}
		}
		return count;
		
	}
	private static int getMinPlatformsReq(int[] arv, int[] dep) {
		Arrays.sort(arv);
		Arrays.sort(dep);
		// plat_needed indicates number of platforms needed at a time
		int pltReq = 0, res = 0;
		int n = arv.length;
		int i = 0, j = 0;

		// Similar to merge in merge sort to process all events in sorted order
		while (i < n && j < n) {
			// If next event in sorted order is arrival, increment count of platforms needed
			if (arv[i] <= dep[j]) {
				pltReq++;
				i++;
				res=Math.max(pltReq, res);
			} else { // Else decrement count of platforms needed
				pltReq--;
				j++;
			}
		}

		return res;
	}
}
