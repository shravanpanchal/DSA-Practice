/*
 * Longest Substring Without Repeating Characters - 3
 *
 * Given a string s, find the length of the longest substring 
 * without repeating characters.
 */

package slidingWindow;
import java.util.HashSet;

public class LongestSubarrayWithoutRepeatingCharacter {

	/*
	 * APPROACH: HashSet Sliding Window
	 *
	 * Use a HashSet to track characters in the current window and 
	 * slide the left pointer when a duplicate character is encountered.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(min(n, alphabet size))
	 */
	public static int lengthOfLongestSubstringSet(String str) {
		
		if (str == null || str.length() == 0) {
			return 0;
		}
		
		int n = str.length();
		if (n == 1) {
			return 1;
		}
		
		HashSet<Character> set = new HashSet<>();
		
		int right = 0;
		int left = 0;
		int maxLen = 0;
		
		// Expand the right pointer and shrink the left pointer upon duplicates.
		for (right = 0; right < n; right++) {
			while (set.contains(str.charAt(right))) {
				set.remove(str.charAt(left));
				left++;
			}
			set.add(str.charAt(right));
			maxLen = Math.max(maxLen, right - left + 1);
		}
		return maxLen;
	}
	
	/*
	 * APPROACH: Frequency Array Sliding Window
	 *
	 * Use a fixed-size integer array to track character frequency 
	 * within the sliding window, adjusting the left boundary on duplicate occurrences.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public static int lengthOfLongestSubStringOptimal(String str) {
		
		if (str == null || str.length() == 0) {
			return 0;
		}
		int n = str.length();
		if (n == 1) {
			return 1;
			
		}
		int left = 0;
		int right = 0;
		int maxLen = 0;
		int[] count = new int[26];
		
		// Expand window with right pointer and update frequency array.
		for (right = left; right < n; right++) {
			count[str.charAt(right) - 'A']++;
			
			// Shrink window from the left if duplicate frequency exceeds 1.
			while (count[str.charAt(right) - 'A'] > 1) {
				count[str.charAt(left) - 'A']--;
				left++;
					
			}
			
			maxLen = Math.max(maxLen, right - left + 1);
		}
		return maxLen;
	}
	
	public static void main(String args[]) {
		String str = "MANDRYZLOCHGANDERREP";
		
		System.out.println("HashSet Sliding Window");
		System.out.println("Time Complexity: O(n)");
		System.out.println("Space Complexity: O(min(n, alphabet size))");
		System.out.println(lengthOfLongestSubstringSet(str));

		System.out.println("\nFrequency Array Sliding Window");
		System.out.println("Time Complexity: O(n)");
		System.out.println("Space Complexity: O(1)");
		System.out.println(lengthOfLongestSubStringOptimal(str));
	}
}