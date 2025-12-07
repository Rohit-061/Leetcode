class Solution {
    public int fib(int n) {
        // base case
        // using recursion
        //if(n<=1) return n;
        //return fib(n-1) + fib(n-2);
        int ans[] = new int [n+1];
        Arrays.fill(ans,-1);
        return recur(n,ans);
    }
    public int recur(int n, int ans[]) {
        // base case
        if(n<=1){ 
            ans[n]=n;
            return ans[n];
        }
        if (ans[n]!=-1){
            return ans[n];
        }
        ans[n] = fib(n-1) + fib(n-2);
        return ans[n];
    }
}