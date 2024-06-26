package xyz_graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 * 
 * Input: num = "123", target = 6 Output: ["1+2+3", "1*2*3"]
 * 
 * Input: num = "232", target = 8 Output: ["2*3+2", "2+3*2"]
 * 
 * Input: num = "105", target = 5 Output: ["1*0+5","10-5"]
 * 
 * Input: num = "00", target = 0 Output: ["0+0", "0-0", "0*0"]
 * 
 * Input: num = "3456237490", target = 9191 Output: []
 *
 */
public class ExpressionAddOperators {
	/*
	 * overflow: we use a long type once it is larger than Integer.MAX_VALUE or
	 * minimum, we get over it. 0 sequence: because we can't have numbers with
	 * multiple digits started with zero, we have to deal with it too. a little
	 * trick is that we should save the value that is to be multiplied in the next
	 * recursion.
	 */
	public List<String> addOperators(String num, int target) {
		List<String> rst = new ArrayList<String>();
		if (num == null || num.length() == 0)
			return rst;
		helper(rst, "", num, target, 0, 0, 0);
		return rst;
	}

	public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
		if (pos == num.length()) {
			if (target == eval)
				rst.add(path);
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0')
				break;
			long cur = Long.parseLong(num.substring(pos, i + 1));
			if (pos == 0) {
				helper(rst, path + cur, num, target, i + 1, cur, cur);
			} else {
				helper(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);

				helper(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);

				helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
			}
		}
	}
}
