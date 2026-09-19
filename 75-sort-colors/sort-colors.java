class Solution {
    public void sortColors(int[] nums) {
        int l=0;
        int m=0;
        int e=nums.length-1;

        while(m<=e){

if(nums[m]==0){
    int tmp=nums[m];
    nums[m]=nums[l];
    nums[l]=tmp;
    l++;
    m++;

}
else if(nums[m]==1){
    m++;
}
else{
    int tmp=nums[m];
    nums[m]=nums[e];
    nums[e]=tmp;
    e--;
}

        }
    }
}