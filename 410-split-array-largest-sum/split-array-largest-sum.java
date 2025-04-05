class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0;
        int high=0;
        int ans=0;
        for(int num:nums){
            high=high+num;
        }
        while(low<=high){
            int mid=(low+high)/2; // maximum number pages read  by a student
            if(IsItPossible(nums,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean IsItPossible(int nums[] , int k, int mid){
        int s=1;
        int sum=0;
        for(int i=0;i< nums.length;){
            if(sum+nums[i]<=mid){
                sum=sum+nums[i];
                i++;
            }
            else{
                s++;
                sum=0;
            }
            if(s>k){
                return false;
            }
        }
        return true;
    }
}