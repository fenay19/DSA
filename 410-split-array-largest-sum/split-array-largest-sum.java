class Solution {
    public int splitArray(int[] nums, int k) {
        int n=nums.length;
        if(n<k) return -1;
int sum=0;
int max=0;
        for(int i=0;i<n;i++){
max=Math.max(nums[i],max);
sum+=nums[i];
        }

        long l=max;
        long h=sum;
        while(l<=h){
            long m=(l+h)/2;

            if(subar(nums,n,m,k)){
                h=m-1;
            }
            else{
                l=m+1;
            }
        }
        return (int) l;
    }
    boolean subar(int [] arr,int n,long m,int k){
int sub=1;
int sum=0;
for(int i=0;i<n;i++){
    if(sum+arr[i]<=m){
        sum=sum+arr[i];
    }
    else{
sub++;
sum=arr[i];


    }
    if(sub>k) return false;
}

  return true;

    }
  
}