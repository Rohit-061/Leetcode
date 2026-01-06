class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans = solve(coins,amount,n-1,dp);
        if(ans==(int)(1e9)) return -1;
        else return ans;
         
    }
    public int solve(int[] coins, int amount, int index,int[][] dp){
        if(index == 0){
            if(amount % coins[index]==0){
                dp[index][amount] = amount / coins[index];
                return amount / coins[index];
            }else{
                dp[index][amount] = (int)(1e9);
                return (int)(1e9) ;
            }
        }
        if(dp[index][amount]!=-1) return dp[index][amount];
        int pick = (int)(1e9);
        if(amount>=coins[index]){
            pick = 1 + solve(coins,amount-coins[index],index,dp);
        }
        int nopick = solve(coins,amount,index-1,dp);
        dp[index][amount]= Math.min(pick,nopick);
        return dp[index][amount];
    }
}