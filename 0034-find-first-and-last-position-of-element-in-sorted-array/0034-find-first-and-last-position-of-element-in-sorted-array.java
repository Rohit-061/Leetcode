class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        int first = -1, last = -1;

        //Finding first occurence
        while(lo<=hi) {
            int mid = (hi-lo)/2 + lo;
            
            if(nums[mid]<target)
                lo = mid+1;
            else if (nums[mid]>target)
                hi = mid-1;
            else {
                hi = mid-1;
                first = mid;
            }
        }    
        lo=0;
        hi=nums.length-1;

        //Finding last occurence
        while(lo<=hi) {
            int mid = (hi-lo)/2 + lo;

            if(nums[mid]<target)
                lo = mid+1;
            else if(nums[mid]>target)
                hi = mid-1;
            else {
                lo = mid+1;
                last = mid;
            }
        }

        return new int[]{first,last};

    }
}