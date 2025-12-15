class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i=0;i<nums.length;i++) sum += nums[i];

        // If sum is odd, cannot partition
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int n = nums.length;

        int[][] dp = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(dp, n, target, nums);
    }

    static boolean solve(int[][] dp, int n, int sum, int[] nums) {
        // Base cases
        if (sum == 0) return true;
        if (n == 0) return false;

        if (dp[n][sum] != -1)
            return dp[n][sum] == 1;

        boolean result;
        if (nums[n - 1] <= sum) {
            boolean include = solve(dp, n - 1, sum - nums[n - 1], nums);
            boolean exclude = solve(dp, n - 1, sum, nums);
            result = include || exclude;
        } else {
            result = solve(dp, n - 1, sum, nums);
        }

        dp[n][sum] = result ? 1 : 0;
        return result;
    }
}
