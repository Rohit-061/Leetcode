class Solution {
    static int mod = (int)1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] ple = new int[n];
        int[] nle = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Previous Less Element (PLE)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        // Next Less Element (NLE)
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long contrib = (long) arr[i] * ple[i] * nle[i];
            ans = (ans + contrib) % mod;
        }
        return (int) ans;
    }
}
