/*
 * GROUP ANAGRAMS - 49
 *
 * Given an array of strings strs, group the anagrams together.
 *
 * Anagrams are strings that contain the same characters
 * with the same frequencies, but can be in different order.
 *
 * Example:
 * strs = {"eat", "tea", "tan", "ate", "nat", "bat"}
 *
 * Output:
 * [["eat", "tea", "ate"],
 *  ["tan", "nat"],
 *  ["bat"]]
 *
 *
 * APPROACHES:
 *
 * 1. Brute Force Approach
 *    Time Complexity: O(n^2 * k)
 *    Space Complexity: O(n) excluding output
 *
 * 2. Sorting-Based Approach
 *    Time Complexity: O(n * k log k)
 *    Space Complexity: O(n * k) including keys/output
 *
 * 3. HashMap Key-Based Approach
 *    Time Complexity: O(n * k)
 *    Space Complexity: O(n * k) including keys/output
 */

package arrays;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class GroupAnagram {

    // ============================================================
    // APPROACH 1: BRUTE FORCE
    // Time: O(n^2 * k)
    // Space: O(n) excluding output
    // ============================================================

    public List<List<String>> groupAnagramBruteForce(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        int[] visited = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {

            if (visited[i] == 1) {
                continue;
            }

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = 1;

            for (int j = i + 1; j < strs.length; j++) {

                if (visited[j] == 1 ||
                    strs[i].length() != strs[j].length()) {
                    continue;
                }

                int[] count = new int[26];

                for (int k = 0; k < strs[i].length(); k++) {
                    count[strs[i].charAt(k) - 'a']++;
                    count[strs[j].charAt(k) - 'a']--;
                }

                boolean isAnagram = true;

                for (int k = 0; k < 26; k++) {

                    if (count[k] != 0) {
                        isAnagram = false;
                        break;
                    }
                }

                if (isAnagram) {
                    group.add(strs[j]);
                    visited[j] = 1;
                }
            }

            result.add(group);
        }

        return result;
    }



    // ============================================================
    // APPROACH 3: SORTING-BASED APPROACH - BETTER APPROACH
    // Time: O(n * k log k)
    // Space: O(n * k)
    // ============================================================
    public List<List<String>> groupAnagramSorting(String str){
    	List<List<String>> result = new ArrayList<>();
    	HashMap<String, List<String>> map = new HashMap<>();
    	for (int i = 0 ; i < str.length(); i++) {
    		
    		
    	}
    }

    // ============================================================
    // APPROACH 4: HASHMAP KEY-BASED APPROACH
    // All three have the same key, so they go into the same group.
    //
    // Time: O(n * k)
    // Space: O(n * k)
    // ============================================================


    public static void main(String[] args) {

        String[] strs = {
            "eat", "tea", "tan", "ate", "nat", "bat"
        };

        GroupAnagram obj = new GroupAnagram();

        System.out.println(obj.groupAnagramBruteForce(strs));

    }
}
