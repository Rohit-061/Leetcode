class Solution{
    public String shortestCommonSupersequence(String str1, String str2) {
        int s1l = str1.length();
        int s2l = str2.length();

        int [][]dp = new int[s1l+1][s2l+1];
        String ans= "";
        for(int i=1;i<=s1l;i++){
            for(int j=1;j<=s2l;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }   
        }
        // for(int []c : dp){
        //     System.out.println(Arrays.toString(c));
        // }
        int x = s1l,y=s2l;
        //craft the answer
        while(x>0 && y >0){
            if(dp[x][y] == dp[x][y-1]){
                ans = str2.charAt(y-1) + ans;
                y--;
            }else if(dp[x][y] == dp[x-1][y]){
                ans = str1.charAt(x-1) + ans;
                x--;
            }else{
                ans = str1.charAt(x-1) + ans; // just pick either str1 or str2
                x--;
                y--;
            }
        }
	// for letter that haven't been processed
        while(x >0){
            ans = str1.charAt(x-1) + ans;
            x--;
        }
        while(y >0){
            ans = str2.charAt(y-1) + ans;
            y--;
        }
        return ans;
    }
}