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
 */

package arrays;
import java.util.List;
import java.util.ArrayList;

public class GroupAnagram {

	// BruteForce 
	public List<List<String>> groupAnagramBruteForce(String[] strs){
		
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
				if (visited[j] == 1 || strs[i].length()!=strs[j].length()) {
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
				
				if (isAnagram){
					group.add(strs[j]);
					visited[j] = 1;
				}
				
				
				
			
		}
			result.add(group);
		}
		
		return result;
		
		
	}
	
	public List<List<String>> GroupAnagramB2(String[] str){
		
		boolean[] visited = new boolean[str.length];
		List<List<String>> result = new ArrayList<>();
		
		for (int i = 0; i < str.length; i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			List<String> group = new ArrayList<>();

			group.add(str[i]);

			for (int j = i + 1; j < str.length; j++) {
				if (visited[j] || str[i].length() != str[j].length()) {
					continue;
				}
				
				int[] count = new int[26];
				for (int k = 0; k < str[j].length(); k++) {
					count[str[j].charAt(k) - 'a']++;
					count[str[i].charAt(k) - 'a']--;
				}
				
				boolean isAnagram = true;
				for (int k = 0; k < 26; k++) {
					if (count[k] != 0) {
						isAnagram = false;
					}
				
				}
				if (isAnagram){
					group.add(str[j]);
					visited[j] = true;
				}
			}
			result.add(group);
			
			
		}
		return result;
		
	}
	public static void main(String args[]) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		GroupAnagram obj = new GroupAnagram();
		 System.out.println(obj.GroupAnagramB2(strs));
	}
}