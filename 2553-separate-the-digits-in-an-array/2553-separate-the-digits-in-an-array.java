class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        
        ArrayList<Integer> arr =  new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            int num = nums[i];
            while(num!=0){
                int x = num%10;
                arr.add(0,x);
                num = num/10;
            }
        }
        int[] res = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            res[i] = arr.get(i);
        }
        return res;
    }
}