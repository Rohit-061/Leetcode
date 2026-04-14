class Solution {
    String ans = "";
    public String longestPalindrome(String s) {
        int [][] dp = new int[1001][1001];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        solve(s,0,s.length()-1,dp);
        return ans;
    }
    public int solve(String s, int i, int j,int[][] dp){
        if(i>j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(isPal(i,j,s)){
            if(j-i+1>ans.length())
                ans = s.substring(i,j+1);
        }
        dp[i][j]=solve(s,i+1,j,dp);
        dp[i][j]=solve(s,i,j-1,dp);
        return 0;
    }
    public boolean isPal(int l,int r,String s){
        if(l>=r) return true;
        if(s.charAt(l)!=s.charAt(r)) return false;
        return isPal(l+1,r-1,s);
    }
}