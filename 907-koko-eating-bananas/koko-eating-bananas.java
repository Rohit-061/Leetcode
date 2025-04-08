class Solution {
  public int minEatingSpeed(int[] piles, int h){
    int low=1;
    int high=piles[0];
    int ans=0;
    for(int num:piles){
        high=Math.max(num,high);
    }
    while(low<=high){
        int mid=(low+high)/2;
        if(IsItPossible(piles,mid,h)){
            ans=mid;
            high=mid-1;
        }
        else{
            low=mid+1;
        }
    }
    return ans;

  }
  public boolean IsItPossible(int piles[],int mid,int totalhour){
    int h=0;
    for(int i=0;i<piles.length;i++){
        if(piles[i]<=mid){
            h++;
        }
        else if(piles[i]%mid==0){
            h=h+piles[i]/mid;
        }
        else{
            h=h+piles[i]/mid+1;
        }
        if(h>totalhour){
            return false;
        }
    }
    return true;
  }  
}