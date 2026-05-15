class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp,-1);
        int ans = Math.min(solve(cost,0,dp),solve(cost,1,dp));
        return ans;
    }
    public int solve(int[] cost,int index, int[] dp){
        int n = cost.length;
        if(index>n) return 0;
        if(index==n-2 || index==n-1) return cost[index];
        if(dp[index]!=-1) return dp[index];
        int onestep = solve(cost,index+1,dp);
        int twostep = solve(cost,index+2,dp);
        dp[index] = cost[index] + Math.min(onestep,twostep);
        return dp[index];
    }
}