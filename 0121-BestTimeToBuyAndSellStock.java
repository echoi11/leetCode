class Solution {
    //[7,1,5,3,6,4]
    //[7,6,4,3,1]
    //[]
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int result = 0;
        int minPrice = prices[0];
        int profit = 0;
        
        for(int i=1; i< prices.length; i++) {
            profit = prices[i] - minPrice;
            minPrice = Math.min(minPrice, prices[i]);
            result = Math.max(profit, result);
        }
        return result;
    }
}
