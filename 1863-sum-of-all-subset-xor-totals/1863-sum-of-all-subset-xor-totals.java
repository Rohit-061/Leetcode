class Solution {
    // To keep track of the accumulated result of all subset XORs.
    private int totalXorSum;

    // Public method to initiate the XOR sum calculation process.
    public int subsetXORSum(int[] nums) {
        // Start depth-first search (DFS) from the beginning of the array with initial XOR sum as 0.
        dfs(nums, 0, 0);
        return totalXorSum;
    }

    // Helper method to perform depth-first search (DFS) for subsets and calculate XOR sum.
    private void dfs(int[] nums, int index, int currentXor) {
        // Add the current XOR sum of the subset to the total result.
        totalXorSum += currentXor;
        // Proceed to find other subsets and calculate their XOR.
        for (int i = index; i < nums.length; i++) {
            // Include the next number in the subset and update the current XOR.
            currentXor ^= nums[i];
            // Recurse with the new subset XOR and the next index.
            dfs(nums, i + 1, currentXor);
            // Exclude the last number from the current subset to backtrack for the next iteration.
            currentXor ^= nums[i];
        }
    }
}