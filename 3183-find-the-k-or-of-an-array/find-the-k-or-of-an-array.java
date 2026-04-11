class Solution {
    public int findKOr(int[] nums, int k) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<32;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(((nums[j]>>i) & 1)==1){
                    count++;
                } 
            }
            if(count>=k){
                ans = ans+(1<<i);
            }
        }
        return ans;
    }
}