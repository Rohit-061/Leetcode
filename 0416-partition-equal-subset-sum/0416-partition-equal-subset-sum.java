class Solution {
    int n;
    public boolean canPartition(int[] nums) {
        n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum%2 != 0) return false; 
        int x = sum/2;
        int[][] dp = new int[n+1][x+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return solve(nums,x,0,dp);
    }
    public boolean solve(int[] nums,int x,int i,int[][] dp){
        if(x==0) return true;
        if(i>=n) return false;
        if(dp[i][x]!=-1) return dp[i][x]==1;
        boolean take=false;
        if(x>=nums[i]){
            take = solve(nums,x-nums[i],i+1,dp);
        }
        boolean skip = solve(nums,x,i+1,dp);
        boolean result =  take || skip;
        dp[i][x] = result?1:0;
        return result;
        
    }
}