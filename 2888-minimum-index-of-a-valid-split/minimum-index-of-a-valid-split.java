class Solution {

    // Method to find the minimum index where the most frequent number occurs 
    // more frequently than all other numbers both to the left and to the right of the index.
    public int minimumIndex(List<Integer> nums) {
        int mostFrequentNum = 0;  // variable to store the most frequent number
        int maxFrequency = 0;     // variable to store the maximum frequency count
        Map<Integer, Integer> frequencyMap = new HashMap<>();  // map to store the frequency of each number

        // Count frequencies of each number in nums using a hashmap and record the most frequent number.
        for (int value : nums) {
            int currentFrequency = frequencyMap.merge(value, 1, Integer::sum);
            if (maxFrequency < currentFrequency) {
                maxFrequency = currentFrequency;
                mostFrequentNum = value;
            }
        }

        // Iterate over the list to find the minimum index where the most frequent number 
        // is more common than other elements to its left and right.
        int currentFreqCount = 0; // to keep the running count of the most frequent number
        for (int i = 1; i <= nums.size(); i++) {
            if (nums.get(i - 1).equals(mostFrequentNum)) {
                currentFreqCount++;
                // Check if the most frequent number is more frequent than the remaining numbers 
                // on both sides of the current index.
                if (currentFreqCount * 2 > i && (maxFrequency - currentFreqCount) * 2 > nums.size() - i) {
                    return i - 1; // Return the index if condition is met
                }
            }
        }

        return -1; // Return -1 if no such index is found
    }
}