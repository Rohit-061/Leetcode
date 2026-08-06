class Solution {
    int n;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,0,-1,dp);
    }
    public int solve(int[] nums,int i,int prev,int[][] dp){
        if(i==n) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int pick=0;
        if((prev == -1) || nums[i]>nums[prev]){
            pick = 1 + solve(nums,i+1,i,dp);
        }
        int nopick = solve(nums,i+1,prev,dp);
        dp[i][prev+1] = Math.max(pick,nopick);
        return dp[i][prev+1];

    }
}