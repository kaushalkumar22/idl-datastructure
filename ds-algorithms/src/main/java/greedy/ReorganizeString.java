package greedy;

/**
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 * Return any possible rearrangement of s or return "" if not possible.
 *
 * Input: s = "aab"
 * Output: "aba"
 *
 * Input: s = "aaab"
 * Output: ""
 * Constraints:
 *     1 <= s.length <= 500
 *     s consists of lowercase English letters.
 */
public class ReorganizeString {
	public static void main(String[] args) {
		System.out.println(reorganizeString("aaab"));
	}
	public static String reorganizeString(String s) {
		int n = s.length();
		int[] cache = new int[26];
		int maxCharCount =0;
		char mostFreqChar =0;
		for(char c : s.toCharArray()){
			cache[c-'a']++;
			if(maxCharCount<cache[c-'a']){
				maxCharCount = cache[c-'a'];
				mostFreqChar = c;
			}
		}
		//max char size is more than half that means same cahr will be together
		if(maxCharCount>(n+1)/2){
			return "";
		}
		char[] res = new char[n];
		int index = 0 ;
		while(cache[mostFreqChar-'a']>0){
			res[index] = mostFreqChar;
			cache[mostFreqChar - 'a']--;
			index += 2;
		}
		for(int i = 0 ;i<26; i++){
			int curr = cache[i];
			while(curr>0){
				if(index>=n){
					index = 1;
				}
				char ch = (char)(i + 'a');
				res[index] = ch;
				cache[i]--;
				curr = cache[i];
				index += 2;
			}
		}
		return new String(res);
	}
}
