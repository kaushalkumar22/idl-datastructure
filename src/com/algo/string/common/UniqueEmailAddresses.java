package com.algo.string.common;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
	public static void main(String[] args) {
   System.out.println(numUniqueEmails(new String[] {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
	}
	public static int numUniqueEmails(String[] emails) {
		Set<String> normalized = new HashSet<>(); // used to save simplified email address, cost O(n) sapce.
		for (String email : emails) {
			String[] parts = email.split("@"); // split into local and domain parts.
			String[] local = parts[0].split("\\+"); // split local by '+'.
			normalized.add(local[0].replace(".", "") + "@" + parts[1]); // remove all '.', and concatenate '@' and domain.        
		}
		return normalized.size();
	}
}

