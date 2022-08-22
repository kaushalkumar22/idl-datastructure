package graph;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingPathInAMatrix {
	public static void main(String[] args) {

	}

	public int findCelebrity(int n) {
		if (n <= 1) return -1;

		int celebrity = 0;
		// pick candidate
		for (int i = 0; i < n; i++) {
			if (celebrity != i && knows(celebrity, i)) {
				celebrity = i;
			}
		}

		// final check and return, eg: everyone in group knows nobody
		for (int i = 0; i < n; i++) {
			if (celebrity != i && !(knows(i, celebrity) && !knows(celebrity, i))) {
				return -1;
			}
		}
		return celebrity;
	}

	private boolean knows(int i, int celeb) {
		// stub
		return false;
	}


}

