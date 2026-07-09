class Solution {
    int n, m;

    public int longestCommonSubsequence(String text1, String text2) {
        n = text1.length();
        m = text2.length();
        int[][] dp = new int[n+1][m+1]; // fix size
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                dp[i][j] = -1;
            }
        }
        return solve(n, m, text1, text2, dp);
    }

    public int solve(int i, int j, String text1, String text2, int[][] dp){
        if(i == 0 || j == 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(text1.charAt(i-1) == text2.charAt(j-1)){
            dp[i][j] = 1 + solve(i-1, j-1, text1, text2, dp);
        } else {
            int case1 = solve(i-1, j, text1, text2, dp);
            int case2 = solve(i, j-1, text1, text2, dp);
            dp[i][j] = Math.max(case1, case2); // fix here
        }
        return dp[i][j];
    }
}
