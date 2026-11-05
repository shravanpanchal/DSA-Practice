
package strings;

/*
 * LeetCode Problem: 5. Longest Palindromic Substring
 * Difficulty: Medium
 * Topic: String, Two Pointers, Dynamic Programming
 *
 * Problem Statement:
 * Given a string s, return the longest palindromic substring in s.
 *
 * A palindrome is a string that reads the same forward and backward.
 *
 * Example 1:
 * Input:  "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input:  "cbbd"
 * Output: "bb"
 *
 * Approach 1: Expand Around Center
 * Time Complexity: O(n²)
 * Space Complexity: O(1)
 *
 * n = Length of the input string
 */

public class LongestPalindromicSubstring {

    // Approach 1: Expand Around Center
    // Consider every character and every gap between characters
    // as a possible center of a palindrome.
    //
    // Two cases:
    // 1. Odd length palindrome: left = i, right = i
    // 2. Even length palindrome: left = i, right = i + 1
    //
    // Expand in both directions while characters match.
    // Update the longest palindrome whenever a longer one is found.
    //
    // Time Complexity: O(n²)
    // Space Complexity: O(1)

    public static String longestPalindrome(String str) {

        // Handle null or empty strings
        if (str == null || str.isEmpty()) {
            return "";
        }

        int n = str.length();

        int maxCount = 0;
        String palindrome = "";

        // Consider every index as a possible palindrome center
        for (int i = 0; i < n; i++) {

            int count;

            // Case 1: Odd length palindrome
            // Both pointers start at the same index
            int left = i;
            int right = i;

            // Expand around the center while characters match
            while (left >= 0 && right < n
                    && str.charAt(right) == str.charAt(left)) {

                right++;
                left--;
            }

            // Calculate palindrome length
            // Pointers move one position outside the palindrome
            count = right - left - 1;

            // Update the longest palindrome
            if (count > maxCount) {

                palindrome = str.substring(left + 1, right);
                maxCount = count;
            }

            // Case 2: Even length palindrome
            // Pointers start at two adjacent indices
            left = i;
            right = i + 1;

            // Expand around the center while characters match
            while (left >= 0 && right < n
                    && str.charAt(right) == str.charAt(left)) {

                right++;
                left--;
            }

            // Calculate palindrome length
            count = right - left - 1;

            // Update the longest palindrome
            if (count > maxCount) {

                palindrome = str.substring(left + 1, right);
                maxCount = count;
            }
        }

        return palindrome;
    }

    public static void main(String[] args) {

        String str1 = "babad";
        String str2 = "cbbd";
        String str3 = "racecar";

        System.out.println("Input: " + str1);
        System.out.println("Longest Palindrome: " + longestPalindrome(str1));

        System.out.println();

        System.out.println("Input: " + str2);
        System.out.println("Longest Palindrome: " + longestPalindrome(str2));

        System.out.println();

        System.out.println("Input: " + str3);
        System.out.println("Longest Palindrome: " + longestPalindrome(str3));

        System.out.println();

        System.out.println("Time Complexity: O(n²)");
        System.out.println("Space Complexity: O(1)");
    }
}
