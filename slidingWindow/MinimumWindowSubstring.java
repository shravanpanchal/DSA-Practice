package slidingWindow;
import java.util.ArrayList;
import java.util.HashMap;



public class MinimumWindowSubstring {

	public static String minWindow(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) {
			return "";
		}
		
		int maxLen = Integer.MAX_VALUE;
		String Answer = "";
		
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				String temp = s.substring(i, j + 1);

				if (isValid(temp, t)) {
					if (temp.length() < maxLen) {
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
			count[t.charAt(i) - 'A'] = count[t.charAt(i) - 'A'] + 1;
			
		}
		
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 'A'] = count[str.charAt(i) - 'A'] - 1;

		}
		
		for (int i = 0; i < count.length; i++) {
			if (count[i] > 0) {
				return false;
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		// Expected: "BANC"
		
		
		System.out.print( minWindow(s,t));
		
		
	}
}
