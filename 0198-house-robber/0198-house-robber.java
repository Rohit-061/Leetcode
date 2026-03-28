class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(nums,dp,0);

    }
    public int solve(int[] nums, int[] dp,int index){
        int n=nums.length;
        if(index>=n) return 0;
        if(index==n-1) return nums[index];
        if(dp[index]!=-1) return dp[index];
        int step =  nums[index]+solve(nums,dp,index+2);
        int skip = solve(nums,dp,index+1);
        dp[index] =Math.max(step,skip);
        return dp[index];
    
    }
}