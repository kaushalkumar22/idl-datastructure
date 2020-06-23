package com.algo.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Note: This is a companion problem to the System Design problem: Design
 * TinyURL. TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such
 * as http://tinyurl.com/4e9iAk. Design the encode and decode methods for the
 * TinyURL service. There is no restriction on how your encode/decode algorithm
 * should work. You just need to ensure that a URL can be encoded to a tiny URL
 * and the tiny URL can be decoded to the original URL.
 * 
 * solution:
 * It's possible that a randomly generated code has already been generated
 * before. In that case, another random code is generated instead. Repeat until
 * we have a code that's not already in use. How long can this take? Well, even
 * if we get up to using half of the code space, which is a whopping 626/2 =
 * 28,400,117,792 entries, then each code has a 50% chance of not having
 * appeared yet. So the expected/average number of attempts is 2, and for
 * example only one in a billion URLs takes more than 30 attempts. And if we
 * ever get to an even larger number of entries and this does become a problem,
 * then we can just use length 7. We'd need to anyway, as we'd be running out of
 * available codes.
 */
public class EncodeAndDecodeTinyURL {

	Map<String, String> index = new HashMap<String, String>();
	Map<String, String> revIndex = new HashMap<String, String>();
	static String BASE_HOST = "http://tinyurl.com/";

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		if (revIndex.containsKey(longUrl))
			return BASE_HOST + revIndex.get(longUrl);
		String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String key = null;
		do {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				int r = (int) (Math.random() * charSet.length());
				sb.append(charSet.charAt(r));
			}
			key = sb.toString();
		} while (index.containsKey(key));
		index.put(key, longUrl);
		revIndex.put(longUrl, key);
		return BASE_HOST + key;
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return index.get(shortUrl.replace(BASE_HOST, ""));
	}
}
