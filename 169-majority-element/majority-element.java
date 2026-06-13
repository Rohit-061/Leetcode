class Solution {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == num){
                count++;
            }
            else if(nums[i]!=num && count==0){
                num = nums[i];
                count = 1;
            }else if (nums[i]!=num && count!=0){
                count--;
            }
        }
        return num;
    }
}