/*
 * Longest Repeating Character Replacement - 424
 *
 * You are given a string s and an integer k. You can choose any
 * character and replace it with any other uppercase English character
 * at most k times. Return the length of the longest substring that
 * can contain the same letter after the replacements.
 */

package slidingWindow;

public class LongestSubstringCharacterReplacement {
	
	/*
	 * APPROACH: Brute Force
	 *
	 * Try every possible substring and count the frequency of each
	 * character. For each substring, find the most frequent character
	 * and calculate the number of replacements needed.
	 *
	 * replacements = substring length - max frequency
	 *
	 * If the replacements are within k, update the maximum length.
	 *
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 */
	public static int characterReplacementBrute(String str, int k) {
		
		int maxLen = 0;
		int n = str.length();
		
		if (str == null || n == 0) {
			return 0;
			
		}
		
		if (n == 1) {
			return 1;
		}
		
		// Check every possible starting position.
		for (int i = 0; i < n; i++) {
			
			int[] count = new int[26];
			int maxFreq = 0;
			
			// Extend the substring from the current starting position.
			for (int j = i; j < n; j++) {
				
				count[str.charAt(j) - 'A']++;
				maxFreq = Math.max(maxFreq, count[str.charAt(j) - 'A']);
				
				// Characters that need to be replaced to make
				// the entire substring the same character.
				int replacements = j - i + 1 - maxFreq;
				
				if (replacements <= k) {
					maxLen = Math.max(maxLen, j - i + 1);
				}
				else {
					break;
				}
			}
		}
		
		return maxLen;
	}
	
	
	/*
	 * APPROACH: Optimal (Sliding Window)
	 *
	 * Maintain a window using two pointers. Expand the window
	 * using the right pointer and track the frequency of the
	 * most frequent character.
	 *
	 * If the number of replacements needed exceeds k, shrink
	 * the window from the left until it becomes valid again.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public static int characterReplacementOptimal(String str, int k) {
		
		int n = str.length();
		if (str == null || n == 0) {
			return 0;
			
		}
		
		if (n == 1) {
			return 1;
		}
		
		int left = 0;
		int maxFreq = 0;
		int maxLen = 0;
		int[] count = new int[26];
		
		// Expand the window using the right pointer.
		for (int right = 0; right < str.length(); right++) {
			
			count[str.charAt(right) - 'A']++;
			
			maxFreq = Math.max(
				maxFreq,
				count[str.charAt(right) - 'A']
			);
			
			// Shrink the window if more than k replacements
			// are required to make all characters the same.
			while ((right - left + 1) - maxFreq > k) {
				count[str.charAt(left) - 'A']--;
				left++;
			}
			
			// Update the maximum valid window length.
			maxLen = Math.max(maxLen, right - left + 1);
		}
		
		return maxLen;
	}
	
	
	public static void main(String[] args) {
		
		String s = "AABABBA";
		int k = 1;
		
		System.out.println("\n--- Brute Force ---");
		System.out.println("Time Complexity: O(n^2)");
		System.out.println("Space Complexity: O(1)");
		System.out.println(characterReplacementBrute(s, k));
		
		System.out.println("\n--- Sliding Window ---");
		System.out.println("Time Complexity: O(n)");
		System.out.println("Space Complexity: O(1)");
		System.out.println(characterReplacementOptimal(s, k));
	}
}
