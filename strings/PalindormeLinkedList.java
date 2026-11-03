package strings;

public class PalindormeLinkedList {

	public int countSubstirngBrute(String str) {
		
		int n = str.length();
		int ans = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				
				if (isPalindorme(str, i, j)) {
					ans++;
					
				}
			}
		}
		return ans;
	}
	
	private boolean isPalindorme(String str, int left, int right) {
		
		while(left < right) {
			if (str.charAt(right) == str.charAt(left)) {
				left++;
				right--;
			}
			else {
				return false;
			}
		}
		return true;
		
	}
	
	
}
