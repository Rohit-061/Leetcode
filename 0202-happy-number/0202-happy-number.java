class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=0 && !set.contains(n)){
            set.add(n);
            int x = 0;
            while(n!=0){
                x += (n%10) * (n%10);
                n /= 10;
            }
            n = x;
        }
        return n==1;
    }

}