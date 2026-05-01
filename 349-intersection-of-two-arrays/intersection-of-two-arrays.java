class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int n2 : nums2){
            set.add(n2);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int n1 : nums1){
            if(set.contains(n1)){
                arr.add(n1);
                set.remove(n1);
            }
        }
        int[] res = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            res[i] = arr.get(i);
        }
        return res;
    }
}