package slidingWindow;

public class BestTimeToBuyAndSellStocks {
	
	public static int maxProfit(int[] array) {
		int min = array[0];
		int profit = 0;
		
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
		
		System.out.println(maxProfit(array));
	}
}
