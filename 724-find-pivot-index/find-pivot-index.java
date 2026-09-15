class Solution {
    public int pivotIndex(int[] nums) {
            int lsum=0;
        int rsum=0;
        int t=0;
        for(int x:nums){
            t+=x;
        }

        for(int i=0;i<nums.length;i++){
            rsum=t-lsum-nums[i];
            if(rsum==lsum){
                return i;
            }
            lsum+=nums[i];
        }
        return -1;
    }
}