class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningSum = 0;
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            runningSum = (runningSum + nums[currentIndex]) % k;
            if (!map.containsKey(runningSum)) {
                map.put(runningSum, currentIndex);
            } else if (currentIndex - map.get(runningSum) > 1) {
                return true;
            }
        }
        return false;
    }
}
