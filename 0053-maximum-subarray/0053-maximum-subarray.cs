public class Solution {
    public int MaxSubArray(int[] nums) {
        int n = nums.Length;
        int curr = nums[0];
        int max = nums[0];
        for(int i=1;i<n;i++){
            curr = Math.Max(nums[i],curr+nums[i]);
            max = Math.Max(max,curr);
        }
        return max;
    }
}