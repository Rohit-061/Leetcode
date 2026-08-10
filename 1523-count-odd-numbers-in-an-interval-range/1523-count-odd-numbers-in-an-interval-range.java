class Solution {
    public int countOdds(int low, int high) {
        int count=0;
        if(low%2==0 && high%2==0){
            low = low+1;
            high = high-1;
            count = (high-low)/2;
        }
        else{
            count = (high-low)/2;
        }
        return count+1;
        
    }
}