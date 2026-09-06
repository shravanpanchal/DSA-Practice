/*
 * LeetCode: 953 - Verifying an Alien Dictionary
 *
 * Problem Statement:
 *
 * In an alien language, the order of the English alphabet is different from
 * the normal English alphabet.
 *
 * You are given a string 'order' that represents the order of characters in
 * the alien language. Each character appears exactly once in 'order'.
 *
 * You are also given an array of strings 'words' that represents a dictionary.
 *
 * Return true if the words are sorted lexicographically according to the
 * alien character order; otherwise, return false.
 *
 * Example 1:
 * Input:
 * words = ["hello", "leetcode"]
 * order = "hlabcdefgijkmnopqrstuvwxyz"
 *
 * Output:
 * true
 *
 * Example 2:
 * Input:
 * words = ["word", "world", "row"]
 * order = "worldabcefghijkmnpqstuvxyz"
 *
 * Output:
 * false
 *
 * LeetCode: 953 - Verifying an Alien Dictionary
 */


package strings;

import java.util.HashMap;

public class Verify_Alien_Dictionary {
	
	
	public static boolean verify_Alien_Dict(String[] str, String order) {
		int n = str.length - 1;
		HashMap<Character, Integer> orders = new HashMap<>();

		for (int i = 0; i<order.length(); i++) {
			orders.put(order.charAt(i), i);
		}
		for (int i = 0; i < n; i++) {
			int len = Math.min(str[i].length(), str[i+1].length());
			for (int j = 0; j < len; j++) {
			if (orders.get(str[i].charAt(j)) > orders.get(str[i+1].charAt(j))) {
				return false;
			}
			if (orders.get(str[i].charAt(j)) < orders.get(str[i+1].charAt(j))) {
				break;
			}
			
			else {
				if (str[i].startsWith(str[i+1]) && str[i].length() > str[i+1].length()) {
					return false;
				}
					
			}
		}
	}
		return true;
	}
	
	public static void main(String[] args) {
		 String[] words = {"hello", "leetcode"};
		 String order = "hlabcdefgijkmnopqrstuvwxyz";
		 
		 System.out.println(verify_Alien_Dict(words, order));
	}	
}
