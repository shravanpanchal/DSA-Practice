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
}
