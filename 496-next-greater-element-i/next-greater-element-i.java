class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n1 = nums1.length;
        int n2 = nums2.length;

        
        for (int i = n2 - 1; i >= 0; i--) {
            int currentNum = nums2[i];

            
            while (!stack.isEmpty() && stack.peek() <= currentNum) {
                stack.pop();
            }

            
            if (!stack.isEmpty()) {
                map.put(currentNum, stack.peek());
            } else {
                map.put(currentNum, -1);
            }

            
            stack.push(currentNum);
        }

        
        int[] ans = new int[n1];
        for (int i = 0; i < n1; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}
