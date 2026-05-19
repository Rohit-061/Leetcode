class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ans = -1;
        int i=0;
        int j=0;
        while(i<n && j<m){
            if(nums1[i]==nums2[j]){
                ans = Math.max(ans, nums1[i]);
                i++;
                j++;
                break;
            }else if(nums1[i]<nums2[j]){
                i++;
            }else{
                j++;
            }
            
        }
        return ans;
    }
}