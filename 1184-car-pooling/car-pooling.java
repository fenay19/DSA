class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
       int []pass=new int[1001] ;
       for(int []x:trips){
        int p=x[0];
        int f=x[1];
        int dest=x[2];

        pass[f]+=p;
        pass[dest]-=p;
       }
       int curr=0;
       for(int i=0;i<pass.length;i++){
        curr+=pass[i];
        if(curr>capacity){
            return false;
        }
       }
return true;
    }
}