import java.util.Arrays;

class Solution {

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        // Get the number of strings in the nums array and the total number of queries.
        int numOfStrings = nums.length;
        int numOfQueries = queries.length;
      
        // Create an array to store the answers for each query.
        int[] answers = new int[numOfQueries];
      
        // Initialize a 2D array to store both the trimmed string and its original index.
        String[][] trimmedAndIndices = new String[numOfStrings][2];
      
        // Iterate over each query
        for (int i = 0; i < numOfQueries; ++i) {
            // Extract the k-th value and the trim length from the current query.
            int k = queries[i][0];
            int trimLength = queries[i][1];
          
            for (int j = 0; j < numOfStrings; ++j) {
                // Trim each string in nums from the end by the given trim length and store the result along with the original index.
                trimmedAndIndices[j] = new String[] {
                    nums[j].substring(nums[j].length() - trimLength),
                    String.valueOf(j)
                };
            }
          
            // Sort the array of trimmed strings and indices.
            Arrays.sort(trimmedAndIndices, (a, b) -> {
                // Compare trimmed strings.
                int comparison = a[0].compareTo(b[0]);
                // If equal, compare their original indices.
                return comparison == 0 ? Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1])) : comparison;
            });
          
            // Get the index of the k-th smallest trimmed string.
            answers[i] = Integer.parseInt(trimmedAndIndices[k - 1][1]);
        }
      
        // Return the array of answers.
        return answers;
    }
}