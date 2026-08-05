class Solution {
    int n;
    public int rob(int[] nums) {
        n = nums.length;
        int[]dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);
        
    }
    public int solve(int[] nums,int index,int[] dp){
        if(index>=n) return 0;
        if(index == n-1) return nums[index];
        if(dp[index]!=-1) return dp[index];
        int step = nums[index] + solve(nums,index+2,dp);
        int skip = solve(nums,index+1,dp);
        dp[index] = Math.max(step,skip);
        return dp[index];
    }
}