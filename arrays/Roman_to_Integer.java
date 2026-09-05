/*
LeetCode #13 - Roman to Integer

Given a roman numeral, convert it to an integer.

Roman numerals are represented by seven different symbols:

I = 1
V = 5
X = 10
L = 50
C = 100
D = 500
M = 1000

Roman numerals are usually written from largest to smallest.
However, when a smaller value appears before a larger value,
the smaller value is subtracted.

Examples:
IV = 4
IX = 9
XL = 40
XC = 90
CD = 400
CM = 900

Example 1:
Input:  s = "III"
Output: 3

Example 2:
Input:  s = "LVIII"
Output: 58

Example 3:
Input:  s = "MCMXCIV"
Output: 1994

Constraints:
1 <= s.length <= 15
s contains only I, V, X, L, C, D, M.
s is a valid Roman numeral in the range [1, 3999].
*/




package arrays;

import java.util.HashMap;
import java.util.Map;

public class Roman_to_Integer {
	/*
	 * Brute Force approach
	 * -Straight Forward approach, Processes each sub-string as a Roman number 
	 * -Slow due to char to string conversion and larger memory over head due to larger map.
	 *
	 * Time:
     * O(n)
     *
     * Space:
     * O(1)
	 */
	public static int romanToIntBrute(String str){
		int n = str.length();
		Map<String, Integer> Roman = new HashMap<>(Map.ofEntries(
			    Map.entry("I", 1),
			    Map.entry("V", 5),
			    Map.entry("X", 10),
			    Map.entry("L", 50),
			    Map.entry("C", 100),
			    Map.entry("D", 500),
			    Map.entry("M", 1000),
			    Map.entry("IV", 4),
			    Map.entry("IX", 9),
			    Map.entry("XL", 40),
			    Map.entry("XC", 90),
			    Map.entry("CD", 400),
			    Map.entry("CM", 900)
			));

		int value = 0;
		if (n == 1) {		
		    return Roman.get(str);
		}
		for (int i = 0; i < n; i++) {

			if (i + 1 < n && Roman.containsKey(str.substring(i, i+2))) {
				value += Roman.get(str.substring(i, i+2));
				i++;

			}
			else {
				value += Roman.get(String.valueOf(str.charAt(i)));

			}
		}
		return value;
		
	}
	
	/*
	 * HashMap approach
	 * -Optimized approach, uses a HashMap for single-character lookups.
	 * -Handles subtractive notation by comparing the current character value with the next character.
	 *
	 * Time:
     * O(n)
     *
     * Space:
     * O(1)
	 */
	
	public static int romanToIntHashMap(String str) {
		HashMap<Character, Integer> Roman = new HashMap<>(Map.ofEntries(
			    Map.entry('I', 1),
			    Map.entry('V', 5),
			    Map.entry('X', 10),
			    Map.entry('L', 50),
			    Map.entry('C', 100),
			    Map.entry('D', 500),
			    Map.entry('M', 1000)));
	
		int value = 0;
	
		for (int i = 0; i < str.length(); i++) {
			int current = Roman.get(str.charAt(i));
			if (i + 1 < str.length() && current < Roman.get(str.charAt(i + 1))) {
				value -= current;
				
				}
			else {
				value += current;
				
				}
			}
		return value;
	}
	/*
	 * Switch Case approach
	 * -Most optimal approach, replaces the HashMap with a switch-case helper method.
	 * -Eliminates map allocation overhead, making it faster and more memory-efficient.
	 *
	 * Time:
     * O(n)
     *
     * Space:
     * O(1)
	 */
	 
	public static int romanToIntSwitchCase(String str) {
		int value = 0;

		for(int i = 0; i < str.length(); i++) {
			int current = value(str.charAt(i));
			if (i+1 < str.length() && current < value(str.charAt(i + 1))) {
				value -= current;
			}
			else {
				value += current;
			}
		}
		return value;
		
	}

	private static int value(char c) {
		 return switch(c) {
			case 'I' -> 1;
			case 'V' -> 5;
			case 'X' -> 10;
			case 'L' -> 50;
			case 'C' -> 100;
			case 'D' -> 500;
			case 'M' -> 1000;
			default -> 0;
			};
		 
	}
	
	public static void main(String[] args) {
String Str = "MCMXCIV";
		
		// Approach 1: HashMap with Substrings
		int val1 = romanToIntBrute(Str);
		System.out.println("BruteForce Approach : " + val1);
		
		// Approach 2: HashMap with Character Values
		int val2 = romanToIntHashMap(Str);
		System.out.println("HashMap Approach : " + val2);
		
		// Approach 3: Switch Case
		int val3 = romanToIntSwitchCase(Str);
		System.out.println("SwitchCase Approach : " + val3);

	}
	
}

