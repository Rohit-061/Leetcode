class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        Generate(n,0,0,"",list);
        return list;
    }
    public static void Generate(int n, int open, int close, String ans,List<String> list){
        if(ans.length()==2*n){
            list.add(ans);
            return;
        }
        if(open<n){
            Generate(n,open+1,close,ans+"(",list);
        }
        if(close<open){
            Generate(n,open,close+1,ans+")",list);
        }
    }
}