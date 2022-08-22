package trie;

/**
 * 
 * Given an integer array nums, return the maximum result of nums[i] XOR
 * nums[j], where 0 ≤ i ≤ j < n.
 * 
 * Follow up: Could you do this in O(n) runtime?
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,10,5,25,2,8] Output: 28 Explanation: The maximum result is 5
 * XOR 25 = 28.
 * 
 * Example 2:
 * 
 * Input: nums = [0] Output: 0
 * 
 * Example 3:
 * 
 * Input: nums = [2,4] Output: 6
 * 
 * Example 4:
 * 
 * Input: nums = [8,10,2] Output: 10
 * 
 * Example 5:
 * 
 * Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70] Output: 127
 *
 * 
 */
public class MaximumXORofTwoNumbersInAnArray {

	class Trie {
        Trie[] children;
        public Trie() {
            children = new Trie[2];
        }
    }
    
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // Init Trie.
        Trie root = new Trie();
        for(int num: nums) {
            Trie curNode = root;
            for(int i = 31; i >= 0; i --) {
                int curBit = (num >>> i) & 1;
                if(curNode.children[curBit] == null) {
                    curNode.children[curBit] = new Trie();
                }
                curNode = curNode.children[curBit];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int num: nums) {
            Trie curNode = root;
            int curSum = 0;
            for(int i = 31; i >= 0; i --) {
                int curBit = (num >>> i) & 1;
                if(curNode.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    curNode = curNode.children[curBit ^ 1];
                }else {
                    curNode = curNode.children[curBit];
                }
            }
            max = Math.max(curSum, max);
        }
        return max;
    }
}
