class Solution {
    public int maxProfit(int[] prices) {
        int curr = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int n : prices){
            if(n<curr){
                curr = n;
            }else{
                maxprofit = Math.max(maxprofit , n-curr);
            }
        }
        return maxprofit;
    }
}