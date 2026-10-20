package strings;
/*
 * LeetCode Problem: 14. Longest Common Prefix
 * Difficulty: Easy
 * Topic: String, Trie
 *
 * Problem Statement:
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example:
 * Input:  ["flower", "flow", "flight"]
 * Output: "fl"

 * Approach 1: Horizontal Scanning
 * Time Complexity: O(n * m)
 *
 * Approach 2: Vertical Scanning
 * Time Complexity: O(n * m)
 *
 * n = Number of strings
 * m = Length of the shortest string
 */

public class LongestCommonPrefix {

    // Approach 1: Horizontal Scanning
    // Compare strings one by one and reduce the prefix
    // until it matches the beginning of each string.
    // Time Complexity: O(n * m)

    public static String prefix(String[] list) {

        int n = list.length;
        String prefix = list[0];

        for (int i = 1; i < n; i++) {

            while (list[i].indexOf(prefix) != 0) {

                // Remove the last character from the prefix
                prefix = prefix.substring(0, prefix.length() - 1);

                // Return an empty string if no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    // Approach 2: Vertical Scanning
    // Compare characters at the same index across all strings.
    // Return the prefix when a mismatch or end of a string is found.
    // Time Complexity: O(n * m)

    public static String prefix2(String[] list) {

        // Handle null or empty arrays
        if (list == null || list.length == 0) {
            return "";
        }

        int n = list.length;

        // Iterate through each character of the first string
        for (int i = 0; i < list[0].length(); i++) {

            // Compare the current character with other strings
            for (int j = 1; j < n; j++) {

                // Check if the string ends or characters mismatch
                if (i >= list[j].length()
                        || list[0].charAt(i) != list[j].charAt(i)) {

                    // Return characters before the mismatch
                    return list[0].substring(0, i);
                }
            }
        }

        // All characters matched
        return list[0];
    }

    public static void main(String[] args) {

        String[] words = {"flower", "flow", "flight"};

        System.out.println("Horizontal Scanning: " + prefix(words));
        System.out.println("Time Complexity: O(n * m)");

        System.out.println("Vertical Scanning: " + prefix2(words));
        System.out.println("Time Complexity: O(n * m)");
    }
}