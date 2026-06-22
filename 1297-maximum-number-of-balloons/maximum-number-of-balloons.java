class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char i : text.toCharArray()){
            if(i == 'b' || i == 'a' || i == 'l' || i == 'o' || i == 'n'){
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }
        int single = Math.min(map.getOrDefault('b',0), Math.min(map.getOrDefault('a',0),map.getOrDefault('n',0)));
        int doubl = Math.min(map.getOrDefault('l',0)/2,map.getOrDefault('o',0)/2);
        return Math.min(single,doubl);
    }
}