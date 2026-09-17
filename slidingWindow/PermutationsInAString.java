/*
 * Permutation in String - 567
 *
 * Given two strings s1 and s2, return true if s2 contains 
 * a permutation of s1, or false otherwise.
 */

package slidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class PermutationsInAString {

	/*
	 * APPROACH: HashMap
	 *
	 * Use two frequency maps to store character counts and 
	 * slide a window of size s1 across s2, comparing maps.
	 *
	 * Time Complexity: O(N + M)
	 * Space Complexity: O(1)
	 */
	public static boolean isInStrHash(String s1, String s2) {
		Map<Character, Integer> win1 = new HashMap<>();
		Map<Character, Integer> win2 = new HashMap<>();
		
		if (s1.length() > s2.length()) {
			return false;
		}
		for(int i = 0; i < s1.length(); i++) {
			win1.put(s1.charAt(i), win1.getOrDefault(s1.charAt(i), 0) + 1 );
		}

		for (int i = 0; i < s2.length(); i++) {
			win2.put(s2.charAt(i), win2.getOrDefault(s2.charAt(i), 0) + 1);
			
			if (i >= s1.length()) {
				int count = win2.get(s2.charAt(i - s1.length()));
				if (count == 1) {
					win2.remove(s2.charAt(i - s1.length()));
				} else {
					win2.put(s2.charAt(i - s1.length()), win2.get(s2.charAt(i - s1.length())) - 1);
				}
			}
			if (win1.equals(win2)) {
				return true;
			}
		}
		return false;	
	}
	
	/*
	 * APPROACH: Array (Optimized)
	 *
	 * Use fixed-size integer arrays of size 26 for character frequencies 
	 * and slide a window over s2, comparing arrays with Arrays.equals().
	 * Arrays use primitives and direct indexing, avoiding HashMap's object overhead, boxing, and hashing costs.
	 * 
	 * Time Complexity: O(N + M)
	 * Space Complexity: O(1)
	 */
	public static boolean isInStrArray(String s1, String s2) {
		if (s1.length() > s2.length()) {
			return false;
		}

		int[] win1 = new int[26];
		int[] win2 = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			win1[s1.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < s2.length(); i++) {
			win2[s2.charAt(i) - 'a']++;
			
			if (i >= s1.length()) {
				win2[s2.charAt(i - s1.length()) - 'a']--;
			}
			
			if (Arrays.equals(win1, win2)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s1 = "mansamosambi";
		String s2 = "sanom";
		
		System.out.println("HashMap Approach"); 
		System.out.println("Time Complexity: O(N + M)"); 
		System.out.println("Space Complexity: O(1)"); 
		System.out.println(isInStrHash(s2, s1));
		
		System.out.println("\nArray Approach"); 
		System.out.println("Time Complexity: O(N + M)"); 
		System.out.println("Space Complexity: O(1)"); 
		System.out.println(isInStrArray(s2, s1)); 
	}
}