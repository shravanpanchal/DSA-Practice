package slidingWindow;

public class LongestSubarrayWithoutRepeatingCharacter {

	public static int lengthOfLongestSubString(String str) {
		
		if (str == null || str.length() == 0) {
			return 0;
		}
		int n = str.length();
		if (n == 1) {
			return 1;
			
		}
		int left = 0;
		int right = 0;
		int maxLen = 00;
		int[] count = new int[26];
		
		for (right = left; right < n; right++) {
			count[str.charAt(right) - 'A']++;
			
			while (count[str.charAt(right) - 'A']> 1) {
				count[str.charAt(left) - 'A']--;
				left++;
					
			}
			
			maxLen = Math.max(maxLen, right - left + 1);
		}
		return maxLen;
	}
}
