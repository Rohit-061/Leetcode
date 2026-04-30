class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int ns = s.length();
        int np = p.length();
        if(np>ns){
            return new ArrayList();
        }
        List<Integer> res = new ArrayList<>();
        int[] ref = new int[26];
        int[] slidcount = new int[26];
        for(char c : p.toCharArray()){
            ref[c - 'a']++;
        }
        for(char c : s.substring(0,np).toCharArray()){
            slidcount[c - 'a']++;
        }
        if(Arrays.equals(ref,slidcount)){
            res.add(0);
        }
        for(int i=1;i<ns-np+1;i++){
            slidcount[s.charAt(i-1)-'a']--;
            slidcount[s.charAt(i+np-1)-'a']++;
            if(Arrays.equals(ref,slidcount)){
                res.add(i);
            }
        }
        return res;
    }
}