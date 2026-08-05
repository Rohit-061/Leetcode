class Solution {
    public int numDecodings(String s) {
        int  n = s.length();
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(s, 0, n,dp);
    }
    public int solve (String s, int i, int n, int[] dp){
        if(i == n) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i]!=-1) return dp[i];
        int step2 = 0;
        if(i+1<n){
            if(s.charAt(i)=='1' || s.charAt(i) == '2' && s.charAt(i+1) <= '6'){
                step2 = solve(s,i+2,n,dp);
            }
        }
        int step1 = solve(s,i+1,n,dp);
        dp[i] = step1+step2;
        return dp[i];

    }
}