class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freqArr = new int[101];
        int maxFreq=0;
        int sumFreq=0;
        for(int i : nums){
            freqArr[i]++;
            int currFreq = freqArr[i];
            if(currFreq>maxFreq){
                maxFreq = currFreq;
                sumFreq = currFreq;
            }else if(currFreq == maxFreq){
                sumFreq += currFreq;
            }
        }
        return sumFreq;
    }
}