
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
 * Approach 1: Brute Force
 * Time Complexity: O(n³)
 * Space Complexity: O(1) Auxiliary Space
 *
 * Approach 2: Expand Around Center
 * Time Complexity: O(n²)
 * Space Complexity: O(1) Auxiliary Space
 *
 * n = Length of the input string
 */

public class LongestPalindromicSubstring {

    // --------------------------------------------------
    // Approach 1: Brute Force
    // --------------------------------------------------
    //
    // Generate every possible substring and check
    // whether it is a palindrome.
    //
    // Time Complexity: O(n³)
    // Space Complexity: O(1) Auxiliary Space
    //

    public static String longestPalindromeBrute(String str) {

        // Handle null or empty strings
        if (str == null || str.isEmpty()) {
            return "";
        }

        int n = str.length();

        int maxCount = 0;
        String palindrome = "";

        // Generate all possible substrings
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                // Check whether the current substring is palindrome
                if (isPalindrome(str, i, j)) {

                    int length = j - i + 1;

                    // Update the longest palindrome
                    if (length > maxCount) {

                        maxCount = length;
                        palindrome = str.substring(i, j + 1);
                    }
                }
            }
        }

        return palindrome;
    }

    // Helper method to check whether a substring is palindrome
    private static boolean isPalindrome(String str, int left, int right) {

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // --------------------------------------------------
    // Approach 2: Expand Around Center
    // --------------------------------------------------
    //
    // Consider every character and every gap between
    // characters as a possible center of a palindrome.
    //
    // Two cases:
    // 1. Odd length palindrome: left = i, right = i
    // 2. Even length palindrome: left = i, right = i + 1
    //
    // Expand in both directions while characters match.
    //
    // Time Complexity: O(n²)
    // Space Complexity: O(1) Auxiliary Space
    //

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

            // ------------------------------------------
            // Case 1: Odd Length Palindrome
            // ------------------------------------------
            //
            // Both pointers start at the same index.
            // Example: "racecar"
            //

            int left = i;
            int right = i;

            // Expand around the center while characters match
            while (left >= 0 && right < n
                    && str.charAt(left) == str.charAt(right)) {

                left--;
                right++;
            }

            // Calculate palindrome length
            // Pointers are now one position outside the palindrome
            count = right - left - 1;

            // Update the longest palindrome
            if (count > maxCount) {

                palindrome = str.substring(left + 1, right);
                maxCount = count;
            }

            // ------------------------------------------
            // Case 2: Even Length Palindrome
            // ------------------------------------------
            //
            // Pointers start at two adjacent indices.
            // Example: "abba"
            //

            left = i;
            right = i + 1;

            // Expand around the center while characters match
            while (left >= 0 && right < n
                    && str.charAt(left) == str.charAt(right)) {

                left--;
                right++;
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

    // --------------------------------------------------
    // Main Method
    // --------------------------------------------------

    public static void main(String[] args) {

        String[] inputs = {
            "babad",
            "cbbd",
            "racecar",
            "abba",
            "a",
            ""
        };

        for (String str : inputs) {

            System.out.println("Input: " + str);
            System.out.println("Brute Force: " + longestPalindromeBrute(str));
            System.out.println("Expand Around Center: " + longestPalindrome(str));
            System.out.println();
        }
    }
    
}
