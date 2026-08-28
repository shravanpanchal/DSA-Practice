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
    // APPROACH 2: SORTING-BASED APPROACH - BETTER APPROACH
    // Time: O(n * k log k)
    // Space: O(n * k)
    // ============================================================
    public List<List<String>> groupAnagramSorting(String[] str){
    	HashMap<String, List<String>> map = new HashMap<>();
    	
    	for (String s : str) {
    		char[] chars = s.toCharArray();
    		Arrays.sort(chars);
    		
    		String key = new String(chars);
    		
    		map.putIfAbsent(key, new ArrayList<>());
    		map.get(key).add(s);
    	}
    	return new ArrayList<>(map.values());
    }

    
    // ============================================================
    // APPROACH 3: HASHMAP KEY-BASED APPROACH
    // Strings with same key in same group
    //
    // Time: O(n * k)
    // Space: O(n * k)
    // ============================================================
    
    public List<List<String>> groupAnagramHashKey(String[] str){
    	HashMap<String, List<String>> map = new HashMap<>();
    	for (String s : str) {
    		int[] count = new int[26];
    		
    		for (int j = 0; j < s.length(); j++) {
    			count[s.charAt(j) - 'a']++;
    		}
    		String key = Arrays.toString(count);
    		map.putIfAbsent(key, new ArrayList<>());
    		map.get(key).add(s);
    	}
    	return new ArrayList<>(map.values());

    }
    
    
    public static void main(String[] args) {

        String[] strs = {
            "eat", "tea", "tan", "ate", "nat", "bat"
        };

        GroupAnagram obj = new GroupAnagram();

        System.out.println("Brute Force Approach\nTime: O(n^2 * k)\nSpace: O(n)\n" + obj.groupAnagramSorting(strs));
        
        System.out.println("\nSorting Approach\nTime: O(n * k log k)\nSpace: O(n * k)\n" + obj.groupAnagramSorting(strs));
                
        System.out.println("\nSorting Approach\nTime: O(n * k)\nSpace: O(n * k)\n" + obj.groupAnagramHashKey(strs));



    }
}
