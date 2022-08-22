package xyz_miscellaneous;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * In an election, the i-th vote was cast for persons[i] at time times[i].
 * 
 * Now, we would like to implement the following query function:
 * TopVotedCandidate.q(int t) will return the number of the person that was
 * leading the election at time t.
 * 
 * Votes cast at time t will count towards our query. In the case of a tie, the
 * most recent vote (among tied candidates) wins.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ["TopVotedCandidate","q","q","q","q","q","q"],
 * [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]] Output:
 * [null,0,1,1,0,0,1] Explanation: At time 3, the votes are [0], and 0 is
 * leading. At time 12, the votes are [0,1,1], and 1 is leading. At time 25, the
 * votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent
 * vote.) This continues for 3 more queries at time 15, 24, and 8
 * 
 * @author I339640
 *
 */
public class OnlineElection {

/*	Initialization part
	In the order of time, we count the number of votes for each person.
	Also, we update the current lead of votes for each time point.
	if (count[person] >= count[lead]) lead = person

	Time Complexity: O(N)


	Query part
	Binary search t in times,
	find out the latest time point no later than t.
	Return the lead of votes at that time point.

	Time Complexity: O(logN)

*/
	    Map<Integer, Integer> m = new HashMap<>();
	    int[] time;
	    public void TopVotedCandidate(int[] persons, int[] times) {
	        int n = persons.length, lead = -1;
	        Map<Integer, Integer> count = new HashMap<>();
	        time = times;
	        for (int i = 0; i < n; ++i) {
	            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
	            if (i == 0 || count.get(persons[i]) >= count.get(lead)) lead = persons[i];
	            m.put(times[i], lead);
	        }
	    }

	    public int q(int t) {
	        int i = Arrays.binarySearch(time, t);
	        return i < 0 ? m.get(time[-i-2]) : m.get(time[i]);
	    }
}
