class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0;
        
        int n=nums.length;
        int max=0;
        int cnt=0;
   for(int h=0;h<n;h++){
    if(nums[h]==0){
        cnt++;

    }

    while(cnt>k){
        if(nums[l]==0){
        cnt--;}

        l++;
    }

    int res=h-l+1;
    max=Math.max(max,res);
   }
   return max;
    }
}