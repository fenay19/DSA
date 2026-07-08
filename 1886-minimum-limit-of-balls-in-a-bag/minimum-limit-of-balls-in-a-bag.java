class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int l=1;
        int h=nums[nums.length-1];

        int res=-1;

        while(l<=h){
int m=(l+h)/2;
if(validopr(nums,nums.length,m)>maxOperations){


l=m+1;

}
else{
    res=m;
    h=m-1;
}



        }
        return res;
    }
    long validopr(int [] arr,int n,int guess){
long opr=0;

for(int i=0;i<n;i++){

opr+=(arr[i]-1)/guess;

}
return opr;



    }
}