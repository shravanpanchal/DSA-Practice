/*
 * Best Time to Buy and Sell Stock - 121
 *
 * You are given an array prices where prices[i] is the price 
 * of a given stock on the ith day. Return the maximum profit 
 * you can achieve from this transaction.
 */

package slidingWindow;

public class BestTimeToBuyAndSellStocks {
	
	/*
	 * APPROACH: Brute Force
	 *
	 * Try every possible pair of buy and sell days 
	 * and find the maximum profit.
	 *
	 * Time Complexity: O(n^2)
	 * Space Complexity: O(1)
	 */
	public static int maxProfitBrute(int[] array) {
		int profit = 0;
		
		// Check every pair of days for possible profit.
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				profit = Math.max(profit, array[j] - array[i]);
			}
		}
		return profit;
	}
	
	/*
	 * APPROACH: Optimal (Single Pass)
	 *
	 * Track the minimum price seen so far and calculate 
	 * the profit at each step, updating the maximum profit.
	 *
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public static int maxProfitOptimal(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		
		int min = array[0];
		int profit = 0;
		
		// Iterate through the array to find the min price and max profit.
		for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
			profit = Math.max(profit, array[i] - min);
		}
		return profit;
	}
	
	public static void main(String[] args) {
		int[] array = {22, 58, 23, 21, 55, 13, 98, 67, 1};
		
		System.out.println("Brute Force");
		System.out.println("Time Complexity: O(n^2)");
		System.out.println("Space Complexity: O(1)");
		System.out.println(maxProfitBrute(array));

		System.out.println("\nOptimal");
		System.out.println("Time Complexity: O(n)");
		System.out.println("Space Complexity: O(1)");
		System.out.println(maxProfitOptimal(array));
	}
}