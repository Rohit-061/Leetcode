class Solution {
    public int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        for(int i=0;i<nums.length;i++){
            int mid=(start+end)/2;
            if(target==nums[mid]){
                return mid;
            }
            else if(target>nums[mid]){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return start;
    }
}