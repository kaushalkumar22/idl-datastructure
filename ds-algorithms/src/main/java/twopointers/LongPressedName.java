package twopointers;

/**
 * Your friend is typing his name into a keyboard. Sometimes, when typing a
 * character c, the key might get long pressed, and the character will be typed
 * 1 or more times.
 *<p>
 * You examine the typed characters of the keyboard. Return True if it is
 * possible that it was your friends name, with some characters (possibly none)
 * being long pressed.
 *<p>
 * Input: name = "alex", typed = "aaleex" Output: true Explanation: 'a' and 'e'
 * in 'alex' were long pressed.
 *<p>
 * Input: name = "saeed", typed = "ssaaedd" Output: false Explanation: 'e' must
 * have been pressed twice, but it wasn't in the typed output.
 *<p>
 * Input: name = "leelee", typed = "lleeelee" Output: true
 *<p>
 * Input: name = "laiden", typed = "laiden" Output: true Explanation: It's not
 * necessary to long press any character.
 *
 */
public class LongPressedName {

	public static void main(String[] args) {
		String name = "alex", typed = "aaleexa";
		System.out.println(isLongPressedName( name, typed));
		//
	}
	public static boolean isLongPressedName(String name, String typed) {

		int i = 0, m = name.length(), j=0,n = typed.length();
		while(i<m&&j<n) {
			if(name.charAt(i)==typed.charAt(j)) {
				i++;
				j++;
			}else if(i>0&&name.charAt(i-1)==typed.charAt(j)) {
				j++;
			}else {
				return false;
			}
		}

		while(j<n) {
			if(name.charAt(i-1)==typed.charAt(j)) {
				j++;
			}else {
				return false;
			}
		}
		return i == m;
	}
}

