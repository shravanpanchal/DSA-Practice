package slidingWindow;

public class LongestSubstringCharacterReplacement {
	
	public static int characterReplacement(String str, int k) {

		int left = 0;
		int maxFreq = 0;
		int maxLen = 0;
		int[] count = new int[26];
		
		for (int right =  0; right < str.length(); right++) {
			count[str.charAt(right) - 'A']++;
			maxFreq = Math.max(maxFreq, count[str.charAt(right) - 'A']);
			
			
			while ((right - left + 1 ) - maxFreq > k) {
				count[str.charAt(left) - 'A']--;
				left++;
				
			}
			
			maxLen = Math.max(maxLen, right - left + 1);
			
		}
		return maxLen;
	}
	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 1;
		
		System.out.println(characterReplacement(s,k));
	}

}
