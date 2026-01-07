class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,1,prices,dp);

    }
    public int solve(int i, int flag,int[] prices,int[][] dp){
        int n = prices.length;
        if(i>=n) return 0;
        if(dp[i][flag]!=-1) return dp[i][flag];
        int Profit=0;
        if(flag==1){
            int buy=-prices[i] + solve(i+1,0,prices,dp);
            int skip = 0 + solve(i+1,1,prices,dp);
            Profit= Math.max(buy,skip);
        }else{
            int sell=prices[i] + solve(i+1,1,prices,dp);
            int skip2 = 0+solve(i+1,0,prices,dp);
            Profit=Math.max(sell,skip2);
        }
        dp[i][flag] = Profit;
        return dp[i][flag];
    }
}