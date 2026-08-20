class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> StoT = new HashMap<>();
        HashMap<Character,Character> TtoS = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            if(!StoT.containsKey(s1)){
                StoT.put(s1,t1);
            }
            if(!TtoS.containsKey(t1)){
                TtoS.put(t1,s1);
            }
            if(StoT.get(s1)!=t1 || TtoS.get(t1)!=s1){
                return false;
            }
        }
        return true;

    }
}