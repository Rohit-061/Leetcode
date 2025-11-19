class Solution {
    
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n/2 - 1; i >= 0; i--)
         heapify(nums, n, i);  // build heap
        for (int i = n - 1; i > 0; i--) {
            int t = nums[0]; 
            nums[0] = nums[i]; 
            nums[i] = t;
            heapify(nums, i, 0);
        }
        return nums;
    }
    static void heapify(int[] nums, int n, int i) {
        int largest = i, l = 2*i + 1, r = 2*i + 2;
        if (l < n && nums[l] > nums[largest]) largest = l;
        if (r < n && nums[r] > nums[largest]) largest = r;
        if (largest != i) {
            int t = nums[i]; nums[i] =  nums[largest]; nums[largest] = t;
            heapify(nums, n, largest);
        }
    }
} 