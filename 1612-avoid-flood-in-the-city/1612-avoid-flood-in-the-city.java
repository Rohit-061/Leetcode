class Solution {
    public int[] avoidFlood(int[] rains) {
        int [] ans=new int [rains.length];
        Arrays.fill(ans,1);
        TreeSet<Integer> set=new TreeSet<>();
        Map<Integer, Integer>map=new HashMap<>();
        for(int i=0;i<rains.length;i++){
            if(rains[i]==0){
                set.add(i);
            }else{
                ans[i]=-1;
                if(map.containsKey(rains[i])){
                    Integer it = set.ceiling(map.get(rains[i]));
                    if(it == null){
                        return new int[0];
                    }
                    ans[it] = rains[i];
                    set.remove(it);
                }
                map.put(rains[i],i);
            }
        }
        return ans;
    }
}