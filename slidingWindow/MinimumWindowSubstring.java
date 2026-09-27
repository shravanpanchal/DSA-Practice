/*
 * Minimum Window Substring - 76
 *
 * Given two strings s and t, return the minimum window substring of s 
 * such that every character in t (including duplicates) is included in the window.
 */

package slidingWindow;

public class MinimumWindowSubstring {

	/*
	 * APPROACH: Brute Force
	 *
	 * Generate all possible substrings of s, and for each substring, check if it 
	 * contains all characters of t with the required frequencies. Track the minimum length.
	 *
	 * Time Complexity: O(N^3)
	 * Space Complexity: O(1) (excluding space for substring creation, or O(K) for character frequency array)
	 */
	public static String minWindowBrute(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) {
			return "";
		}
		
		int maxLen = Integer.MAX_VALUE;
		String Answer = "";
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				String temp = s.substring(i, j + 1);

				if (isValid(temp, t)) {
					if	 (temp.length() < maxLen) {
						maxLen = temp.length();
						Answer = temp;
					}
				}
			}
		}

		return Answer;
	}
	
	private static Boolean isValid(String str, String t) {

		int[] count = new int[128];
		for (int i = 0; i < t.length(); i++) {
			count[t.charAt(i) ]++;
			
		}
		
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]--;

		}
		
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				return false;
			}
			
		}
		return true;
	}
	
	/*
	 * APPROACH: Sliding Window (Optimized)
	 *
	 * Expand the right pointer to find a valid window containing all characters of t. 
	 * Once valid, contract the left pointer to find the minimum possible window size.
	 * Uses an ASCII integer array for fast frequency tracking without object overhead.
	 * 
	 * Time Complexity: O(N) where N is the length of string s
	 * Space Complexity: O(1) since the frequency array size is fixed at 128 (ASCII set)
	 */
	public static String minWindowOptimal(String s, String t){
		
		int left = 0;
		String Answer = "";
		int[] count = new int[128];
		int required = t.length();
		int maxLen = Integer.MAX_VALUE;
		
		for (char c : t.toCharArray()) {
			count[c]++;
		}
		
		for (int right = 0; right < s.length(); right++) {
			if (count[s.charAt(right)] > 0) {
				required--;
			}
			count[s.charAt(right)]--;
			
			while (required == 0) {
			    int len = right - left + 1;
				if (len < maxLen) {
					Answer = s.substring(left, right + 1);
					maxLen = len;

				}

				count[s.charAt(left)]++;
				if(count[s.charAt(left)] > 0) {
					required++;
				}
				left++;

				
			}
		}
		return Answer;
	}
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		// Expected: "BANC"
		
		System.out.println("Sliding Window Optimal Approach");
		System.out.println("Time Complexity: O(N)");
		System.out.println("Space Complexity: O(1)");
		System.out.print(minWindowOptimal(s, t));
	}
}