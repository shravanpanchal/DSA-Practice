/*
- Problem: Fizz Buzz (LeetCode 412)
 *
- Given an integer n, return a string array answer (1-indexed) where:
- - answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
- - answer[i] == "Fizz" if i is divisible by 3.
- - answer[i] == "Buzz" if i is divisible by 5.
- - answer[i] == i (as a string) if none of the above conditions are true.
 *
- Example:
- Input  : n = 15
- Output : [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]
 */


package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FizzBuzz {

	// Approach 1: Standard If-Else chain
	public static ArrayList<String> fizzBuzz(int n) {
		ArrayList<String> result = new ArrayList<>(n);
		
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				result.add("FizzBuzz");
			}
			else if (i % 5 == 0) {
				result.add("Buzz");
			}
			else if (i % 3 == 0) {
				result.add("Fizz");
			}
			else {
				result.add(String.valueOf(i));
			}
		}
		return result;
	}
	
	// Approach 2: StringBuilder concatenation approach
	public static ArrayList<String> fizzBuzz2(int n) {
		ArrayList<String> result = new ArrayList<>(n);
		
		for (int i = 1; i <= n; i++) {
			StringBuilder sb = new StringBuilder();
			
			if (i % 3 == 0) sb.append("Fizz");
			if (i % 5 == 0) sb.append("Buzz");
			
			if (sb.length() == 0) {
				sb.append(i);
			}
			
			result.add(sb.toString());
		}
		return result;
	}
	
	// Approach 3: Java Streams functional approach
	public static List<String> fizzBuzz3(int n) {
	    return IntStream.rangeClosed(1, n)
	    		.mapToObj(i -> i % 15 == 0 ? "FizzBuzz" :
	    					i % 5 == 0 ? "Buzz" :
	    					i % 3 == 0 ? "Fizz" :
	    					String.valueOf(i))
	    		.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		int n = 15;
		
		System.out.println("Input  : n = " + n);
		System.out.println("Output 1 (If-Else)      : " + fizzBuzz(n));
		System.out.println("Output 2 (StringBuilder): " + fizzBuzz2(n));
		System.out.println("Output 3 (Streams)      : " + fizzBuzz3(n));
	}
}