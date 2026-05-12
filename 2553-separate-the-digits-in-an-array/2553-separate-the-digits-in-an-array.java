class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            int num = nums[i];
            while(num!=0){
                int rem = num%10;
                list.add(0,rem);
                num = num/10;
            }
        }
        int i=0;
        int len = list.size();
        int[] arr = new int[len];
        for(Integer num:list){
            arr[i++]=num;
        }
        return arr;
    }
}