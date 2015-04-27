// Jan 25, 2015
// Reviewed: Feb 1, 2015

/**
 * Say you have an array for which the ith element is the price 
 * of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an 
 * algorithm to find the maximum profit.
 */

public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		
		// Time Complexity: O(N)
		// Space Complexity: O(1)
		
		// Incorrect! max cannot be prices[0] because it could be the largest. 
		// If the first elem is the largest, the stock cannot be sold at higher 
		// prices later. The max will not be changed. But the 1st elem could be min.
        if(prices == null || prices.length <= 1) return 0;
        int maxProfit = prices[0];
        int min = 0;
        
        for(int i=0;i<prices.length;i++){
        	if(prices[i] < prices[min]) min = i;
        	int profit = prices[i] - prices[min];
        	if(profit > maxProfit) maxProfit = profit;
        	System.out.println("maxProfit = " + maxProfit);
        }        
        return maxProfit;
    }
	
	 public int maxProfit2(int[] prices) {
		
			// Time Complexity: O(N)
			// Space Complexity: O(1)
			
//	        int min = Integer.MAX_VALUE;
		 	int min = prices[0];
	        int max=0;
	        
	        for(int i=0;i<prices.length;i++){
	            max=Math.max(max,prices[i]-min);
	            min=Math.min(min,prices[i]);
	        }
	        return max;
	    }
	
	public static void main(String[] args) {
		
		// 1. Null or empty string
		// 2. {1,1,1}
		// 3. {1}
		// 4. {1,2,1,3,5}
		// 5. {1,2,3}
		// 6. {3,2,1}
		
		BestTimeToBuyAndSellStock test = new BestTimeToBuyAndSellStock();
		int[] prices = {1,1,1};
		System.out.println(test.maxProfit(prices));
		System.out.println(test.maxProfit2(prices));

	}
}
