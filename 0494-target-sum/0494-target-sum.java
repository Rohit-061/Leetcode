class Solution {
    int n,s;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        s = 0;
        for(int num: nums){
            s += num;
        }
        int[][] dp = new int[n+1][2*s+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(nums,0,0,target,dp);
        
    }
    public int solve(int[] nums,int i,int sum,int target,int[][] dp){
        if(i == n){
            if(sum == target) return 1;
            else return 0;
        }
        if(dp[i][sum+s]!=-1) return dp[i][sum+s];
        int add = solve(nums,i+1,sum + nums[i],target,dp);
        int sub = solve(nums,i+1,sum-nums[i] ,target,dp);
        dp[i][sum+s] = add+sub;
        return dp[i][sum+s];

    }
}