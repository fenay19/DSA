class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
      Arrays.sort(piles);
        int l=1;
        int hi=piles[piles.length-1];
        int res=0;
         
        while(l<=hi){
int guessk=(l+hi)/2;

if(hrsgiver(piles,n,guessk)>h){
l=guessk+1;

        }
        else{

res=guessk;
hi=guessk-1;

        }
        
    }
    return res;
    }
    long hrsgiver(int [] arr,int n,int k){

long h=0;
for(int i=0;i<n;i++){

h=h+arr[i]/k;
if(arr[i]%k!=0){
    h++;
}

}
return h;


    }
}