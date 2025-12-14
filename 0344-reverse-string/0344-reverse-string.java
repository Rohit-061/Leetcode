class Solution {
    public void reverseString(char[] s) {
        //int n = s.length;
        RS(s,0);
    }
    public void RS(char[] s, int i){
        int n = s.length;
        if(i==s.length/2) return ;
        RS(s,i+1);
        swap(s,i,n-i-1);
    }
    public void swap(char[]s ,int i1, int i2){
        char temp = s[i1];
        s[i1] = s[i2];
        s[i2] = temp;
    }
}