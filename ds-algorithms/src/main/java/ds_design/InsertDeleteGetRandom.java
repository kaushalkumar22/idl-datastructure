package ds_design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * Implement the RandomizedSet class:
 *
 * bool insert(int val) Inserts an item val into the set if not present. Returns
 * true if the item was not present, false otherwise.
 *
 * bool remove(int val) Removes an item val from the set if present. Returns
 * true if the item was present, false otherwise.
 *
 * int getRandom() Returns a random element from the current set of elements
 * (it's guaranteed that at least one element exists when this method is
 * called). Each element must have the same probability of being returned.
 *
 * Follow up: Could you implement the functions of the class with each function
 * works in average O(1) time?
 *
 * Input ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove",
 * "insert", "getRandom"] [[], [1], [2], [2], [], [1], [2], []] 
 * Output [null,true, false, true, 2, true, false, 2]
 *
 * Explanation
 *RandomizedSet randomizedSet = new RandomizedSet();
 *randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 *randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 *randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 *randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 *randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 *randomizedSet.insert(2); // 2 was already in the set, so return false.
 *randomizedSet.getRandom(); // Since 2 is the only number in the set,getRandom() will always return 2.
 *
 */
public class InsertDeleteGetRandom {
	public static void main(String[] args) {
		InsertDeleteGetRandom randomizedSet = new InsertDeleteGetRandom();
		randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
		randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
		randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
		System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
		randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
		randomizedSet.insert(2); // 2 was already in the set, so return false.
		System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set,getRandom() will always return 2.

		ArrayList<Integer> nums =new ArrayList<>();
		nums.add(1);
		nums.add(3);
		nums.add(4);
		nums.add(5);
		nums.set(1,2);
		System.out.println(nums);
	}
	ArrayList<Integer> nums;
	HashMap<Integer, Integer> locs;
	Random rand = new Random();

	/** Initialize your data structure here. */
	public InsertDeleteGetRandom() {
		nums = new ArrayList<Integer>();
		locs = new HashMap<Integer, Integer>();
	}

	/** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	public boolean insert(int val) {
		boolean contain = locs.containsKey(val);
		if ( contain ) return false;
		locs.put( val, nums.size());
		nums.add(val);
		return true;
	}

	/** Removes a value from the set. Returns true if the set contained the specified element. */
	public boolean remove(int val) {
		boolean contain = locs.containsKey(val);
		if ( ! contain ) return false;
		int loc = locs.get(val);
		if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
			int lastone = nums.get(nums.size() - 1 );
			nums.add( loc , lastone );
			locs.put(lastone, loc);
		}
		locs.remove(val);
		nums.remove(nums.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {

		return nums.get( rand.nextInt(nums.size()));
	}
}

