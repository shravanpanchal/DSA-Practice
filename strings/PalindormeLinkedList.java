

/*
 * LeetCode 647 - Palindromic Substrings
 *
 * Problem:
 * Given a string s, return the total number of palindromic substrings.
 *
 * Every substring is counted separately, even if multiple
 * substrings have the same characters but different positions.
 *
 * Example:
 * Input:  s = "aaa"
 * Output: 6
 *
 * Palindromic substrings:
 * "a", "a", "a", "aa", "aa", "aaa"
 *
 * Approaches:
 * 1. Brute Force - O(n^3)
 * 2. Expand Around Center - O(n^2)
 */

package strings;


public class PalindormeLinkedList {

    // =====================================================
    // APPROACH 1: BRUTE FORCE
    // Time Complexity: O(n^3)
    // Auxiliary Space: O(1)
    // =====================================================

    public int countSubstringBrute(String str) {

        int n = str.length();
        int ans = 0;

        // Generate all possible substrings
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                // Check whether substring is palindrome
                if (isPalindrome(str, i, j)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // Check whether a substring is palindrome
    private boolean isPalindrome(String str, int left, int right) {

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    // =====================================================
    // APPROACH 2: OPTIMAL - EXPAND AROUND CENTER
    // Time Complexity: O(n^2)
    // Auxiliary Space: O(1)
    // =====================================================

    public int countSubstringOptimal(String str) {

        int n = str.length();
        int count = 0;

        for (int i = 0; i < n; i++) {

            // Case 1: Odd-length palindrome
            // Example: "aba"
            count += countPalindrome(str, i, i);

            // Case 2: Even-length palindrome
            // Example: "abba"
            count += countPalindrome(str, i, i + 1);
        }

        return count;
    }


    // Expand outward from the given center
    private int countPalindrome(String str, int left, int right) {

        int count = 0;

        while (left >= 0 &&
               right < str.length() &&
               str.charAt(left) == str.charAt(right)) {

            // Found a palindrome
            count++;

            // Expand outward from center
            left--;
            right++;
        }

        return count;
    }



    public static void main(String[] args) {

        PalindormeLinkedList obj = new PalindormeLinkedList();

        String str = "aaa";

        // Brute Force
        int bruteResult = obj.countSubstringBrute(str);

        // Optimal
        int optimalResult = obj.countSubstringOptimal(str);

        System.out.println("Input: " + str);

        System.out.println("Brute Force Result: " + bruteResult);

        System.out.println("Optimal Result: " + optimalResult);
    }
}
