public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        int n = nums.Length;
        Dictionary<int,int> map = new Dictionary<int,int>();
        for(int i=0;i<n;i++){
            int comp = target-nums[i];
            if(map.ContainsKey(comp)){
                return new int[]{map[comp],i};

            }
            if(!map.ContainsKey(nums[i])){
                map[nums[i]] = i;
            }
        }
        return new int[]{ };
    }
}