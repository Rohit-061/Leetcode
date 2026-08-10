class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        solve(nums, n,0);
        return res;
    }
    public void solve(int[] nums,int n,int index){
    
        res.add(new ArrayList<>(ans));

        for (int i = index; i < n; i++) {
            ans.add(nums[i]);

            // Explore
            solve(nums, n, i + 1);

            // Backtrack (undo choice)
            ans.remove(ans.size() - 1);
        }
    }
}