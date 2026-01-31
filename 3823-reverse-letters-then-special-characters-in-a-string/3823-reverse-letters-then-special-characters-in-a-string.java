class Solution {
    public String reverseByType(String s) {
        Stack<Character> l = new Stack<>();
        Stack<Character> sp = new Stack<>();
        for(char ch : s.toCharArray()){
            if(Character.isLowerCase(ch)){
                l.push(ch);
            }else{
                sp.push(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(Character.isLowerCase(ch)){
                res.append(l.pop());
            }else{
                res.append(sp.pop());
            }
        }
        return res.toString();

        
    }
}