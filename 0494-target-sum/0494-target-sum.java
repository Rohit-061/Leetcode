class Solution {
    int n;
    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        return solve(nums,0,0,target);
        
    }
    public int solve(int[] nums,int i,int sum,int target){
        if(i == n){
            if(sum == target) return 1;
            else return 0;
        }
      
        int add = solve(nums,i+1,sum + nums[i],target);
        int sub = solve(nums,i+1,sum-nums[i] ,target);
        return add+sub;

    }
}