class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res  = new ArrayList<>();
        res.add(List.of(1));
        for(int i=0;i<numRows-1;i++){
            List<Integer> g  = new ArrayList<>();
            g.add(1);
            for(int j=1;j<res.get(i).size();++j){
                g.add(res.get(i).get(j-1)+res.get(i).get(j));
            }
            g.add(1);
            res.add(g);
        }
        return res;
        
    }
}