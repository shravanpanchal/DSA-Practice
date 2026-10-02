/*
 * Problem: Valid Palindrome
 *
 * Given a string, determine whether it is a palindrome after:
 * 1. Converting all uppercase letters to lowercase.
 * 2. Removing all non-alphanumeric characters.
 *
 * A palindrome reads the same forward and backward.
 *
 * Example:
 * Input  : "A man, a plan, a canal: Panama"
 * Output : true
 *
 * Approach:
 * Use two pointers, one starting from the beginning and the
 * other from the end, and compare valid alphanumeric characters.
 */


package twoPointers;

public class ValidPalindrome {

	public static boolean isValid(String s) {
		int left = 0;
		int right = s.length() - 1;
		
		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}
			
			if (Character.toLowerCase(s.charAt(right)) != Character.toLowerCase(s.charAt(left))) {
				return false;
			}
			left++;
			right--;
			
		}
		
		return true;
		
	}
	
	
	public static void main(String[] args) {
		
		String string = "A man, a plan, a canal: Panama";
		
		System.out.print(isValid(string));
		
	}
}
