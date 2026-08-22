/*
 * Given two strings s and t, return true if t is an anagram of s,
 * and false otherwise.
 */

package arrays;

public class ValidAnagram {

    /*
     * APPROACH: Character Frequency Counting
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * - The array always has 26 elements.
     */
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        // Create an array of size 26 for all lowercase alphabets.
        // Each position is initially 0.
        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {.

            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }


        for (int count : charCount) {        // ":" means "for each element in charCount".

            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
