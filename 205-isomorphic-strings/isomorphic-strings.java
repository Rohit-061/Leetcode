class Solution {
    public boolean isIsomorphic(String s, String t) {
        // HashMap<Character,Character> StoT = new HashMap<>();
        // HashMap<Character,Character> TtoS = new HashMap<>();
        int[] StoT = new int[128];
        int[] TtoS = new int[128];
        Arrays.fill(StoT,-1);
        Arrays.fill(TtoS,-1);
        
        for(int i=0;i<s.length();i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            if(StoT[s1]==-1){
                StoT[s1] = t1;
            }
            if(TtoS[t1]==-1){
                TtoS[t1] = s1;
            }
            if(StoT[s1]!=t1 || TtoS[t1]!=s1){
                return false;
            }
        }
        return true;

    }
}