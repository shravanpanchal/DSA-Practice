
package strings;

import java.util.ArrayList;

/*
 * Palindromic Substrings
 *
 * Problem:
 * Given a string str, return all palindromic substrings.
 *
 * Every substring is stored separately, even if multiple
 * substrings have the same characters but different positions.
 *
 * Example:
 * Input:  str = "aba"
 *
 * Output: ["a", "aba", "b", "a"]
 *
 * Approaches:
 * 1. Expand Around Center - O(n^2)
 */

public class PalindromicSubstring {

    // APPROACH: EXPAND AROUND CENTER
    // Time Complexity: O(n^2)
    // Auxiliary Space: O(n^2)

    public String[] palindromicSubstring(String str) {

        int n = str.length();

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            // Case 1: Odd-length palindrome
            // Example: "aba"
            result.addAll(countPalindrome(str, i, i));

            // Case 2: Even-length palindrome
            // Example: "abba"
            result.addAll(countPalindrome(str, i + 1, i));
        }

        return result.toArray(new String[0]);
    }


    // =====================================================
    // EXPAND OUTWARD FROM THE GIVEN CENTER
    // =====================================================

    public ArrayList<String> countPalindrome(
            String str, int right, int left) {

        int n = str.length();

        ArrayList<String> palindromes = new ArrayList<>();

        while (left >= 0 &&
               right < n &&
               str.charAt(left) == str.charAt(right)) {

            // Found a palindrome
            palindromes.add(str.substring(left, right + 1));

            // Expand outward from center
            right++;
            left--;
        }

        return palindromes;
    }



    public static void main(String[] args) {

        PalindromicSubstring obj = new PalindromicSubstring();

        String str = "aba";

        // Expand Around Center
        String[] result = obj.palindromicSubstring(str);

        System.out.println("Input: " + str);

        System.out.println("Palindromic Substrings:");

        for (String palindrome : result) {
            System.out.println(palindrome);
        }
    }
}
