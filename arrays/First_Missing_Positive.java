package arrays;

import java.util.HashSet;

public class First_Missing_Positive {

	public static int firstMissingPositiveBrute(int[] array) {
		int missingpositive = 1;
		while(missingpositive <= array.length) {
			boolean found = false;
			
			for (int i = 0; i < array.length; i++) {
				
					if (array[i] == missingpositive) {
						found = true;
						break;
					}
				}
			if (!found) {
				return missingpositive;
			}
			missingpositive++;

			}
		return missingpositive;
		
	}
	
	
	public static int firstMissingPositiveHash(int[] array) {
		
		HashSet<Integer> set = new HashSet<>();
		
		for (int num : array) {
			set.add(num);
		}
		
		for (int i = 1; i <= array.length; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return array.length+1;
		
	}
	
	public static int firstMissingPositiveOptimal(int[] array) {
		for (int i = 0; i < array.length; i++) {
			while (array[i] > 0 && array[i] <= array.length && array[array[i] - 1] != array[i]) {
	            int correctIndex = array[i] - 1;

				int temp = array[i];
				array[i] = array[correctIndex];
				array[correctIndex] = temp;
			}
			
		}
	
			for (int i = 0; i < array.length; i++) {
			if (array[i] != i + 1) {
				return i + 1;
			}
			
		}

		return array.length + 1;
		
	}
	
	public static void main(String[] args) {
		int[] nums = {5, 1, -1, 2, 6,5,3};
		System.out.println("Brute Froce Approach");
		System.out.println("Space Complexity : O(1), Time Complexity : O(n^2)");
		System.out.println(firstMissingPositiveBrute(nums));

		System.out.println("Hashing Approach");
		System.out.println("Space Complexity : O(n), Time Complexity : O(n)");
		System.out.println(firstMissingPositiveHash(nums));

		System.out.println("Optimal Approach");
		System.out.println("Space Complexity : O(1), Time Complexity : O(n)");
		System.out.println(firstMissingPositiveOptimal(nums));
		

	}
}
