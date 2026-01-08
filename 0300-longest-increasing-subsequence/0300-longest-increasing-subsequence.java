class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int [n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(nums,0,-1,dp);
    }
    public int solve(int[] nums,int index,int prev,int[][] dp){
        int n = nums.length;
        if(index==n) return 0;
        if(dp[index][prev+1]!=-1) return dp[index][prev+1];
        int pick =0;
        if(prev ==-1 || nums[index]>nums[prev]){
            pick= 1 + solve(nums,index+1,index,dp);
        }
        int nopick = solve(nums,index+1,prev,dp);
        return dp[index][prev+1] = Math.max(pick,nopick);
        
        
    }
}