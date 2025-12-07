class Solution {
    public int climbStairs(int n) {
        // base case
        //if(n<=2) return n;
        // return climbStairs(n-1)+ climbStairs(n-2); // tc=2^n
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return recur(n,dp);

    }
    public int recur(int n, int dp[]){
        // base case
        if(n<=2) {
            dp[n]=n;
            return n;
        }
        if(dp[n]!=-1) return dp[n];
        dp[n]=recur(n-1,dp) + recur(n-2,dp);
        return dp[n];
    }
}