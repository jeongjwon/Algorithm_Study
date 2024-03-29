
public class Leetcode_121_BestTimeToBuyAndSellStock {
	public static int maxProfit(int[] prices) {
    	//o(n^2) --> time limit
    	int max = 0;
    	for(int i = 0 ; i <prices.length; i++) {
    		for(int j = i-1 ; j >= 0 ; j--) {
    			max = Math.max(max, prices[i]-prices[j]);
    		}
    	}
    	return max;
    }
    public static int maxProfit_DP(int[] prices) {
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	
    	for(int p : prices) {
    		min = Math.min(p, min);
    		//진행하면서 작은 값을 탖고
    		max = Math.max(max, p-min);
    		//도출해야하는 값은 수익의 max
    	}

    	return max;
    }
}
