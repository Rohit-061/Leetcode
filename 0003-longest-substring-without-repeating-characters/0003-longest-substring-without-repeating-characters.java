class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        int l=0;
        int r=0;
        char[] arr = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for(r=0;r<s.length();r++){
            int idx = map.getOrDefault(arr[r],-1);
            if(idx>=l && idx!=-1){
                ans = Math.max(ans,r-1-l+1);
                l = idx+1;
            }
            map.put(arr[r],r);
        }
        return Math.max(ans,r-1-l+1);
    }
}