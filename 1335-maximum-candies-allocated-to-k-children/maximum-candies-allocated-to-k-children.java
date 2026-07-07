class Solution {
    public int maximumCandies(int[] candies, long k) {
        Arrays.sort(candies);
        int l=1;
        int h=candies[candies.length-1];
        int n=candies.length;
        int res=0;
       long sum=0;
       for(int i=0;i<n;i++){
        sum+=candies[i];
       }
       if(sum<k) return 0;

       while(l<=h){
        int guess=(l+h)/2;

        if(can(candies,n,guess)>=k){
            res=guess;
            l=guess+1;
        }
        else{
            
           h=guess-1;
        }
       }
       return res;


    }

long can(int [] arr,int n,int guess){

 long children=0;

 
 for(int i=0;i<n;i++){

children+=arr[i]/guess;


 }
 return children;


    }
}