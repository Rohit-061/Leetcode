class Solution {
    public String longestPrefix(String s) {
        char Pattern[] = s.toCharArray();
        int lps[]=new int[s.length()];
        lps[0]=0;
        int pre=0;
        for(int suf=1;suf<Pattern.length;){
            if(Pattern[pre]==Pattern[suf]){
                lps[suf]=pre+1;
                pre++;
                suf++;
            }
            else{
                if(pre!=0){
                    pre=lps[pre-1];
                }
                else{
                    lps[suf]=0;
                    suf++;
                }
            }    
        }
        return s.substring(0,lps[lps.length-1]);

    }
}